package com.spring.ioc.di.mapper;

import com.spring.domain.User;
import org.springframework.stereotype.Service;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-10 14:30
 **/
@Service
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
