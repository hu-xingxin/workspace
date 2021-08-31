package com.spring.aop;

import org.springframework.aop.ThrowsAdvice;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-11 14:18
 **/
public class MyExceptionAdvice implements ThrowsAdvice {
    public void afterThrowing(Throwable throwable){
        System.out.println("产生异常:" + throwable.getMessage());
    }
}
