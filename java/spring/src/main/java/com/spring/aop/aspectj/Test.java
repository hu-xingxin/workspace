package com.spring.aop.aspectj;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-11 14:57
 **/
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext-aspectj.xml");
        Person person = context.getBean(Person.class);
        person.eat("鸡蛋");
    }
}
