package com.spring.ioc.xml.annotation;

import com.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-10 15:12
 **/
@Controller
public class Action {
    @Autowired
    private UserServiceImpl userServiceImpl;

    public User selectUser(){
        return userServiceImpl.selectUser();
    }
}
