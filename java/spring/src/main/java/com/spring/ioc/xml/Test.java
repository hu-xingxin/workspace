package com.spring.ioc.xml;

import com.spring.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-10 15:54
 **/
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        Action action = (Action) context.getBean("action");
        User user = action.selectUser();
        System.out.println(user);
    }
}
