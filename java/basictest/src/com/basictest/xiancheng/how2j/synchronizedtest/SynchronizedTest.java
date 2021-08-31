package com.basictest.xiancheng.how2j.synchronizedtest;

/**
 * @author huxingxin
 * @createTime 2021年07月24日 03:44:47
 * @Description
 * 1. 线程1 首先占有对象1，接着试图占有对象2
 * 2. 线程2 首先占有对象2，接着试图占有对象1
 * 3. 线程1 等待线程2释放对象2
 * 4. 与此同时，线程2等待线程1释放对象1
 * 就会。。。一直等待下去，直到天荒地老，海枯石烂，山无棱 ，天地合。。。
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        Object objectA = new Object();
        Object objectB = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objectA){
                    System.out.println(objectA);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (objectB){
                        System.out.println(objectB);
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objectB){
                    System.out.println(objectB);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (objectA){
                        System.out.println(objectA);
                    }
                }
            }
        }).start();
    }
}
