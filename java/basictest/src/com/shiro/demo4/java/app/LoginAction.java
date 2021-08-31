package com.shiro.demo4.java.app;

import com.shiro.demo4.java.domain.User;
import com.shiro.demo4.java.service.UserService;
import com.shiro.demo4.java.service.impl.UserServiceImpl;
import com.shiro.demo4.java.utils.ShiroUtil;

/**
 * @author huxingxin
 * @createTime 2021年08月16日 18:57:19
 * @Description
 */
public class LoginAction {
    private static UserService userService = new UserServiceImpl();
    public static void main(String[] args) {
        ShiroUtil.login(new User("shiro","ls123456."));
    }
}
