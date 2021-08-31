package com.springmvc.app03.service;

import com.springmvc.app03.domain.SysUser;

import java.util.List;

/**
 * @author huxingxin
 * @createTime 2021年08月12日 09:57:55
 * @Description
 */
public interface UserService {
    public SysUser queryUserById(Integer id);
    public List<SysUser> queryUserList(SysUser user);
    public int insertUser(SysUser user);
    public int updateUser(SysUser user);
    public int deleteUserById(Integer id);
    public int queryPageCount();
}
