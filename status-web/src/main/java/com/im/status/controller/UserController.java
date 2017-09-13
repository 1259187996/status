package com.im.status.controller;

import com.im.status.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhizhuang.yang
 * @date 2017年9月12日
 * @version 1.0.0
 * @description 用户相关的controller
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{


    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;


}
