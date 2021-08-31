package com.servlet.collection;

import com.servlet.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author huxingxin
 * @createTime 2021年08月08日 20:51:56
 * @Description 登录Servlet
 * get请求跳转到登录页面  post请求校验用户名和密码
 * 用户名密码正确 将用户名和密码保存到cookie里面 有效时间300秒
 * 不正确 将请求转发到登录页面
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    /**
     * 跳转登录页面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,resp);
    }

    /**
     * 用户名和密码校验
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

       try {
           Subject subject = SecurityUtils.getSubject();
           UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
           subject.login(token);
           Session session=subject.getSession();
           session.setAttribute("subject", subject);
           //请求转发：不会改变路径 (转发到servlet: 会调用post请求)
           req.getRequestDispatcher("/WEB-INF/jsp/addOrder.jsp").forward(req,resp);
       }catch (AuthenticationException e){
           //resp.sendRedirect("demo02/app01/login.jsp");
           req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,resp);
       }



    }
}
