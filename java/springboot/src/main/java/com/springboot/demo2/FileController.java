package com.springboot.demo2;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huxingxin
 * @createTime 2021年08月13日 14:06:34
 * @Description
 */

@Controller
@Api(tags = "文件上传接口")
public class FileController {
    /**
     * 下载文件
     * @param path
     * @param response
     * @throws IOException
     */
    @GetMapping("download")
    @ApiOperation(value = "下载文件", consumes = "下载文件", notes = "下载文件")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "path", value = "文件路径(包含文件名)", required = true, paramType = "String", dataType = "String"),
    })
    public void fileDownload(String path, HttpServletResponse response) throws IOException {
        //文件所在路径
        String filePath = ResourceUtils.getURL("classpath:").getPath() + path;
        //截取文件名称
        String fileName = path.substring(path.indexOf("fileUpload/")+"fileUpload/".length());
        fileName = URLEncoder.encode(fileName,"UTF-8");//文件名称有中文时 需要转码
        //将文件读取到bytes
        byte[] bytes = FileUtil.readBytes(filePath);
        //设置响应的内容类型
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.addHeader("Content-Disposition","attachment; filename="+fileName);
        //下载文件
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);
    }

    /**
     * 上传页面
     * @return
     */
    @GetMapping("upload")
    @ApiOperation(value = "上传页面", consumes = "上传页面", notes = "上传页面")
    public String upload(){
        return "/demo2/fileUpload";
    }

    /**
     * 上传文件
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    @PostMapping("upload")
    @ResponseBody
    @ApiOperation(value = "上传文件", consumes = "上传文件", notes = "上传文件")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "file", value = "文件上传MultipartFile", required = true, paramType = "MultipartFile", dataType = "MultipartFile"),
    })
    public Map fileUpload(MultipartFile file) throws FileNotFoundException {
        String oldFileName = file.getOriginalFilename();//文件原名称
        long size = file.getSize();//文件大小kb

        //文件所在路径
        String path = ResourceUtils.getURL("classpath:").getPath()+"fileUpload/";
        File uploadFile = new File(path, oldFileName);//构造文件
        try {
            file.transferTo(uploadFile);//上传文件
        } catch (IOException e) {
            e.printStackTrace();
        }

        String pathUrl =  "/fileUpload/" + oldFileName;//返回文件下载路径
        //响应数据
        HashMap<String, Object> data = new HashMap<>();
        data.put("code",200);
        data.put("pathUrl",pathUrl);
        data.put("size",size);
        return data;
    }
}
