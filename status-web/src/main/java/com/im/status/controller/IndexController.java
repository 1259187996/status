package com.im.status.controller;

import com.im.status.base.constants.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhizhuang.yang on 2017/9/27.
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping(value = "/")
    public void index_default(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType(Const.JSON_CONTENT_TYPE);
        response.getWriter().write("Hello world");
    }

    @RequestMapping(value = "/index")
    public void index(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType(Const.JSON_CONTENT_TYPE);
        response.getWriter().write("Hello world");

    }
}
