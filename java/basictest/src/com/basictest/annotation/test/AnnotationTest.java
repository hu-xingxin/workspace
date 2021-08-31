package com.basictest.annotation.test;

import com.basictest.annotation.tag.MyMethodTest;
import com.basictest.annotation.tag.MyTag;

/**
 * Created in 2021/4/7 10:14
 * 自定义注解测试
 * @author: huxingxin
 */
public class AnnotationTest {
    public static void main(String[] args) {
        test();
    }

    @Deprecated
    @MyTag
    public static void test(){
        System.out.println("Annotation test");
    }


    @MyMethodTest
    public static void method1(){

    }

    public static void method2(){

    }

    @MyMethodTest
    public static void method3(){

    }

    public static void method4(){

    }
}
