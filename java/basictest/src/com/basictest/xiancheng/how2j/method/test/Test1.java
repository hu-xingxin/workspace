package com.basictest.xiancheng.how2j.method.test;

/**
 * @author huxingxin
 * @ClassName Test1.java
 * @createTime 2021年07月22日 15:51:00
 * @Description 练习-英雄充能
 *              英雄有可以放一个技能叫做: 波动拳-a du gen。每隔一秒钟，可以发一次，但是只能连续发3次。
 *              发完3次之后，需要充能5秒钟，充满，再继续发。

 */
public class Test1 {

    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    System.out.println("释放技能：波动拳-a du gen");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();

        int index = 0;
        while (true){
            System.out.println("释放技能：波动拳-a du gen");
            index++;
            try {
                Thread.sleep(1000);
                if (index%3==0){
                    System.out.println("发完3次，需要充能5秒钟...");
                    Thread.sleep(5000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
