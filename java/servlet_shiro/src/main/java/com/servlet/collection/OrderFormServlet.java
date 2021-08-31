package com.servlet.collection;

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
        req.getRequestDispatcher("/WEB-INF/jsp/addOrder.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/addOrder.jsp").forward(req,resp);
    }

}
