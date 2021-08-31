package com.spring.ioc.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-10 14:05
 **/
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void selectUser(){
        userMapper.selectUser();
    }
}
