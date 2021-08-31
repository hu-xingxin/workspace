package com.basictest.xiancheng.how2j.lock.stack;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author huxingxin
 * @createTime 2021年07月25日 22:02:50
 * @Description
 */
public class MyStackTest {
    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    myStack.push(now());
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    myStack.pull();
                }
            }
        }).start();
    }



    public static String now(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
