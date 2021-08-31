package com.spring.demo1.controller;

import com.spring.demo1.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huxingxin
 * @createTime 2021年08月18日 14:57:16
 * @Description
 */
@Controller
public class OrderController {
    @RequestMapping("toOrder")
    public String toOrder(){
        return "jsp/addOrder";
    }

    @PostMapping("addOrder")
    public String addOrder(Model model, User user){
        model.addAttribute("user",user);
        return "jsp/editOrder";
    }
}
