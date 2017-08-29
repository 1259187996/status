package com.im.status.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by zhizhuang.yang on 2017/8/29.
 */
public class LoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
