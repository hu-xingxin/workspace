package com.spring.ioc.oldexample;

import com.spring.domain.User;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-10 14:44
 **/
public class UserMapper {
    public User selectUser(){
        User user = new User();
        user.setId(1L);
        user.setUserName("java");
        user.setAge(20);
        user.setSex("男");
        return user;
    }
}
