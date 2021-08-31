package com.basictest.mianxiangduixiang.jicheng;

/**
 * Created in 2021/2/1 19:39
 *
 * @description:
 * @Author: huxingxin
 */
public class TestDemo {
    public static void main(String[] args) {
        Object teacher = new Teacher();
        ((Teacher)teacher).speak();

        Object people = new People();
        System.out.println(people instanceof Object);
    }
}
