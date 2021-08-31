package com.basictest.xiancheng.how2j.mypool;

/**
 * @author huxingxin
 * @createTime 2021年07月24日 12:54:50
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();

        for (int i = 0; i<5; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("--------------");
                }
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadPool.add(thread);
        }
    }
}
