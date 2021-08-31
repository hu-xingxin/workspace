package com.spring.hibernate.service;

import com.spring.hibernate.dao.UserDao;
import com.spring.hibernate.pojo.SysUser;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-11 22:47
 **/
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public Integer addUser(SysUser user){
        return userDao.insertUser(user);
    }
}
