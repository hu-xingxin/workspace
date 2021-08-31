package com.spring.demo1.controller;

import com.spring.demo1.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huxingxin
 * @createTime 2021年08月18日 11:32:49
 * @Description
 */
@Controller
public class LoginController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("login")
    public String toLogin(){
        return "jsp/login";
    }

    @PostMapping("login")
    public String login(User user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        try {
            subject.login(token);
            Session session=subject.getSession();
            session.setAttribute("subject", subject);
            return "jsp/addOrder";
        }catch (AuthenticationException e){
            return "jsp/login";
        }
    }
}
