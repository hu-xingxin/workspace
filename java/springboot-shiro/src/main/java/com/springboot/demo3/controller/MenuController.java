package com.springboot.demo3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huxingxin
 * @createTime 2021年08月19日 14:15:27
 * @Description
 */
@Controller
public class MenuController {
    @RequestMapping("menu")
    public String toMenu(){
        return "/demo2/menu";
    }
}
