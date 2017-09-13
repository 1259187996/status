package com.im.status.service.impl;

import com.im.status.base.model.Const;
import com.im.status.base.model.RespCode;
import com.im.status.base.model.RespModel;
import com.im.status.base.model.StatusException;
import com.im.status.mapper.TSmsLogMapper;
import com.im.status.mapper.TUserMapper;
import com.im.status.model.req.UserReq;
import com.im.status.model.request.RegisterParam;
import com.im.status.model.user.TSmsLog;
import com.im.status.model.user.TUser;
import com.im.status.service.UserService;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Created by zhizhuang.yang on 2017/9/12.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private TUserMapper tUserMapper;

    @Autowired
    private TSmsLogMapper tSmsLogMapper;

    public String register(RegisterParam registerParam) {
        return null;
    }

    public RespModel<String> sendCode(String username, String type) throws StatusException {
        RespModel<String> respModel = new RespModel<String>();
        UserReq userReq = new UserReq();
        userReq.setUserName(username);
        List<TUser> userInfos = tUserMapper.select(userReq);
        String code = getMessageCode();
        respModel.setRespData(code);
        if(type.equals(Const.MESSAGE_TYPE_REISTER)){
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

    //生成验证码
    public static String getMessageCode(){
        Random random = new Random();
        return String.valueOf(100000+random.nextInt(899999));
    }

    //发送短信
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
            e.printStackTrace();
        }
        String status="";
        if(rsp.isSuccess()){
            status = RespCode.SUCCESS.getReturnCode();
        }else{
            status = RespCode.SYSTEM_EXCEPTION.getReturnCode();
            flag = false;
        }
        try{
            //插入信息到数据库
            TSmsLog smsLog = new TSmsLog();
            smsLog.setMoblieNumber(phone);
            smsLog.setSmsCode(code);
            smsLog.setSmsStatus(status);
            smsLog.setSmsType(type);
            smsLog.setSmsContent(code);
            tSmsLogMapper.insert(smsLog);
        }catch(Exception e){
            logger.info("发送短信异常:" + e);
        }
        return flag;
    }
}
