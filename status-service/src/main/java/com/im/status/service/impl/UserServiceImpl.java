package com.im.status.service.impl;

import com.im.status.base.cache.RedisCache;
import com.im.status.base.constants.Const;
import com.im.status.base.constants.UserState;
import com.im.status.base.constants.UserStatus;
import com.im.status.base.encryption.MD5Util;
import com.im.status.base.exception.StatusException;
import com.im.status.base.logger.StatusLogger;
import com.im.status.base.model.RespCode;
import com.im.status.base.model.RespModel;
import com.im.status.base.util.*;
import com.im.status.mapper.TSmsLogMapper;
import com.im.status.mapper.TUserInfoMapper;
import com.im.status.mapper.TUserLoginLogMapper;
import com.im.status.mapper.TUserMapper;
import com.im.status.model.req.UserReq;
import com.im.status.model.request.RegisterParam;
import com.im.status.model.response.LoginResp;
import com.im.status.model.user.TSmsLog;
import com.im.status.model.user.TUser;
import com.im.status.model.user.TUserInfo;
import com.im.status.model.user.TUserLoginLog;
import com.im.status.service.UserService;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by zhizhuang.yang on 2017/9/12.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private StatusLogger logger = StatusLogger.getLogger(UserServiceImpl.class);

    @Autowired
    private TUserMapper tUserMapper;

    @Autowired
    private TUserInfoMapper tUserInfoMapper;

    @Autowired
    private TSmsLogMapper tSmsLogMapper;

    @Autowired
    private TUserLoginLogMapper tUserLoginLogMapper;

    @Autowired
    private RedisCache redisCache;

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public RespModel<String> register(RegisterParam param) throws StatusException{
        RespModel<String> respModel = new RespModel<String>();
        String redisCode = redisCache.get(param.getUserName()+Const.MESSAGE_TYPE_REGISTER);
        if(!param.getSmsCode().equals(redisCode)){
            throw new StatusException(respModel,RespCode.SMS_CODE_ERROR);
        }
        UserReq userReq = new UserReq();
        userReq.setUserName(param.getUserName());
        logger.info(userReq.toString());
        List<TUser> userInfos = tUserMapper.select(userReq);
        if(!userInfos.isEmpty()){
            throw new StatusException(respModel,RespCode.REGISTER_USER_EXIST);
        }
        TUser tUser = new TUser();
        tUser.setUserId(Util.getUUID());
        tUser.setUserName(param.getUserName());
        tUser.setPassword(MD5Util.MD5(param.getPassword()));
        tUser.setMobileNumber(param.getUserName());
        tUser.setUserChannel(param.getChannel());
        tUser.setUserState(UserState.ENABLE.getStateCode());
        tUser.setUserStatus(UserStatus.OUT_LINE.getStatusCode());
        tUser.setRegisterTime(new Date());
        tUserMapper.insert(tUser);
        TUserInfo tUserInfo = new TUserInfo();
        tUserInfo.setUserId(tUser.getUserId());
        tUserInfo.setCreateTime(new Date());
        tUserInfoMapper.insert(tUserInfo);
        respModel.setRespData(tUser.getUserId());
        return respModel;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public RespModel<LoginResp> login(String userName, String password, HttpServletRequest request) throws StatusException {
        RespModel<LoginResp> respModel = new RespModel<LoginResp>();
        UserReq userReq = new UserReq();
        userReq.setUserName(userName);
        userReq.setPassword(MD5Util.MD5(password));
        List<TUser> tUsers = tUserMapper.select(userReq);
        if(!tUsers.isEmpty()&&tUsers.size()>0){
            LoginResp loginResp = new LoginResp();
            //TODO 生成token令牌
            String token = TokenUtil.getToken(tUsers.get(0).getUserId());
            loginResp.setToken(token);
            //将用户信息存放到redis
            TUserInfo tUserInfo = tUserInfoMapper.selectById(tUsers.get(0).getUserId());
            BeanUtils.copyProperties(tUsers.get(0),loginResp);
            BeanUtils.copyProperties(tUserInfo,loginResp);
            redisCache.set(token.getBytes(), SerializeUtil.serialize(loginResp),Const.USER_LOGIN_OUT_TIME);
            //登录返回
            respModel.setRespData(loginResp);
            String loginIp = RequestUtil.getReqIp(request);
            String loginAddr = AddressUtils.getAddrByIp(loginIp);
            String platForm = RequestUtil.getSysInfo(request);
            //执行登录成功
            loginSuccess(tUsers.get(0).getUserId(),platForm,loginIp,loginAddr,token);
        }else{
            //TODO 登录失败处理
        }
        return respModel;
    }

    /**
     * 登录成功后执行
     * @param userId
     * @param platForm
     * @param loginIp
     * @param loginAddr
     * @throws StatusException
     */
    public void loginSuccess(String userId,String platForm,String loginIp,String loginAddr,String token)throws StatusException{
        //插入登录成功日志
        TUserLoginLog tUserLoginLog = new TUserLoginLog();
        tUserLoginLog.setUserId(userId);
        tUserLoginLog.setLoginTime(new Date());
        tUserLoginLog.setLoginPlatform(platForm);
        tUserLoginLog.setLoginIp(loginIp);
        tUserLoginLog.setLoginAddr(loginAddr);
        tUserLoginLog.setUserToken(token);
        tUserLoginLogMapper.insert(tUserLoginLog);
        //修改用户最后登录时间和登录地点
        TUser user = new TUser();
        user.setLastLoginIp(loginIp);
        user.setLastLoginTime(new Date());
        user.setUserId(userId);
        tUserMapper.updateByIdSelective(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public RespModel<String> sendCode(String username, String type) throws StatusException {
        RespModel<String> respModel = new RespModel<String>();
        UserReq userReq = new UserReq();
        userReq.setUserName(username);
        logger.info(userReq.toString());
        List<TUser> userInfos = tUserMapper.select(userReq);
        String code = Util.getMessageCode();
        respModel.setRespData(code);
        if(type.equals(Const.MESSAGE_TYPE_REGISTER)){
            if(!userInfos.isEmpty()){
                throw new StatusException(respModel,RespCode.REGISTER_USER_EXIST);
            }else{
                if(!this.sendMessage(username, code, type)){
                    throw new StatusException(respModel,RespCode.MESSAGE_SEND_FAIL);
                }
            }
        }else if(type.equals(Const.MESSAGE_TYPE_FORGET)){
            if(userInfos.isEmpty()){
                throw new StatusException(respModel,RespCode.REGISTER_USER_NOT_EXIST);
            }else{
                if(!this.sendMessage(username, code, type)){
                    throw new StatusException(respModel,RespCode.MESSAGE_SEND_FAIL);
                }
            }
        }
        return respModel;
    }

    //发送短信
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean sendMessage(String phone,String code,String type)throws StatusException {
        boolean flag = true;
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        try {
            TaobaoClient client = new DefaultTaobaoClient(Const.SMS_URL, Const.SMS_APP_KEY, Const.SMS_APP_SECRET);
            AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
            req.setExtend(code);
            req.setSmsType("normal");
            req.setSmsFreeSignName(Const.SMS_SIGN_NAME);
            req.setSmsParamString("{\"code\":\""+code+"\"}");
            req.setRecNum(phone);
            req.setSmsTemplateCode(Const.SMS_TEMPLATE_CODE);
            rsp = client.execute(req);
        }catch (Exception e) {
            logger.error(RespCode.MESSAGE_SEND_FAIL.getCodeDesc(),e);
        }
        String status="";
        if(rsp.isSuccess()){
            status = RespCode.SUCCESS.getReturnCode();
            //将验证码存放到redis中
            redisCache.set(phone+type, code, Const.MESSAGE_OUT_TIME);
        }else{
            status = RespCode.SYSTEM_EXCEPTION.getReturnCode();
            flag = false;
        }
        //插入信息到数据库
        TSmsLog smsLog = new TSmsLog();
        smsLog.setMoblieNumber(phone);
        smsLog.setSmsCode(code);
        smsLog.setSmsStatus(status);
        smsLog.setSmsType(type);
        smsLog.setSmsContent(code);
        tSmsLogMapper.insert(smsLog);
        return flag;
    }

    @Transactional
    public void logout(String token) throws StatusException {
        //将redis中的用户信息移除
        redisCache.del(token.getBytes());
        //更改登录日志中的注销时间
        TUserLoginLog tUserLoginLog = new TUserLoginLog();
        tUserLoginLog.setUserToken(token);
        tUserLoginLog.setLogoutTime(new Date());
        tUserLoginLogMapper.updateByIdSelective(tUserLoginLog);
    }
}
