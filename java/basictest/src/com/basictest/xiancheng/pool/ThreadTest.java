package com.basictest.xiancheng.pool;

/**
 * @author huxingxin
 * @date 2021/4/13 20:42
 * @Description:
 */
public class ThreadTest implements Runnable {
    @Override
    public void run() {
        for (int i=0; i<10; i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
