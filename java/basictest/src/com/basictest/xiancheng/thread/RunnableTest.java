package com.basictest.xiancheng.thread;

/**
 * @author huxingxin
 * @date 2021/4/12 14:54
 * @Description:
 */
public class RunnableTest implements Runnable{
    private int i = 0;

    @Override
    public void run() {
        for (;i<10;i++){
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ":" + i);
        }
    }

    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        new Thread(runnableTest).start();
        new Thread(runnableTest).start();
    }
}
