package com.spring.ioc.oldexample;

import com.spring.domain.User;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-10 14:44
 **/
public class UserServiceImpl {
    private UserMapper userMapper = new UserMapper();

    public User selectUser(){
       return userMapper.selectUser();
    }
}
