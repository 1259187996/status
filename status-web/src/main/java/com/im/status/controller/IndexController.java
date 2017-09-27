package com.im.status.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhizhuang.yang on 2017/9/27.
 */
@Controller
public class IndexController {

    @RequestMapping(value="/")
    public String index_default(HttpServletRequest request, HttpServletResponse response){
        return "index";
    }

    @RequestMapping(value="/index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("index");
    }

    @RequestMapping(value="/404")
    public ModelAndView error_page_404(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("404");
    }

    @RequestMapping(value="/500")
    public ModelAndView error_page_500(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("500");
    }
}
