package com.spring.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-11 14:50
 **/
public class MyAdvice {
    public void before(){
        System.out.println("饭前...");
    }

    public void after(){
        System.out.println("饭后...");
    }

    public void around(ProceedingJoinPoint pj){
        try {
            before();
            pj.proceed();
            after();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void exception(Throwable throwable){
        System.out.println("异常...");
        System.out.println(throwable.getMessage());
    }
}
