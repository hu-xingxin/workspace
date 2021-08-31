package com.basictest.reflect.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author huxingxin
 * @ClassName Demo.java
 * @Description 通过反射运行配置文件中指定类的指定方法
 * @createTime 2021年07月15日 17:23:00
 */
public class Demo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        String filePath = "F:\\代码\\workspace\\java\\basictest\\src\\com\\basictest\\reflect\\properties\\properties.txt";
        try (FileReader reader = new FileReader(filePath);){
            properties.load(reader);
            //类名
            String className = properties.getProperty("className");
            //方法名
            String methodName = properties.getProperty("methodName");

            //获取该类对于的Class对象
            Class<?> aClass = Class.forName(className);
            //获取构造方法对象
            Constructor<?> constructor = aClass.getConstructor();
            //实例化对象
            Object object = constructor.newInstance();

            //获取方法
            Method setName = aClass.getMethod("setName",String.class);
            Method sing = aClass.getMethod(methodName,String.class);
            //运行方法
            setName.invoke(object,"喜羊羊");
            sing.invoke(object,"喜羊羊与灰太狼");

            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
