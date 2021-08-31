package com.basictest.mianxiangduixiang.danlimoshi;

/**
 * Created in 2021/2/5 11:28
 *
 * @description:
 * @Author: huxingxin
 */
public class Singleton {

    //使用一个变量存储曾经创建过的实例
    private static Singleton singleton;

    //将构造器用private修饰，隐藏该构造器
    private Singleton(){

    }

    //提供一个静态方法，返回Singleton实例
    //并且保证只产生一个Singleton对象
    public static Singleton getSingleton(){
        //如果singleton为空，表明未曾创建Singleton对象
        //如果singleton不为空，表明已经创建Singleton对象，则不执行
        if(singleton==null){
            //创建一个Singleton对象，并将其缓存起来
             singleton =  new Singleton();
        }
        return singleton;
    }
}
