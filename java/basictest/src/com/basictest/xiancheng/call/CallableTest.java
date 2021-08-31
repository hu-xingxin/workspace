package com.basictest.xiancheng.call;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author huxingxin
 * @date 2021/4/13 16:49
 * @Description:
 */
public class CallableTest {
    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(testThread);

        new Thread(integerFutureTask).start();

        try {
            System.out.println("子线程的返回值："+integerFutureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
