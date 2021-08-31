package com.springboot.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huxingxin
 * @createTime 2021年08月13日 01:28:10
 * @Description
 */
@Controller
public class PathController {

    @RequestMapping("path")
    @ResponseBody
    public Map getPath() throws FileNotFoundException {
        HashMap<String, Object> map = new HashMap<>();
        //获取当前项目路径的地址 "F:\code\workspace\java\springboot"
        map.put("System.getProperty(\"user.dir\")",System.getProperty("user.dir"));
        //获取classes目录绝对路径 "/F:/code/workspace/java/springboot/target/classes/"
        map.put("ClassUtils.getDefaultClassLoader().getResource(\"\").getPath()", ClassUtils.getDefaultClassLoader().getResource("").getPath());
        //获取classes目录绝对路径
        map.put("ResourceUtils.getURL(\"classpath:\").getPath()", ResourceUtils.getURL("classpath:").getPath());
    return map;
    }
}
