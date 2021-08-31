package com.basictest.system;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author huxingxin
 * @createTime 2021年08月15日 14:05:18
 * @Description
 */
public class JavaPath {
    public static void main(String[] args) throws IOException {
        // F:\code\workspace\java\basictest
        System.out.println("System.getProperty(\"user.dir\"):" + System.getProperty("user.dir"));
        System.out.println("System.getProperty(\"java.class.path\"):" + System.getProperty("java.class.path"));

        // F:\code\workspace\java\basictest
        File file = new File("");
        System.out.println("getAbsolutePath:" + file.getAbsolutePath());
        System.out.println("getCanonicalPath:" + file.getCanonicalPath());

        // F:/code/workspace/java/basictest/out/production/basictest/
        String classPath = Class.class.getClass().getResource("/").getPath();
        System.out.println("classPath:" + classPath);

        URL resource = Class.class.getResource("/");
        System.out.println("path1:" + resource);

//        String path = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
//        System.out.println(path);

    }
}
