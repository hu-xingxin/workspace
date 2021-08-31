package com.basictest.xiancheng.how2j.method;

/**
 * @author huxingxin
 * @ClassName PrioprityTest.java
 * @Description
 * @createTime 2021年07月22日 10:31:00
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        PrintThread printThread = new PrintThread(0);
        Thread thread1 = new Thread(printThread);
        thread1.start();
        Thread thread2 = new Thread(printThread);
        thread2.start();

//        thread2.setPriority(Thread.MAX_PRIORITY);
//        thread1.setPriority(Thread.MIN_PRIORITY);




//        for (; i < 10; i++){
//            System.out.println(Thread.currentThread().getName() + "--" + i);
//        }
    }
}
