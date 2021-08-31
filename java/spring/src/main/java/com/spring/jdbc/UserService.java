package com.spring.jdbc;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-11 15:47
 **/
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public Integer insertUser(SysUser user){
        return userDao.insertUser(user);
    }
}
