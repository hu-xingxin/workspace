package com.basictest.xiancheng.exception;

/**
 * @author huxingxin
 * @date 2021/4/13 16:43
 * @Description:
 */
public class MyExHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.err.println(t+"线程出现了异常：" + e);
    }
}
