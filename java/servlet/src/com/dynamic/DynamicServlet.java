package com.dynamic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-01 16:16
 **/
public class DynamicServlet extends HttpServlet {
    private static final long serialVersionUID = 1l;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print("First Servlet");
    }
}
