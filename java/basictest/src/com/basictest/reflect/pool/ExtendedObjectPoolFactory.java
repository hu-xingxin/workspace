package com.basictest.reflect.pool;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-16 13:48
 **/
public class ExtendedObjectPoolFactory {
    private Map<String,Object> objectPool = new HashMap<>();
    private Properties config =  new Properties();

    public void init(String fileName){
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(fileName);
            config.load(fis);
        }catch (IOException e){
            System.out.println("读取" + fileName + "异常");
        }finally {
            try {
                if(fis != null){
                    fis.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private Object createObject(String className) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class<?> aClass = Class.forName(className);
        return aClass.newInstance();
    }

    public void initPool() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        for (String name: config.stringPropertyNames()) {
            if (!name.contains("%")){
                objectPool.put(name,createObject(config.getProperty(name)));
            }
        }
    }

    public void initProperty() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (String name : config.stringPropertyNames()){
            if(name.contains("%")){
                String[] objAndProp = name.split("%");
                Object target = getObject(objAndProp[0]);
                String mtdName = "set" + objAndProp[1].substring(0,1).toUpperCase()+
                        objAndProp[1].substring(1);

                Class<?> targetClass = target.getClass();
                Method method = targetClass.getMethod(mtdName, String.class);
                method.invoke(target,config.getProperty(name));
            }
        }
    }

    public Object getObject(String name){
        return objectPool.get(name);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        ExtendedObjectPoolFactory epf = new ExtendedObjectPoolFactory();
        epf.init("extObject.txt");
        epf.initPool();
        epf.initProperty();
        Object jFrame = epf.getObject("jFrame");
        System.out.println(jFrame);
    }
}
