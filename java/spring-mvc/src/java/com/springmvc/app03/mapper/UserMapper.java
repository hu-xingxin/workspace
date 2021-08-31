package com.springmvc.app03.mapper;



import com.springmvc.app03.domain.SysUser;

import java.util.List;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-18 11:37
 **/
public interface UserMapper {
    public SysUser queryUserById(Integer id);
    public List<SysUser> queryUserList(SysUser user);
    public int insertUser(SysUser user);
    public int updateUser(SysUser user);
    public int deleteUserById(Integer id);
    public int queryPageCount();
}
