package com.basictest.xiancheng.thread;

/**
 * @author huxingxin
 * @date 2021/4/13 9:22
 * @Description:
 */
public class
JoinThread implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<15; i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }


    public static void main(String[] args) throws InterruptedException {

        for (int i=0; i<15; i++){
            if (i==0){
                JoinThread joinThread = new JoinThread();
                Thread thread = new Thread(joinThread);
                thread.start();
                thread.join();
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
