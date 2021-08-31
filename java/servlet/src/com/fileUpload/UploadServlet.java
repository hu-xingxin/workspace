package com.fileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-27 15:42
 **/
@WebServlet(name = "UploadServlet", urlPatterns = {"/uploadFile"})
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String getFileName(Part part){
        String contentHeader = part.getHeader("content-disposition");
        String[] elements = contentHeader.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")){
                return element.substring(element.indexOf("=")+1).trim().replace("\"","");
            }
        }
        return null;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Part part = request.getPart("file");
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        Collection<Part> parts = request.getParts();
        for (Part part : parts){
            if(part.getContentType() != null){
                String fileName = getFileName(part);
                if(fileName!=null && !fileName.isEmpty()){
                    part.write(getServletContext().getRealPath("/WEB-INF") + "/" + fileName);
                }
                writer.print("<br/>Upload fileName : " + fileName);
                writer.print("<br/>Size : " + part.getSize());
                String author = request.getParameter("author");
            }else {
                String partName = part.getName();
                String fieldValue = request.getParameter(partName);
                writer.print("<br/>partName : " +fieldValue);
            }
        }
    }
}
