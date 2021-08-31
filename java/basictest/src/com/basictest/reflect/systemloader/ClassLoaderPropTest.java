package com.basictest.reflect.systemloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-14 15:47
 **/
public class ClassLoaderPropTest {
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统加载器: " +systemClassLoader);

        try {
            Enumeration<URL> resources = systemClassLoader.getResources("");
            while(resources.hasMoreElements()){
                System.out.println(resources.nextElement());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ClassLoader parent = systemClassLoader.getParent();
        System.out.println("扩展类加载器: " + parent);
        System.out.println("扩展类加载器的加载路径: " + System.getProperty("java.ext.dirs"));
        System.out.println("扩展类加载器的parent: " + parent.getParent());
    }
}
