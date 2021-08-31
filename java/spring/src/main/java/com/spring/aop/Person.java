package com.spring.aop;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-11 09:26
 **/
public class Person {
    public void eat(String food){
        int a = 1/0;
        System.out.println(a);
        System.out.println("吃："+food);
    }
}
