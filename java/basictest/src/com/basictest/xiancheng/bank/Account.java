package com.basictest.xiancheng.bank;

/**
 * @author huxingxin
 * @date 2021/4/12 15:56
 * @Description:
 */
public class Account {
    private String accountNo;
    private double balance;
    private boolean flag = false;

    public Account() {
    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public synchronized void draw(double drawAmount) throws InterruptedException {
        if (!flag){
            wait();
        }else {
            System.out.println(Thread.currentThread().getName()+"取钱:"+drawAmount);
            balance-=drawAmount;
            System.out.println("账户余额:"+balance);
            flag=false;
            notifyAll();
        }
    }

    public synchronized void deposit(double depositAmount) throws InterruptedException {
        if (flag){
            wait();
        }else {
            System.out.println(Thread.currentThread().getName()+"存钱:"+depositAmount);
            balance+=depositAmount;
            System.out.println("账户余额:"+balance);
            flag=true;
            notifyAll();
        }
    }
}
