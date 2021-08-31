package com.basictest.xiancheng.ticket;

public class Test {
    public static void main(String[] args) {
        BuyTicketsThread buyTicketsThread = new BuyTicketsThread();
        Thread threadA = new Thread(buyTicketsThread,"窗口一");
        Thread threadB = new Thread(buyTicketsThread,"窗口二");
        Thread threadC = new Thread(buyTicketsThread,"窗口三");
        Thread threadD = new Thread(buyTicketsThread,"窗口四");
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}
