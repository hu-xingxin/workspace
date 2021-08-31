package com.spring.mybatis.service;

import com.spring.mybatis.domain.SysUser;
import com.spring.mybatis.mapper.UserMapper;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-11 22:45
 **/
public class UserService {
    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Integer insertUser(SysUser user){
        return userMapper.insertUser(user);
    }
}
