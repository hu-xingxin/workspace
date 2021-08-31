package com.springboot.demo2.config;

import cn.hutool.core.util.StrUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author huxingxin
 * @createTime 2021年08月13日 15:55:34
 * @Description 拦截器 对请求进行拦截 校验用户名和密码
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String userName = (String)session.getAttribute("userName");
        String password = (String)session.getAttribute("password");
        if(StrUtil.isNotEmpty(userName) &&  StrUtil.isNotEmpty(password)){
            if(userName.equals("userName") && password.equals("password")){
                return true;
            }else {
                response.sendRedirect("/login");
            }
        }
        response.sendRedirect("/login");
        return false;
    }
}
