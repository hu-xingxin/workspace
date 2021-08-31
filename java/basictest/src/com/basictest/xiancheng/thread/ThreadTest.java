package com.basictest.xiancheng.thread;

/**
 * @author huxingxin
 * @date 2021/4/12 14:44
 * @Description:
 */
public class ThreadTest extends Thread{
    private int i = 0;

    public void run(){
        for (;i<10;i++){
            String threadName = this.getName();
            System.out.println(threadName + ":" + i);

        }
    }

    public static void main(String[] args) {
        for (int i = 0;i<10;i++){
//            String threadName = Thread.currentThread().getName() + ":" + i;
//            System.out.println(threadName);
            if (i==2){
                new ThreadTest().start();
                new ThreadTest().start();
            }
        }
    }
}
