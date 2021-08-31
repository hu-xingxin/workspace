package com.spring.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-11 09:27
 **/
public class MyBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        before();
//        method.invoke(target,args);
    }

    public void before(){
        System.out.println("饭前水果...");
    }
}
