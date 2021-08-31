package com.spring.demo1.service.impl;

import com.spring.demo1.domain.User;
import com.spring.demo1.mapper.UserMapper;
import com.spring.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huxingxin
 * @createTime 2021年08月16日 10:12:40
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUserList(User user) {
        return userMapper.queryUserList(user);
    }

    @Override
    public List<String> queryRoleByUserId(Long userId) {
        return userMapper.queryRoleByUserId(userId);
    }

    @Override
    public List<String> queryPermissionByUserId(Long userId) {
        return userMapper.queryPermissionByUserId(userId);
    }

    @Override
    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }
}
