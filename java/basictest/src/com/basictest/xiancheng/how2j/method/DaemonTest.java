package com.basictest.xiancheng.how2j.method;

/**
 * @author huxingxin
 * @ClassName DaemonTest.java
 * @Description
 * @createTime 2021年07月22日 15:27:00
 */
public class DaemonTest {
    public static void main(String[] args) {
        Thread t1= new Thread(){
            public void run(){
                int seconds =0;

                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了LOL %d 秒%n", seconds++);

                }
            }
        };

        //打开注释 则该线程不会启动运行
        t1.setDaemon(true);
        t1.start();
    }
}
