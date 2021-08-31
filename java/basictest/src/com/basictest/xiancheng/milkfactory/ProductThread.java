package com.basictest.xiancheng.milkfactory;

/**
 * @author huxingxin
 * @ClassName ProductThread.java
 * @Description
 * @createTime 2021年07月13日 20:38:00
 */
public class ProductThread implements Runnable{
    private Box box;

    public ProductThread(){

    }

    public ProductThread(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        while (true){
            box.product();
        }
    }
}
