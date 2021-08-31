package com.spring.hibernate.action;

import com.spring.hibernate.pojo.SysUser;
import com.spring.hibernate.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-12 01:39
 **/
public class Action {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext-hibernate.xml");
        UserService userService = context.getBean(UserService.class);

        SysUser sysUser = new SysUser();
        sysUser.setDeptId(10000);
        sysUser.setLoginName("loginName1");
        sysUser.setUserName("userName1");
        Integer index = userService.addUser(sysUser);
        System.out.println(index);
    }
}
