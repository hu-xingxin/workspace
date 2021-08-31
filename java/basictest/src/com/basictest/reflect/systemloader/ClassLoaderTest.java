package com.basictest.reflect.systemloader;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-13 17:15
 **/
class Tester{
    static{
        System.out.println("Tester类的静态初始化块...");
    }

}

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        try {
            systemClassLoader.loadClass("com.basictest.reflect.systemloader.Tester");
            Class.forName("com.basictest.reflect.systemloader.Tester");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
