package com.iframe.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-07 19:18
 **/
@WebServlet(name = "IframeServlet",urlPatterns = {"/getTime"})
public class IframeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);

        req.setAttribute("time",time) ;
        RequestDispatcher rd = req.getRequestDispatcher("time.jsp") ;
        rd.forward(req,resp) ;
    }
}
