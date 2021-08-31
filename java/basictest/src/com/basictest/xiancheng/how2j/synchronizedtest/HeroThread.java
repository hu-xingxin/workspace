package com.basictest.xiancheng.how2j.synchronizedtest;

/**
 * @author huxingxin
 * @createTime 2021年07月24日 03:58:36
 * @Description
 *  有两个线程，处理同一个英雄。
 * 一个加血，一个减血。
 * 减血的线程，发现血量=1，就停止减血，直到加血的线程为英雄加了血，才可以继续减血
 */
public class HeroThread {
    public static void main(String[] args) {
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 10;

        new Thread(new Runnable() {
            @Override
            public void run() {
               while (true){
                   gareen.hurt();
                   try {
                       Thread.sleep(500);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
               while (true){
                   gareen.recover();
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        }).start();
    }
}
