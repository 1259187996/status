package com.im.status.controller;

import com.im.status.base.model.RespModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhizhuang.yang on 2017/9/27.
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping(value = "/")
    public void index_default(HttpServletRequest request, HttpServletResponse response) {
        RespModel respModel = new RespModel();
        this.success(respModel);
        writeResponse(response, respModel);
    }

    @RequestMapping(value = "/index")
    public void index(HttpServletRequest request, HttpServletResponse response) {
        RespModel respModel = new RespModel();
        this.success(respModel);
        writeResponse(response, respModel);

    }
}
