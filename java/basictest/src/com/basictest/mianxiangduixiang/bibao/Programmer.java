package com.basictest.mianxiangduixiang.bibao;

/**
 * Created in 2021/3/7 20:47
 *
 * @author: huxingxin
 */

interface Teachable{
    public void work();
}

public class Programmer {
    private String name;
    public Programmer(){}
    public Programmer(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void work(){
        System.out.println(name + "在写代码");
    }
}

