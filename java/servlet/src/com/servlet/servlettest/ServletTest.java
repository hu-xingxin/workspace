package com.servlet.servlettest;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-21 11:02
 **/
@WebServlet(name = "ServletTest ",
        urlPatterns = {"/servlet"},
        initParams = {
            @WebInitParam(name = "name",value = "张三"),
            @WebInitParam(name = "age",value = "20")}
         )
public class ServletTest implements Servlet {
    private transient ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        String servletName = servletConfig.getServletName();
        String name = servletConfig.getInitParameter("name");
        String age = servletConfig.getInitParameter("age");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html><head></head>" +
                "<body>" + "Hello from " + servletName + "</br>" +
                "我是" + name + "</br>" +
                "我今年" + age +
                "</body>"+
                "</html>");
    }

    @Override
    public String getServletInfo() {
        return "My Servlet";
    }

    @Override
    public void destroy() {

    }
}
