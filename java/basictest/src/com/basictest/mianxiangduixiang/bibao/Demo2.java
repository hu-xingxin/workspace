package com.basictest.mianxiangduixiang.bibao;

/**
 * Created in 2021/3/7 22:28
 *
 * @author: huxingxin
 */
public class Demo2 extends Programmer implements Teachable{
    public Demo2(){

    }
    public Demo2(String name){
        super(name);
    }

    private void teacher(){
        System.out.println(getName()+"在给学生上课");
    }

    private class InnerDemo2 implements Teachable{

        @Override
        public void work() {
            teacher();
        }
    }

    public Teachable getCallBack(){
        return new InnerDemo2();
    }
}
