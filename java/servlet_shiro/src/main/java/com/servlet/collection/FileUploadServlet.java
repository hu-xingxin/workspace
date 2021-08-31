package com.servlet.collection;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.HashMap;

/**
 * @author huxingxin
 * @createTime 2021年08月10日 00:15:41
 * @Description 文件上传servlet
 */
@WebServlet(name = "FileUploadServlet", urlPatterns = {"/upload"})
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/fileUpload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        Part part = req.getPart("file");

        //从请求头里面 截取文件名称
        String header = part.getHeader("content-disposition");
        String prefix = "filename=\"";
        int i = header.indexOf(prefix);
        int j = header.lastIndexOf("\"");
        String fileName = header.substring(i + prefix.length(), j);//文件名称

        long size = part.getSize();//文件大小 KB

        //文件保存路径
        String filePath = req.getSession().getServletContext().getRealPath("") + "/WEB-INF/upload/" + fileName;

        //将文件保存  /WEB-INF/upload/ 路径下
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
             BufferedInputStream bis = new BufferedInputStream(part.getInputStream());) {
            byte[] buffer = new byte[1024];
            int index = 0;
            while ((index = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, index);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap data = new HashMap();
        data.put("fileName", fileName);
        data.put("fileSize", size);
        data.put("fileType", fileName.substring(fileName.indexOf(".")));
        data.put("filePath", filePath.substring(filePath.indexOf("/WEB-INF")));
        //将数据打包成json格式 返回
        JSONObject jObject = new JSONObject();
        jObject.put("code", "200");
        jObject.put("data", data);
        PrintWriter writer = resp.getWriter();
        writer.write(jObject.toString());
        writer.flush();
        writer.close();
    }
}
