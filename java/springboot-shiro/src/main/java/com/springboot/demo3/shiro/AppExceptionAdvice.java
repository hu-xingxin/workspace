package com.springboot.demo3.shiro;

import cn.hutool.json.JSON;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huxingxin
 * @createTime 2021年08月18日 22:59:24
 * @Description  全局未授权异常处理类
 * 当setUnauthorizedUrl不起作用
 * anon，authcBasic，auchc，user是AuthenticationFilter
 * perms，roles，ssl，rest，port才是属于AuthorizationFilter
 * 而定义的filter必须instanceof AuthorizationFilter这个方法setUnauthorizedUrl才生效
 * 解决办法：添加一个全局异常处理类
 */
@RestControllerAdvice
public class AppExceptionAdvice {
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String processUnauthenticatedException(HttpServletRequest request, HttpServletResponse response, UnauthorizedException e) throws IOException {
        //ajax请求 返回json数据
        if(isAjax(request)){
            return "该用户没有权限进行此操作";
        }else {
            //不是ajax请求 重定向
            response.sendRedirect(request.getContextPath()+"/menu");
        }
        return null;
    }


    /**
     * 判断是否为ajax请求
     * @param request
     * @return
     */
    private boolean isAjax(ServletRequest request) {
        String header = ((HttpServletRequest) request).getHeader("X-Requested-With");
        if ("XMLHttpRequest".equalsIgnoreCase(header)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


}
