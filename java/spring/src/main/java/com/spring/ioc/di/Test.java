package com.spring.ioc.di;


import com.spring.ioc.di.service.UserServiceImpl;
import com.spring.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-10 11:43
 **/
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfig.class);
        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        User user = userService.selectUser();
        System.out.println(user);
        context.close();
    }
}
