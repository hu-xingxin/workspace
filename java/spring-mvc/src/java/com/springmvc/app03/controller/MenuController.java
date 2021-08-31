package com.springmvc.app03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author huxingxin
 * @createTime 2021年08月11日 23:39:11
 * @Description 菜单
 */
@Controller
public class MenuController {

    /**
     * 菜单页面
     * @return
     */
    @GetMapping("menu")
    public String menu(){
        return "/jsp/menu_websocket";
    }

}
