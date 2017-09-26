package com.im.status.controller;

import com.im.status.base.exception.StatusException;
import com.im.status.base.logger.StatusLogger;
import com.im.status.base.model.RespCode;
import com.im.status.base.model.RespModel;
import com.im.status.base.util.ParamUtil;
import com.im.status.model.request.RegisterParam;
import com.im.status.model.response.LoginResp;
import com.im.status.model.user.TUser;
import com.im.status.service.UserService;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhizhuang.yang
 * @date 2017年9月12日
 * @version 1.0.0
 * @description 用户相关的controller
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    private StatusLogger logger = StatusLogger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 注册
     * @param username
     * @param password
     * @param smsCode
     * @param channel
     * @param request
     * @param response
     */
    @RequestMapping(value="/register",method=RequestMethod.POST)
    @ResponseBody
    public void register(HttpServletRequest request,HttpServletResponse response,
                         @Param("username")String username,@Param("password")String password,@Param("rePassword")String rePassword,
                         @Param("smsCode")String smsCode,@Param("channel")String channel){
        logger.info("注册,入参："+ JSONObject.fromObject(request.getParameterMap()));
        RespModel<String> respModel = new RespModel<String>();
        try {
            if(checkRegisterParam(username,password,rePassword,smsCode,channel)){
                RegisterParam registerParam = new RegisterParam();
                registerParam.setUserName(username);
                registerParam.setPassword(password);
                registerParam.setSmsCode(smsCode);
                registerParam.setChannel(channel);
                logger.info(registerParam.toString());
                respModel = userService.register(registerParam);
                logger.info("注册成功,userName:"+username+",userId:"+respModel.getRespData());
                this.success(respModel);
            }else{
                this.failed(respModel,RespCode.QUERY_PARAM_ERROR);
            }
        }catch (StatusException e){
            failed(respModel,e.getRespCode());
            logger.error(e);
        }catch (Exception e) {
            failed(respModel,e.getMessage());
            logger.error(e);
        }finally{
            this.writeResponse(response,respModel);
            logger.info("注册结束");
        }
    }

    private boolean checkRegisterParam(String username, String password, String rePassword, String smsCode, String channel) {
        return true;
    }

    /**
     * 登录
     * @param username
     * @param password
     * @param request
     * @param response
     */
    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public void login(HttpServletRequest request,HttpServletResponse response,
                         @Param("username")String username,@Param("password")String password){
        logger.info("登录,入参："+ JSONObject.fromObject(request.getParameterMap()));
        RespModel<LoginResp> respModel = new RespModel<LoginResp>();
        try {
            if(checkLoginParam(username,password)){
                respModel = userService.login(username,password,request);
                logger.info("登录成功,userName:"+username);
                this.success(respModel);
            }else{
                this.failed(respModel,RespCode.QUERY_PARAM_ERROR);
            }
        }catch (StatusException e){
            failed(respModel,e.getRespCode());
            logger.error(e);
        }catch (Exception e) {
            failed(respModel,e.getMessage());
            logger.error(e);
        }finally{
            this.writeResponse(response,respModel);
            logger.info("登录结束");
        }
    }

    private boolean checkLoginParam(String username, String password) {
        return true;
    }


    /**
     * 发送验证码
     * @param username
     * @param type
     * @param request
     * @param response
     */
    @RequestMapping(value="/sendCode",method=RequestMethod.POST)
    @ResponseBody
    public void sendCode(HttpServletRequest request, HttpServletResponse response,
                         @Param("username")String username, @Param("type")String type){
        logger.info("发送验证码,username:"+username+",type:"+type);
        RespModel<String> respModel = new RespModel<String>();
        try {
            if(!ParamUtil.checkPhone(username)){
                this.failed(respModel,RespCode.QUERY_PARAM_ERROR);
            }else{
                respModel = userService.sendCode(username,type);
                logger.info("验证码发送成功,userName:"+username+",code:"+respModel.getRespData());
                this.success(respModel);
            }
        }catch (StatusException e){
            failed(respModel,e.getRespCode());
            logger.error(e);
        }catch (Exception e) {
            logger.error(e);
            failed(respModel,e.getMessage());
        }finally{
            writeResponse(response,respModel);
            logger.info("发送验证码结束");
        }
    }

}
