package com.basictest.reflect.aop;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-17 11:44
 **/
public class Dog implements Animal{
    @Override
    public void info() {
        System.out.println("我是一匹孤狼!");
    }

    @Override
    public void run() {
        System.out.println("奔跑在大草原上!");
    }
}
