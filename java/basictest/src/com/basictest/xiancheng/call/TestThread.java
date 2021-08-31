package com.basictest.xiancheng.call;

import java.util.concurrent.Callable;

/**
 * @author huxingxin
 * @date 2021/4/13 16:48
 * @Description:
 */
public class TestThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for(; i<10;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
        return i;
    }
}
