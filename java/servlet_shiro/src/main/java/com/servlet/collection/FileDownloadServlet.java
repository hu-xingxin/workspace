package com.servlet.collection;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author huxingxin
 * @createTime 2021年08月10日 15:45:28
 * @Description 文件下载servlet
 */
@WebServlet(name = "FileDownloadServlet", urlPatterns = {"/download"})
public class FileDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String realPath = req.getSession().getServletContext().getRealPath("");//项目所在路径

        String filePath = req.getParameter("filePath").replace("/",File.separator);//文件路径加名称

        //从filePath中截取文件名称
        String fileName = filePath.substring(filePath.indexOf("upload" + File.separator)+("upload"+File.separator).length());

        fileName = URLEncoder.encode(fileName,"UTF-8");//文件名称有中文时 需要转码

        //让浏览器能识别文件类型 和设置文件下载名称
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/octet-stream");
        resp.addHeader("Content-Disposition","attachment; filename="+fileName);

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(realPath + filePath));) {
            byte[] bytes = new byte[bis.available()];//创建一个和文件大小一样的字节数组
            bis.read(bytes);//将文件信息放入到字节数组里面

            ServletOutputStream outputStream = resp.getOutputStream();
            outputStream.write(bytes);//将包含文件的字节数组响应到浏览器
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
