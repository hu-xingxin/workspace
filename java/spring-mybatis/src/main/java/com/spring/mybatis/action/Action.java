package com.spring.mybatis.action;

import com.spring.mybatis.domain.SysUser;
import com.spring.mybatis.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-12 14:09
 **/
public class Action {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService userService = context.getBean(UserService.class);
        SysUser sysUser = new SysUser();
        sysUser.setDeptId(10000L);
        sysUser.setLoginName("loginName2");
        sysUser.setUserName("userName2");
        Integer index = userService.insertUser(sysUser);
        System.out.println(index);
    }
}
