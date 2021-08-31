package com.basictest.reflect.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-17 14:47
 **/
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public void setTarget(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtil dogUtil = new DogUtil();
        dogUtil.method1();
        Object result = method.invoke(target, args);
        dogUtil.method2();
        return result;
    }
}
