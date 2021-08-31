package com.ruoyi.web.controller.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huxingxin
 * @createTime 2021年08月04日 01:06:10
 * @Description
 */
@Controller
public class DemoVlcController {
    @RequestMapping("vlc")
    public String vlcHtml(){
        return "demo/vlc/vlc";
    }
}
