package com.basictest.xiancheng.how2j.method;

/**
 * @author huxingxin
 * @ClassName JoinTest.java
 * @Description join	加入到当前线程中
 * @createTime 2021年07月22日 09:48:00
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "--" + i);
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "--" + i);
                }
            }
        });
        thread2.start();

        //线程加入到main线程中来，只有该线程运行结束，主线程才会继续往下走
        //thread1先运行 运行完 thread2开始运行
        thread1.join();
        thread2.join();

        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }


    }
}
