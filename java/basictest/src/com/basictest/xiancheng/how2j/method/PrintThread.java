package com.basictest.xiancheng.how2j.method;

/**
 * @author huxingxin
 * @ClassName PrintThread.java
 * @Description
 * @createTime 2021年07月22日 14:47:00
 */
public class PrintThread implements Runnable {
    private int i;

    public PrintThread(int i){
        this.i = i;
    }

    @Override
    public void run() {
        while (i<10){
            synchronized(this){
                System.out.println(Thread.currentThread().getName() + "--" + i);
                i++;
            }
        }
    }
}
