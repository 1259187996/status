package com.im.status.controller;

import com.im.status.model.TService;
import com.im.status.service.ServiceService;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zhizhuang.yang on 2017/8/15.
 */
@Controller
@RequestMapping("/service")
public class ServiceController extends BaseController{

    Logger logger = Logger.getLogger(ServiceController.class);

    @Autowired
    private ServiceService serviceService;

    @RequestMapping("/get")
    public void getService(HttpServletResponse response){
        List<TService> list = serviceService.getService();
        logger.debug("获取service");

        this.success(response,JSONArray.fromObject(list));
    }


}
