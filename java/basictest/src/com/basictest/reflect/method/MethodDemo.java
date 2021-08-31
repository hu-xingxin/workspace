package com.basictest.reflect.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author huxingxin
 * @ClassName MethodDemo.java
 * @Description 通过反射技术，向一个泛型为Integer的集合中添加一些字符串数据
 * @createTime 2021年07月15日 17:05:00
 */
public class MethodDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        Class<? extends ArrayList> listClass = list.getClass();
        Method add = listClass.getMethod("add", Object.class);
        add.invoke(list,"hello");
        add.invoke(list,"你好");
        add.invoke(list,123);
        add.invoke(list,34.34);

        System.out.println(list);
    }
}
