package com.basictest.reflect.pool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-16 13:08
 **/
public class ObjectPoolFactory {
    private Map<String,Object> objectPool = new HashMap<>();

    private Object createObject(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> myClass = Class.forName(className);
        return myClass.newInstance();
    }

    public void initPool(String fileName) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(fileName);
            Properties properties = new Properties();
            properties.load(fis);
            for (String name: properties.stringPropertyNames()) {
                objectPool.put(name,createObject(properties.getProperty(name)));
            }
        } catch (IOException e) {
            System.out.println("读取" + fileName + "异常");
        }finally {
            try{
                if (fis != null){
                    fis.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public Object getObject(String name){
        return objectPool.get(name);
    }

    public static void main(String[] args) throws Exception {
        ObjectPoolFactory factory = new ObjectPoolFactory();
        factory.initPool("object.txt");
        Object date = factory.getObject("date");
        System.out.println(date);
    }
}
