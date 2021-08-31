package com.basictest.mianxiangduixiang.duotai;

/**
 * Created in 2021/3/6 21:44
 *
 * @description:
 * @Author: huxingxin
 */
public class SubClass extends BaseClass{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void speak(){
        System.out.println("我是子类");
    }
}
