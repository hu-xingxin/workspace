package com.basictest.reflect.invocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-17 11:00
 **/
class MyInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("正在执行的方法" + method);
        if (args != null) {
            System.out.println("下面是执行该方法时传入的实参：");
            for (Object val : args) {
                System.out.println(val);
            }
        } else {
            System.out.println("调用该方法无需实参!");
        }
        return null;
    }
}

public class ProxyTest{
    public static void main(String[] args) {
        MyInvocationHandler handler = new MyInvocationHandler();
        Person person = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler);
        person.walk();
        person.sayHello("你好呀");
    }
}