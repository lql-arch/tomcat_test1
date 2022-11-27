package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class filter_demo1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter...");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);
        //放行后对response处理
        System.out.println("filter2...");
    }

    @Override
    public void destroy() {
//        Filter.super.destroy();
    }
}
