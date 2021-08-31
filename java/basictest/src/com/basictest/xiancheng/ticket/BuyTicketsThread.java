package com.basictest.xiancheng.ticket;

public class BuyTicketsThread implements Runnable{
    private int ticketNum = 100;
    @Override
    public void run() {
        while (true){
            synchronized(this){
                if (ticketNum>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"正在出售第" + ticketNum-- +"张票");
                }
            }
        }
    }
}
