package com.security;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-01 09:29
 **/
@WebServlet(name = "AnnotationServlet", urlPatterns = {"/annotation"})
@ServletSecurity(
            value = @HttpConstraint(rolesAllowed = "manager"),
            httpMethodConstraints={@HttpMethodConstraint(value = "GET",emptyRoleSemantic = ServletSecurity.EmptyRoleSemantic.DENY)})
//@ServletSecurity(httpMethodConstraints={@HttpMethodConstraint(value = "GET", rolesAllowed = "manager")})
public class AnnotationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print("AnnotationServlet");
    }
}
