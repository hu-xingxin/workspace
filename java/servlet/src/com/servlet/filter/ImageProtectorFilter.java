package com.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.rmi.ServerException;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-26 16:18
 **/
@WebFilter(filterName = "ImageProtectorFilter",urlPatterns = {"*.png","*.jpg","*.gif"})
public class ImageProtectorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String referer = httpServletRequest.getHeader("referer");
        System.out.println("referer:" + referer);
        if(referer != null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            servletResponse.getWriter().print("Image not available");
        }
//        servletResponse.getWriter().print("Image not available");
    }

    @Override
    public void destroy() {

    }
}
