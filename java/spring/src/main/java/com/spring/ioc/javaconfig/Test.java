package com.spring.ioc.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-10 14:10
 **/
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.selectUser();
    }
}
