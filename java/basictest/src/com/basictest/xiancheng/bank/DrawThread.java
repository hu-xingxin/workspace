package com.basictest.xiancheng.bank;

/**
 * @author huxingxin
 * @date 2021/4/12 15:58
 * @Description:
 */
public class DrawThread extends Thread {
    private Account account;
    private double drawAmount;

    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
//        synchronized (account){
//            if (account.getBalance()>=drawAmount){
//                System.out.println("账户余额"+account.getBalance());
//                System.out.println("取出"+drawAmount);
//                account.setBalance(account.getBalance()-drawAmount);
//                System.out.println("剩余"+account.getBalance());
//            }else {
//                System.out.println(getName()+"余额不足!");
//            }
//        }
        for (int i=0;i<10;i++){
            try {
                account.draw(drawAmount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
