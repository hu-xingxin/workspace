package com.springboot.demo3.service.impl;

import com.springboot.demo3.domain.SysPermission;
import com.springboot.demo3.domain.SysRole;
import com.springboot.demo3.domain.SysUser;
import com.springboot.demo3.mapper.UserMapper;
import com.springboot.demo3.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-18 11:39
 **/
@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public SysUser queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public SysUser queryUserByLoginName(String loginName) {
        return userMapper.queryUserByLoginName(loginName);
    }

    @Override
    public List<String> queryRoleListByUserId(Long userId) {
        return userMapper.queryRoleListByUserId(userId);
    }

    @Override
    public List<String> queryPermissionListByUserId(Long userId) {
        return userMapper.queryPermissionListByUserId(userId);
    }

    @Override
    public List<SysUser> queryUserList(SysUser user) {
        return userMapper.queryUserList(user);
    }

    @Override
    public int insertUser(SysUser user) {
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


}
