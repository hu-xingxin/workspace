package com.springmvc.app03.service.impl;


import com.springmvc.app03.domain.SysUser;
import com.springmvc.app03.mapper.UserMapper;
import com.springmvc.app03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-11 22:45
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public SysUser queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public List<SysUser> queryUserList(SysUser user) {
        return userMapper.queryUserList(user);
    }

    @Override
    public int insertUser(SysUser user){
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(SysUser user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public int queryPageCount() {
        return 0;
    }
}
