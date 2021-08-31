package com.spring.ioc.di.service;

import com.spring.domain.User;
import com.spring.ioc.di.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-10 14:31
 **/
@Service
public class UserServiceImpl {
    @Autowired
    private UserMapper userMapper;

    public User selectUser(){
        return userMapper.selectUser();
    }
}
