package com.basictest.mianxiangduixiang.bibao;

/**
 * Created in 2021/3/7 22:27
 *
 * @author: huxingxin
 */
public class Demo1 extends Programmer implements Teachable{
    public Demo1(){

    }

    public Demo1(String name){
        super(name);
    }

    public void work(){
        System.out.println(getName()+"在给学生上课");
    }

}
