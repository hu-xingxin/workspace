package com.spring.ioc.xml;

import com.spring.domain.User;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-10 15:11
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
