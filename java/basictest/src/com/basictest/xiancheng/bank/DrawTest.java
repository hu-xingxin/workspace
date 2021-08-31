package com.basictest.xiancheng.bank;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author huxingxin
 * @date 2021/4/12 16:04
 * @Description:
 */
public class DrawTest {
    public static void main(String[] args) {
        Account account = new Account("no1",0);
        new DrawThread("A", account, 800).start();
        new DepositThread("B", account, 800).start();

    }
}
