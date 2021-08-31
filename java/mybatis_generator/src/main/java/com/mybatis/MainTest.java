package com.mybatis;

import com.mybatis.domain.SysUser;
import com.mybatis.service.SysUserServiceImpl;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-20 15:21
 **/
public class MainTest {
    public static void main(String[] args) {
        selectUserById();
    }

    public static void selectUserById(){
        SysUserServiceImpl sysUserService = new SysUserServiceImpl();
        SysUser user = sysUserService.selectByPrimaryKey(1L);
        System.out.println(user);

    }
}
