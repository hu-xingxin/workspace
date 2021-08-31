package com.springmvc.app03.config;

import com.github.pagehelper.util.StringUtil;
import com.mysql.jdbc.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author huxingxin
 * @createTime 2021年08月12日 14:10:57
 * @Description 登录拦截器 校验用户名和密码
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 拦截开始的方法
     * 返回 false  代表被拦截  不执行controller
     * 返回true  执行controller
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String contextPath = request.getContextPath();

        HttpSession session = request.getSession();
        String userName = (String)session.getAttribute("userName");
        String password = (String)session.getAttribute("password");
        if(StringUtil.isNotEmpty(userName) &&  StringUtil.isNotEmpty(password)){
            if(userName.equals("userName") && password.equals("password")){
                return true;
            }
        }
        response.sendRedirect(contextPath + "/menu");
        return false;
    }

    /**
     * 在Controller执行完成之后返回ModelAndView之前执行的方法
     */

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 当Controller完成执行完成之后执行
     */

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
