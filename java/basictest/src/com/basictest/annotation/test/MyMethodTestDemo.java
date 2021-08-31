package com.basictest.annotation.test;

import com.basictest.annotation.tag.MyMethodTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created in 2021/4/7 11:42
 *
 * @author: huxingxin
 */
public class MyMethodTestDemo {
    public static void main(String[] args) {
        process("com.basictest.annotation.test.AnnotationTest");
    }

    public static void process(String myClass){
        int passed = 0;
        int failed = 0;
        try {
            Method[] methods = Class.forName(myClass).getMethods();
            for (Method method : methods){
                boolean isHasTest = method.isAnnotationPresent(MyMethodTest.class);
                if (isHasTest){
                    method.invoke(null);
                    passed++;
                }
            }
        } catch (Exception e){
            failed++;
            e.printStackTrace();
        }

        System.out.println("共运行了"+(passed+failed)+"个方法");
        System.out.println("成功了"+passed+"个方法");
        System.out.println("失败了"+failed+"个方法");
    }
}
