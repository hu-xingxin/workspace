package com.basictest.xiancheng.milkfactory;

/**
 * @author huxingxin
 * @ClassName ConsumeThread.java
 * @Description
 * @createTime 2021年07月13日 20:40:00
 */
public class ConsumeThread implements Runnable{
    private Box box;

    public ConsumeThread(){

    }

    public ConsumeThread(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        while (true){
            box.consume();
        }
    }
}
