package com.basictest.mianxiangduixiang.danlimoshi;

/**
 * Created in 2021/2/5 14:08
 *
 * @description:
 * @Author: huxingxin
 */
public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println(Singleton.getSingleton());
        System.out.println(Singleton.getSingleton());
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();
        System.out.println(singleton1==singleton2);
    }
}
