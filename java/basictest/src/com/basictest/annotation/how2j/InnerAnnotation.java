package com.basictest.annotation.how2j;

/**
 * @author huxingxin
 * @createTime 2021年07月30日 14:16:55
 * @Description 基本内置注解
 */
public class InnerAnnotation {
    public static void main(String[] args) {
        deprecatedMethod();
    }

//    @Override
    public static void overrideMethod(){

    }

    @Deprecated
    public static void deprecatedMethod(){

    }
}
