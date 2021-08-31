package com.spring.quartz.demo3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-12 20:24
 **/
public class Test {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classpath:quartz/applicationContext-3.xml");
    }
}
