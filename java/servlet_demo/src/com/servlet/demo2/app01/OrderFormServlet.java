package com.servlet.demo2.app01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author huxingxin
 * @createTime 2021年08月08日 21:45:06
 * @Description 跳转订单页面
 * 先判断cookie里面的密码和用户名是否匹配
 * 匹配：跳转到订单页面
 * 不匹配：重定向到登录页面
 */
@WebServlet(name = "OrderFormServlet", urlPatterns = {"/toOrder"})
public class OrderFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        checkCookie(req,resp);
//        checkSession(req,resp);
        req.getRequestDispatcher("/WEB-INF/jsp/addOrder.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        checkCookie(req,resp);
//        checkSession(req,resp);
        req.getRequestDispatcher("/WEB-INF/jsp/addOrder.jsp").forward(req,resp);
    }

    /**
     *  跳转订单页面
     *  先判断cookie里面的密码和用户名是否匹配
     *  匹配：跳转到订单页面
     *  不匹配：重定向到登录页面
     * @param req
     * @param resp
     * @throws IOException
     */
    private void checkCookie(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String userName = "";
        String password = "";
        Cookie[] cookies = req.getCookies();
        if (cookies!=null){
            for (Cookie cookie : cookies){
                if(cookie.getName().equals("userName")){
                    userName = cookie.getValue();
                }
                if(cookie.getName().equals("password")){
                    password = cookie.getValue();
                }
            }

            if(userName.equals("userName") && password.equals("password")){
                req.getRequestDispatcher("/WEB-INF/jsp/addOrder.jsp").forward(req,resp);
            }else {
                resp.sendRedirect("login");
            }
        }else {
            resp.sendRedirect("login");
        }
    }

    /**
     *  跳转订单页面
     *  先判断session里面的密码和用户名是否匹配
     *  匹配：跳转到订单页面
     *  不匹配：重定向到登录页面
     * @param req
     * @param resp
     * @throws IOException
     */
    private void checkSession(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        String password = (String) session.getAttribute("password");
        if(userName!=null && password !=null){
            if(userName.equals("userName") && password.equals("password")){
                req.getRequestDispatcher("/WEB-INF/jsp/addOrder.jsp").forward(req,resp);
            }else {
                resp.sendRedirect("login");
            }
        }else {
            resp.sendRedirect("login");
        }
    }
}
