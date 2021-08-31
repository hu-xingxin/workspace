package com.basictest.xiancheng.thread;

/**
 * @author huxingxin
 * @date 2021/4/13 9:44
 * @Description:
 */
public class DaemonThread implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i<100; i++){
            System.out.println(Thread.currentThread().getName()+":"+i);

        }
    }

    public static void main(String[] args) {

        DaemonThread daemonThread = new DaemonThread();
        Thread thread = new Thread(daemonThread);
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i<10; i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}