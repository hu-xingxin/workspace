package com.spring.ioc.xml.annotation;

import com.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-10 15:11
 **/
@Service
public class UserServiceImpl {
    @Autowired
    private UserMapper userMapper;

    public User selectUser(){
        return userMapper.selectUser();
    }
}
