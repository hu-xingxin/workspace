package com.basictest.xiancheng.exception;

/**
 * @author huxingxin
 * @date 2021/4/13 16:44
 * @Description:
 */
public class Mian {
    public static void main(String[] args) {
        Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
        int a = 5/0;
    }
}
