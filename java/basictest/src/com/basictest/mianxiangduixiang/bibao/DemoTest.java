package com.basictest.mianxiangduixiang.bibao;

/**
 * Created in 2021/3/7 20:49
 *
 * @author: huxingxin
 */
public class DemoTest {
    public static void main(String[] args) {
//        Demo1 demo = new Demo1("胡兴新");
//        demo.work();

        Demo2 demo2 = new Demo2("胡兴新");
        demo2.work();
        demo2.getCallBack().work();
    }
}
