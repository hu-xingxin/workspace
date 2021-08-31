package com.basictest.xiancheng.pool;

import java.lang.reflect.Executable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huxingxin
 * @date 2021/4/13 20:43
 * @Description:
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(6);
        pool.submit(new ThreadTest());
        pool.submit(new ThreadTest());
        pool.shutdown();
    }
}
