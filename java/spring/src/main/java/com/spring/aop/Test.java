package com.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-11 11:32
 **/
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-aop.xml");
        Person person = context.getBean(Person.class);
        person.eat("粽子");
    }
}
