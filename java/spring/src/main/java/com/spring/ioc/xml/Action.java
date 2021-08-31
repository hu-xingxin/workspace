package com.spring.ioc.xml;

import com.spring.domain.User;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-10 15:12
 **/
public class Action {
    private UserServiceImpl userServiceImpl;

    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    public User selectUser(){
        return userServiceImpl.selectUser();
    }
}
