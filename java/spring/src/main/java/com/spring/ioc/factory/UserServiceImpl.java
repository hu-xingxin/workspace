package com.spring.ioc.factory;

import com.spring.domain.User;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-10 14:50
 **/
public class UserServiceImpl {
    private UserMapper userMapper = FactoryBean.getUserMapper();

    public User selectUser(){
        return userMapper.selectUser();
    }
}
