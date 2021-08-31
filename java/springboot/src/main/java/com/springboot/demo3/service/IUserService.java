package com.springboot.demo3.service;

import com.springboot.demo3.domain.SysUser;

import java.util.List;
import java.util.Map;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-18 11:38
 **/
public interface IUserService {
    public SysUser queryUserById(Integer id);
    public List<SysUser> queryUserList(SysUser user);
    public int insertUser(SysUser user);
    public int updateUser(SysUser user);
    public int deleteUserById(Integer id);

}
