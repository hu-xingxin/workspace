package com.basictest.annotation.test;

import java.lang.annotation.Annotation;

/**
 * Created in 2021/4/7 11:01
 * 获取注解信息
 * @author: huxingxin
 */
public class MyTagDemo {
    public static void main(String[] args) {
        try {
            Annotation[] annotations = Class.forName("com.basictest.annotation.test.AnnotationTest").getMethod("test").getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
