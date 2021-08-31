package com.basictest.xiancheng.milkfactory;

/**
 * @author huxingxin
 * @ClassName BoxDemo.java
 * @Description
 * @createTime 2021年07月13日 20:19:00
 */
public class BoxDemo {
    public static void main(String[] args) {
        Box box = new Box();
        ProductThread productThread = new ProductThread(box);
        ConsumeThread consumeThread = new ConsumeThread(box);
        Thread proThread = new Thread(productThread);
        Thread conThread = new Thread(consumeThread);
        proThread.start();
        conThread.start();
    }
}
