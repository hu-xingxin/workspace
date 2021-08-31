package com.spring.ioc.factory;

import com.spring.domain.User;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-10 14:52
 **/
public class Action {
    public static void main(String[] args) {
        UserServiceImpl userServiceImpl = FactoryBean.getUserServiceImpl();
        User user = userServiceImpl.selectUser();
        System.out.println(user);
    }
}
