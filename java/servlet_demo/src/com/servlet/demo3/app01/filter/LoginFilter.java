package com.servlet.demo3.app01.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author huxingxin
 * @createTime 2021年08月09日 23:11:24
 * @Description 登录拦截器 进行session校验
 *              校验成功放行 校验失败 跳转到登录页面
 */
//@WebFilter(filterName ="LoginFilter",urlPatterns = {"/*"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        //对登录请求和静态资源 放行
        String contextPath = request.getContextPath();
        if(requestURI.indexOf(contextPath +"/login")!=-1 || requestURI.indexOf(contextPath + "/static/")!=-1){
            filterChain.doFilter(request,response);
        }else {

            //如果不是是登录请求和静态资源  则进行session校验 校验成功放行 校验失败 跳转到登录页面
            HttpSession session = request.getSession();
            String userName = (String) session.getAttribute("userName");
            String password = (String) session.getAttribute("password");
            if(userName!=null && password !=null){
                if(userName.equals("userName") && password.equals("password")){
                    filterChain.doFilter(request,response);
                }else {
                    response.sendRedirect(contextPath+"/login");
                }
            }else {
                response.sendRedirect(contextPath+"/login");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
