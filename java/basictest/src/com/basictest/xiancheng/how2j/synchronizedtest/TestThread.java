package com.basictest.xiancheng.how2j.synchronizedtest;

import static java.time.LocalDateTime.now;

/**
 * @author huxingxin
 * @createTime 2021年07月25日 13:15:13
 * @Description  synchronized 同步对象的方式
 */
public class TestThread {
    public static void main(String[] args) {
        final Object object = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                System.out.println(now() + "---" + threadName + "线程已经运行");
                System.out.println(now() + "---" + threadName + "试图占有对象：" + object);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(now() + "---" + threadName + "释放对象" + object);
                System.out.println(now() + "---" + threadName + "线程结束" + object);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                System.out.println(now() + "---" + threadName + "线程已经运行");
                System.out.println(now() + "---" + threadName + "试图占有对象：" + object);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(now() + "---" + threadName + "释放对象" + object);
                System.out.println(now() + "---" + threadName + "线程结束" + object);
            }
        }).start();
    }
}
