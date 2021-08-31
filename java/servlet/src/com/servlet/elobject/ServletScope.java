package com.servlet.elobject;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-01 11:28
 **/
@WebServlet(name = "ServletScope", urlPatterns = {"/scope"})
public class ServletScope extends HttpServlet {
    @Override
    public ServletConfig getServletConfig() {
        return super.getServletConfig();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        ServletContext servletContext = servletConfig.getServletContext();
        String tocc = (String) servletContext.getInitParameter("previewUrl");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print(tocc);
    }
}
