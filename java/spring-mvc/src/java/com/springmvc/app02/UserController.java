package com.springmvc.app02;

import com.springmvc.app02.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author huxingxin
 * @createTime 2021年08月11日 23:15:21
 * @Description
 */
@Controller
public class UserController {
    /**
     * 或取用户信息  springMvc没有默认把对象转成json数据格式的功能 需要引入jackson
     * @return
     */
    @RequestMapping("user")
    @ResponseBody
    public User getUser(){
        User user = new User();
        user.setName("张三");
        user.setSex("0");
        user.setAge(20);
        user.setBirthday(new Date());
        return user;
    }
}
