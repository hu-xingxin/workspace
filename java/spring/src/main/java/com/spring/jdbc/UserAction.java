package com.spring.jdbc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-11 15:56
 **/
public class UserAction {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext-jdbc.xml");
        UserService userService = context.getBean(UserService.class);
        SysUser sysUser = new SysUser();
        sysUser.setDeptId(10000L);
        sysUser.setLoginName("loginName");
        sysUser.setUserName("userName");
        Integer index = userService.insertUser(sysUser);
        System.out.println(index);
    }
}
