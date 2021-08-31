package com.servlet.demo2.app01;

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
        if(userName.equals("userName") && password.equals("password")){
            //将用户名和密码保存到cookie里面 有效时间300秒
            //只有当这个请求结束  cookie才能成功添加
//            addCookie(resp,userName,password);


            //将用户名和密码保存到session里面 有效时间300秒
            addSession(req,userName,password);

            /**
             * 重定向 和 请求转发 不可以调用自身的servlet
             */
            //重定向：会改变路径
//            resp.sendRedirect("demo01/app01/addOrder.jsp");
            //请求转发：不会改变路径 (转发到servlet: 会调用post请求)
            req.getRequestDispatcher("/WEB-INF/jsp/addOrder.jsp").forward(req,resp);
        }else {
//            resp.sendRedirect("demo02/app01/login.jsp");
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,resp);
        }
    }

    /**
     * 将用户名和密码 添加到cookie
     * @param response
     * @param username
     * @param password
     */
    private void addCookie(HttpServletResponse response,String username,String password){
        Cookie userNameCookie = new Cookie("userName",username);
        userNameCookie.setMaxAge(300);//有效时长300秒
        response.addCookie(userNameCookie);
        Cookie passwordCookie = new Cookie("password",password);
        passwordCookie.setMaxAge(300);
        response.addCookie(passwordCookie);
    }

    /**
     * 将用户名和密码 添加到session
     * @param request
     * @param userName
     * @param password
     */
    private void addSession(HttpServletRequest request,String userName,String password){
        HttpSession session = request.getSession();
        session.setAttribute("userName",userName);
        session.setAttribute("password",password);
    }
}
