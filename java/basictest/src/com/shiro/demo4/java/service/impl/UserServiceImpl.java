package com.shiro.demo4.java.service.impl;

import com.shiro.demo4.java.domain.User;
import com.shiro.demo4.java.mapper.UserMapper;
import com.shiro.demo4.java.service.UserService;
import com.shiro.demo4.java.utils.MybatisUtil;

import java.util.List;

/**
 * @author huxingxin
 * @createTime 2021年08月16日 10:12:40
 * @Description
 */
public class UserServiceImpl implements UserService {
    private UserMapper userMapper =  MybatisUtil.getMapper(UserMapper.class);

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
