package com.springmvc.app03.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huxingxin
 * @createTime 2021年08月11日 23:39:11
 * @Description 文件上传
 */
@Controller
@RequestMapping("file")
public class FileController {

    /**
     * 文件上传页面
     * @return
     */
    @GetMapping("upload")
    public String upload(){
        return "/jsp/fileUpload";
    }

    /**
     * 文件上传
     * @param part 和input的name 保持一致
     * @param request
     * @return
     */
    @PostMapping("upload")
    @ResponseBody
    public Map<String, Object> fileUpload(MultipartFile part, HttpServletRequest request){
        //文件上传绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/");
        //构造文件
        File file = new File(realPath, part.getOriginalFilename());
        try {
            //上传文件
            part.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //截取上传路径
        String filePath = realPath + part.getOriginalFilename();
        filePath = filePath.replace("\\", "/");
        filePath =filePath.substring(filePath.indexOf("/WEB-INF")+"/WEB-INF".length());

        HashMap<String,Object> map = new HashMap<>();
        map.put("filePath",filePath);
        map.put("fileName",part.getOriginalFilename());//文件名称
        map.put("size",part.getSize());//文件大小 kb

        JSONObject jObject = new JSONObject();
        jObject.put("code", "200");
        jObject.put("data", map);
        return jObject;
    }

    /**
     * 文件下载
     * @param filePath
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("download")
    public ResponseEntity fileDownload(String filePath, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //文件上传绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF") + filePath;
        String fileName = filePath.substring(filePath.indexOf("upload/")+"upload/".length());
        fileName = URLEncoder.encode(fileName,"UTF-8");//文件名称有中文时 需要转码

        File file = new File(realPath);
        byte[] bytes = FileUtils.readFileToByteArray(file);
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.addHeader("Content-Disposition","attachment; filename="+fileName);
        return new ResponseEntity(bytes, HttpStatus.OK);
    }

    @RequestMapping("delete")
    @ResponseBody
    public boolean deleteFile(String filePath,HttpServletRequest request){
        //文件上传绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF") + filePath;
        File file = new File(realPath);
        boolean flag = file.delete();
        return flag;
    }
}
