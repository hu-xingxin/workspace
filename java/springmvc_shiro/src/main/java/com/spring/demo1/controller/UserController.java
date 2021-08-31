package com.spring.demo1.controller;

import com.spring.demo1.domain.User;
import com.spring.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author huxingxin
 * @createTime 2021年08月18日 14:18:25
 * @Description
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("addUser")
    @ResponseBody
    public List<User> addUser(){
        User user = new User("springMvc","springMcv123.");
        Integer integer = userService.insertUser(user);
        List<User> springMvc = userService.queryUserList(new User("springMvc"));
        return springMvc;
    }
}
