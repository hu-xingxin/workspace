package com.basictest.xiancheng.group;

/**
 * @author huxingxin
 * @date 2021/4/13 16:05
 * @Description:
 */
public class ThreadGroutTest {
    public static void main(String[] args) {
        ThreadGroup mianGroup = Thread.currentThread().getThreadGroup();
        System.out.println(mianGroup.getName());
        System.out.println(mianGroup.isDaemon());

        new TestThread().start();
        ThreadGroup threadGroup = new ThreadGroup("新线程租");
        threadGroup.setDaemon(true);
        System.out.println(threadGroup.isDaemon());

       new TestThread(threadGroup,"后台线程A").start();
       new TestThread(threadGroup,"后台线程B").start();

    }
}
