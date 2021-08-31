package com.basictest.xiancheng.how2j.method;

/**
 * @author huxingxin
 * @ClassName PrioprityTest.java
 * @Description
 * @createTime 2021年07月22日 10:31:00
 */
public class PriorityTest {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "--" + i);
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "--" + i);
                }
            }
        });

        thread1.start();
        thread1.setPriority(Thread.MIN_PRIORITY);

        thread2.start();
        thread2.setPriority(Thread.MAX_PRIORITY);
    }
}
