package com.basictest.reflect.aop;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-17 14:52
 **/
public class Test {
    public static void main(String[] args) {
        Animal target = new Dog();
        Animal proxy = (Animal)MyProxyFactory.getProxy(target);
        proxy.info();
        proxy.run();
    }
}
