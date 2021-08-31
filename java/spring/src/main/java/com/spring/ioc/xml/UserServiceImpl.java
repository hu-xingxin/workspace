package com.spring.ioc.xml;

import com.spring.domain.User;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-10 15:11
 **/
public class UserServiceImpl {
    private UserMapper userMapper;

    public User selectUser(){
        return userMapper.selectUser();
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
