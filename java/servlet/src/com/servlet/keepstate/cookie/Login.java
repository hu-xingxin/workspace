package com.servlet.keepstate.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-23 15:09
 **/
@WebServlet(name = "Login", urlPatterns = {"/loginPage","/login","/info","/exit"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURL = req.getRequestURL().toString();
        if(requestURL.endsWith("loginPage")){
            toLoginPage(req,resp);
        }else if(requestURL.endsWith("login")){
            login(req,resp);
        }else if (requestURL.endsWith("info")){
            info(req,resp);
        } else if (requestURL.endsWith("exit")){
            exit(req,resp);
        }
    }

    public void toLoginPage(HttpServletRequest req, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html>");
        writer.print("<head>");
        writer.print("<title>Login</title>");
        writer.print("</head>");
        writer.print("<body>" +
                "<form action='login' method='get'>" +
                "name: <input type='text' name='name'/>" +
                "</br>password: <input type='text' name='password'/>" +
                "</br><input type='reset'/>" +
                "<input type='submit'/>" +
                "</form>" +
                "</br><a href='info'>userInfo</a>" +
                "</body>");
        writer.print("</html>");
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        Cookie nameCookie = new Cookie("name", name);
        Cookie passwordCookie = new Cookie("password", password);
        nameCookie.setMaxAge(60*60);
        passwordCookie.setMaxAge(60*60);
        response.addCookie(nameCookie);
        response.addCookie(passwordCookie);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html>");
        writer.print("<head>");
        writer.print("<title>Login</title>");
        writer.print("</head>");
        writer.print("<body>" +
                "<form action='login' method='get'>" +
                "name: <input type='text' name='name'/>" +
                "</br>password: <input type='text' name='password'/>" +
                "</br><input type='reset'/>" +
                "<input type='submit'/>" +
                "</form>" +
                "</br><a href='info'>userInfo</a>" +
                "</body>");
        writer.print("</html>");
    }

    public void info(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Cookie nameCookie = null;
        Cookie passwordCookie = null;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("name")){
                nameCookie = cookie;
            }
            if(cookie.getName().equals("password")){
                passwordCookie = cookie;
            }
        }
        if (nameCookie != null && passwordCookie !=null){
            String name = nameCookie.getValue();
            String password = passwordCookie.getValue();
            if(name.equals("name") && password.equals("password")){
                PrintWriter writer = response.getWriter();
                writer.print("<html>");
                writer.print("<head>");
                writer.print("<title>Login</title>");
                writer.print("</head>");
                writer.print("<body>" +
                        "name:" + name +
                        "</br>password:" + password +
                        "</br><a href='exit'>reset</a>"+
                        "</body>");
                writer.print("</html>");
            }else {
                response.setContentType("text/html");
                PrintWriter writer = response.getWriter();
                writer.print("<html>");
                writer.print("<head>");
                writer.print("<title>Login</title>");
                writer.print("</head>");
                writer.print("<body>" +
                        "<form action='login' method='get'>" +
                        "name: <input type='text' name='name'/>" +
                        "</br>password: <input type='text' name='password'/>" +
                        "</br><input type='reset'/>" +
                        "<input type='submit'/>" +
                        "</form>" +
                        "</br><a href='info'>userInfo</a>" +
                        "</body>");
                writer.print("</html>");
            }
        }else {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.print("<html>");
            writer.print("<head>");
            writer.print("<title>Login</title>");
            writer.print("</head>");
            writer.print("<body>" +
                    "<form action='login' method='get'>" +
                    "name: <input type='text' name='name'/>" +
                    "</br>password: <input type='text' name='password'/>" +
                    "</br><input type='reset'/>" +
                    "<input type='submit'/>" +
                    "</form>" +
                    "</br><a href='info'>userInfo</a>" +
                    "</body>");
            writer.print("</html>");
        }

    }

    public void exit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie nameCookie = new Cookie("name", "");
        Cookie passwordCookie = new Cookie("password", "");
        nameCookie.setMaxAge(0);
        passwordCookie.setMaxAge(0);
        response.addCookie(nameCookie);
        response.addCookie(passwordCookie);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html>");
        writer.print("<head>");
        writer.print("<title>Login</title>");
        writer.print("</head>");
        writer.print("<body>" +
                "<form action='login' method='get'>" +
                "name: <input type='text' name='name'/>" +
                "</br>password: <input type='text' name='password'/>" +
                "</br><input type='reset'/>" +
                "<input type='submit'/>" +
                "</form>" +
                "</br><a href='info'>userInfo</a>" +
                "</body>");
        writer.print("</html>");
    }
}
