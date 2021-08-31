package com.springmvc.app03.controller;

import com.springmvc.app03.domain.SysUser;
import com.springmvc.app03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huxingxin
 * @createTime 2021年08月12日 10:00:58
 * @Description ssm框架搭建测试
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("user")
    @ResponseBody
    public SysUser getUser(Integer id){
        return userService.queryUserById(id);
    }
}
