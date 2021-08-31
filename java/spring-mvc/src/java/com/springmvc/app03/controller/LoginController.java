package com.springmvc.app03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author huxingxin
 * @createTime 2021年08月11日 15:45:32
 * @Description 登录 用户名密码校验
 */
@Controller
public class LoginController {

    /**
     * 登录页面
     * @return
     */
    @GetMapping("login")
    public ModelAndView loginPage(){
        ModelAndView modelAndView = new ModelAndView();
        int[] ints = {1, 2, 3, 4};
        modelAndView.setViewName("/jsp/login");//==request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        modelAndView.addObject("data",ints);//==request.setAttribute("users",users)
        return modelAndView;
    }

    /**
     * 用户名密码校验
     * @param userName
     * @param password
     * @return
     */
    @PostMapping("login")
    public String login(String userName, String password, HttpServletRequest request){
        if(userName.equals("userName") && password.equals("password")){
            HttpSession session = request.getSession();
            session.setAttribute("userName",userName);
            session.setAttribute("password",password);
            return "/jsp/menu_websocket";
        }else {
            return "/jsp/login";
        }
    }
}
