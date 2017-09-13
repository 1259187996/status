package com.im.status.controller;

import com.im.status.base.logger.StatusLogger;
import com.im.status.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
    public void register(HttpServletResponse response, HttpServletRequest request){

    }

}
