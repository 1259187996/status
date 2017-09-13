package com.im.status.filter;

import com.im.status.base.logger.StatusLogger;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by zhizhuang.yang on 2017/8/29.
 */
public class LoginFilter implements Filter{

    private StatusLogger logger = StatusLogger.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("请求入参:"+request.getParameterMap().toString());
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
