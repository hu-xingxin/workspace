package com.basictest.reflect.aop;

import java.lang.reflect.Proxy;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-17 14:50
 **/
public class MyProxyFactory {
    public static Object getProxy(Object target){
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.setTarget(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);
    }
}
