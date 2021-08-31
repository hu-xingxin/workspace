package com.spring.ioc.oldexample;

import com.spring.domain.User;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-10 14:45
 **/
public class Action {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.selectUser();
        System.out.println(user);
    }
}
