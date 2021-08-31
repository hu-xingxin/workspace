package com.spring.mybatis.service;

import com.spring.mybatis.domain.SysUser;
import com.spring.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description 测试 ssm 架构
 * @author: hxx
 * @create: 2021-06-11 22:45
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public Integer insertUser(SysUser user){
        return userMapper.insertUser(user);
    }
}
