package com.basictest.reflect.ClassInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-14 17:19
 **/
public class ClassTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        Class<Student> studentClass1 = Student.class;
        Class<Student> studentClass2 = Student.class;
        System.out.println(studentClass1==studentClass2);

        //返回所有公共构造方法对象的数组
        Constructor<?>[] constructors = studentClass1.getConstructors();
        for (Constructor constructor : constructors){
            System.out.println(constructor);

        }

        //返回单个公共构造方法对象
        Constructor<Student> constructor = studentClass1.getConstructor();
        System.out.println(constructor);

        Class<Student> studentClass = Student.class;
        //返回所有构造方法对象的数组
//        Constructor<?>[] ctors = studentClass.getDeclaredConstructors();
//        for(Constructor c :ctors){
//            System.out.println(c);
//        }
//
//        Annotation[] annotations = studentClass.getAnnotations();
//        for(Annotation a : annotations){
//            System.out.println(a);
//        }

        Student student = studentClass.newInstance();
//        System.out.println(student);
//        System.out.println(new Student());
        Method setName = studentClass.getMethod("setName",String.class);
        Method sing = studentClass.getMethod("sing",String.class);
        setName.invoke(student,"胡兴新");
        sing.invoke(student,"小星星");
    }
}
