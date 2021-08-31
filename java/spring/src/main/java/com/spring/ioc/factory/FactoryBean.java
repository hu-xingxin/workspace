package com.spring.ioc.factory;


/**
 * @description
 * @author: hxx
 * @create: 2021-06-10 14:47
 **/
public class FactoryBean {
    public static UserMapper getUserMapper(){
        return new UserMapper();
    }

    public static UserServiceImpl getUserServiceImpl(){
        return new UserServiceImpl();
    }
}
