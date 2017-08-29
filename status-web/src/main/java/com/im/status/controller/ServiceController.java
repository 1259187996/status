package com.im.status.controller;

import com.im.status.model.TService;
import com.im.status.service.ServiceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by zhizhuang.yang on 2017/8/15.
 */
@Controller
@RequestMapping("/service")
public class ServiceController {

    Logger logger = Logger.getLogger(ServiceController.class);

    @Autowired
    private ServiceService serviceService;

    @RequestMapping("/get")
    public ModelAndView getService(ModelMap model){
        List<TService> list = serviceService.getService();
        logger.debug("获取service");
        model.addAttribute("list",list);
        return new ModelAndView("jsonView",model);
    }


}
