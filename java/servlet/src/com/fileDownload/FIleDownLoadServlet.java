package com.fileDownload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-30 22:07
 **/
@WebServlet(name = "FIleDownLoadServlet", urlPatterns = {"/file/indexPage", "/file/login", "/file/fileDownLoad"})
public class FIleDownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        int lastIndex = requestURI.lastIndexOf("/");
        String action = requestURI.substring(lastIndex + 1);
        if(action.endsWith("indexPage")){
            indexPage(req,resp);
        }else if (action.endsWith("fileDownLoad")){
            fileDownLoad(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        int lastIndex = requestURI.lastIndexOf("/");
        String action = requestURI.substring(lastIndex + 1);
        if(action.endsWith("login")){
            login(req,resp);
        }
    }

    public void indexPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dispatcherUrl = "/WEB-INF/login/login.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(dispatcherUrl);
        requestDispatcher.forward(req,resp);
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginName = req.getParameter("loginName");
        String passWord = req.getParameter("passWord");
        if (loginName.equals("loginName") && passWord.equals("passWord")){
            HttpSession session = req.getSession();
            HashMap<String, String> user = new HashMap<>();
            user.put("loginName",loginName);
            user.put("passWord",passWord);
            session.setAttribute("user",user);

            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.print("<a href='/file/fileDownLoad'>点击下载文件</a>");
        }else {
            String dispatcherUrl = "/WEB-INF/login/login.jsp";
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(dispatcherUrl);
            requestDispatcher.forward(req,resp);
        }
    }

    public void fileDownLoad(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Map<String,String> user = (Map) session.getAttribute("user");

        String referer = req.getHeader("referer");
        if(user == null || referer==null){
            String dispatcherUrl = "/WEB-INF/login/login.jsp";
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(dispatcherUrl);
            requestDispatcher.forward(req,resp);
            return;
        }
        String loginName = user.get("loginName");
        String passWord = user.get("passWord");
        if (loginName.equals("loginName") && passWord.equals("passWord")){
            FileInputStream fis = new FileInputStream("E:\\tmp\\image\\20200216232749_qrulb.jpg");
            BufferedInputStream bis = new BufferedInputStream(fis);
            byte[] bytes = new byte[bis.available()];
            resp.setContentType("application/octet-stream");
            resp.addHeader("Content-Disposition","attachment; filename=2021-5-31.jpg");
            bis.read(bytes);
            ServletOutputStream outputStream = resp.getOutputStream();
            outputStream.write(bytes);
        }else {
            String dispatcherUrl = "/WEB-INF/login/login.jsp";
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(dispatcherUrl);
            requestDispatcher.forward(req,resp);
        }
    }
}
