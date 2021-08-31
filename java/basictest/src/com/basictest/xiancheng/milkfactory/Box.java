package com.basictest.xiancheng.milkfactory;

/**
 * @author huxingxin
 * @ClassName Box.java
 * @Description 奶箱类 提供存储牛奶和获取牛奶
 * @createTime 2021年07月13日 20:10:00
 */
public class Box {
    private int milkNum=0;//牛奶数量
    private boolean flag = false;//奶箱状态 true表示有牛奶 false表示无牛奶

    /**
     * 生产牛奶
     */
    public synchronized void product(){
        //如果没有牛奶 则生产
        if (!flag){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"生产了牛奶：" + (milkNum+=10));
            System.out.println("牛奶数量：" + milkNum);
            flag = true;
            notifyAll();
        }else {
            //如果有牛奶 则等待消费
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消费牛奶
     */
    public synchronized void consume(){
        //如果有牛奶 则消费
        if (flag){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"消费了牛奶：" + (milkNum-=10));
            System.out.println("牛奶数量：" + milkNum);
            flag = false;
            notifyAll();
        }else {
            //如果没有牛奶 则等待生产
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
