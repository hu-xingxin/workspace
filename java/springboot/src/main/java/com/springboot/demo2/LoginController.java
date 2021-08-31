package com.springboot.demo2;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huxingxin
 * @createTime 2021年08月13日 09:17:49
 * @Description
 */
@Controller
@Api(tags = "用户登录接口")
public class LoginController {

    @GetMapping("login")
    @ApiOperation(value = "登录页面", consumes = "登录页面", notes = "登录页面")
    public String toLogin(){
        return "demo2/login";
    }

    @PostMapping("login")
    @ApiOperation(value = "登录", consumes = "登录", notes = "登录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userName", value = "用户名", required = true, paramType = "String", dataType = "String"),
        @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "String", dataType = "String")
    })
    public String login(String userName, String password, HttpServletRequest request){
        //校验用户名和密码 匹配跳转addOrder 不匹配跳转login
       if(StrUtil.isNotEmpty(userName) &&  StrUtil.isNotEmpty(password)){
           if(userName.equals("userName") && password.equals("password")){
               //将用户名和密码保存到session
               HttpSession session = request.getSession();
               session.setAttribute("userName",userName);
               session.setAttribute("password",password);
               return "/demo2/addOrder";
           }
       }
        return "/demo2/login";
    }

}
