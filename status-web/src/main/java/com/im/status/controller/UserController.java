package com.im.status.controller;

import com.im.status.base.cache.RedisCache;
import com.im.status.base.constants.Const;
import com.im.status.base.logger.StatusLogger;
import com.im.status.base.model.RespCode;
import com.im.status.base.model.RespModel;
import com.im.status.base.util.ParamUtil;
import com.im.status.service.UserService;
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

    @Autowired
    private RedisCache redisCache;

    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
    @ResponseBody
    public void register(HttpServletResponse response, HttpServletRequest request){

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
            boolean flag = true;
            if(!ParamUtil.checkPhone(username)){
                this.failed(respModel,RespCode.QUERY_PARAM_ERROR);
                flag = false;
            }
            if(flag){
                respModel = userService.sendCode(username,type);
                if(respModel.getRespCode().equals(RespCode.SUCCESS.getReturnCode()))
                    redisCache.set(username+type, respModel.getRespData(), Const.MESSAGE_OUT_TIME);
            }
            logger.info("验证码发送成功,userName:"+username+",code:"+respModel.getRespData());
            this.success(response,respModel);
        } catch (Exception e) {
            logger.error(e);
            failed(respModel,e.getMessage());
            writeResponse(response,respModel);
        }finally{
            logger.info("发送验证码结束");
        }
    }

}
