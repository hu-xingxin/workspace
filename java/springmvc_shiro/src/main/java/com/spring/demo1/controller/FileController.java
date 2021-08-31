package com.spring.demo1.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huxingxin
 * @createTime 2021年08月18日 15:40:44
 * @Description
 */
@Controller
public class FileController {
    @RequestMapping("upload")
    @RequiresPermissions("user:upload")
    public String upload(){
        return "jsp/fileUpload";
    }
}
