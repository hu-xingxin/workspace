package com.springboot.demo2;

import com.springboot.demo3.domain.SysUser;
import com.springboot.demo3.shiro.ActiveUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String login(SysUser user){
        /**
         * SecurityUtils.getSubject()
         * 先从ThreadContext中拿取，如果没有则(new Subject.Builder()).buildSubject(); 并且绑定到当前线程中
         */
        Subject subject = SecurityUtils.getSubject();
        //封装用户名和密码
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        //校验用户名和密码 匹配跳转addOrder 不匹配跳转login
        try{
            subject.login(token);
            //登录成功后还会把subject放在shiro的session对象里，
            // shiro的这个session和httpsession是串通好了的，
            // 所以在这里放了，它会自动放在httpsession里，它们之间是同步的

            Session session = subject.getSession();
            ActiveUser activeUser = (ActiveUser)subject.getPrincipals().getPrimaryPrincipal();
            session.setAttribute("activeUser",activeUser);
            return "/demo2/menu";
        }catch (AuthenticationException e){
            return "/demo2/login";
        }
    }

    @RequestMapping("index")
    public String index(){
        return "/index";
    }

}
