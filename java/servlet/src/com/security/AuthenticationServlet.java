package com.security;

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
 * @create: 2021-06-01 10:41
 **/
@WebServlet(name = "AuthenticationServlet", urlPatterns = "/authentication")
public class AuthenticationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.authenticate(resp)){
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.print("welcome");
        }else {
            System.out.println("User not authenticated");
        }
    }
}
