package com.basictest.xiancheng.group;

/**
 * @author huxingxin
 * @date 2021/4/13 15:49
 * @Description:
 */
public class TestThread extends Thread {
    public TestThread() {
    }

    public TestThread(String name) {
        super(name);
    }

    public TestThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
