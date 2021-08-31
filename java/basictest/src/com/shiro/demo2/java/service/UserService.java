package com.shiro.demo2.java.service;

import com.shiro.demo2.java.domain.Permission;
import com.shiro.demo2.java.domain.Role;
import com.shiro.demo2.java.domain.User;

import java.util.List;

/**
 * @author huxingxin
 * @createTime 2021年08月16日 10:11:58
 * @Description
 */
public interface UserService {
    public List<User> queryUserList(User user);
    public List<String> queryRoleByUserId(Long userId);
    public List<String> queryPermissionByUserId(Long userId);
    public Integer insertUser(User user);
}
