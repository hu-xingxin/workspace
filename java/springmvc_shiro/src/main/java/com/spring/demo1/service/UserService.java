package com.spring.demo1.service;

import com.spring.demo1.domain.User;

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
