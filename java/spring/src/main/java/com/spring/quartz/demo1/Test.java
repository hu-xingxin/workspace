package com.spring.quartz.demo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-12 20:12
 **/
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:quartz/applicationContext-1.xml");

    }
}
