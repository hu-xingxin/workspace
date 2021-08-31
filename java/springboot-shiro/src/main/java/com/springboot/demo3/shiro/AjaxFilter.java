package com.springboot.demo3.shiro;

/**
 * @author huxingxin
 * @createTime 2021年08月19日 16:10:52
 * @Description
 */

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.AdviceFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Ajax请求处理  对于没有进行登录验证的请求 返回json
 * 用于前后台分离的场景
 */
public class AjaxFilter extends AdviceFilter {
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        // 先判断是不是ajax请求 ajax请求都会自带一个请求头X-Requested-With
        // 如果有值而且是XMLHttpRequest那就可以确定是个ajax请求 返回json数据就行
        HttpServletRequest req = (HttpServletRequest) request;
        Subject subject = SecurityUtils.getSubject();
        // 获取到当前的登录对象 如果是没有经过认证的用户就获取不到认证信息
        if (subject.getPrincipal() == null) {
            // 是ajax请求 返回json
            if ("XMLHttpRequest".equals(req.getHeader("X-Requested-With"))) {

                HttpServletResponse resp = (HttpServletResponse) response;

                // 设置响应类型和编码字符 不然中文乱码
                resp.setContentType("application/json;charset=utf-8");
                resp.setCharacterEncoding("UTF-8");

                // Message是我写的一个包装类,用来向前台返回数据
                resp.getWriter().write("请登录后操作");
            } else {
                //不是ajax请求 重定向
                response.reset();
                String contextPath = ((HttpServletRequest) request).getContextPath();
                HttpServletResponse servletResponse = (HttpServletResponse) response;
                servletResponse.sendRedirect(contextPath + "/menu");
            }
            return false;
        }
        return true;
    }
}
