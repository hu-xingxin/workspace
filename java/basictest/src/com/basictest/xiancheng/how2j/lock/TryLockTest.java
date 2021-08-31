package com.basictest.xiancheng.how2j.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huxingxin
 * @createTime 2021年07月25日 16:34:52
 * @Description
 */
public class TryLockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean locked = false;
                try {
                    log("线程启动");
                    log("试图占有对象: " + lock);
                    locked = lock.tryLock(1, TimeUnit.SECONDS);
                    if (locked){
                        log("占有对象: " + lock);
                        Thread.sleep(1000);
                    }else {
                        log("经过1秒钟的努力，还没有占有对象，放弃占有" + lock);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    if (locked){
                        lock.unlock();
                        log("释放对象：" + lock);
                    }
                }
            }
        }).start();

        //休眠两秒
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean locked = false;
                try {
                    log("线程启动");
                    log("试图占有对象: " + lock);
                    locked = lock.tryLock(1, TimeUnit.SECONDS);
                    if (locked){
                        log("占有对象: " + lock);
                        Thread.sleep(1000);
                    }else {
                        log("经过1秒钟的努力，还没有占有对象，放弃占有" + lock);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    if (locked){
                        lock.unlock();
                        log("释放对象：" + lock);
                    }
                }
            }
        }).start();
    }

    /**
     * 获取当时的时间 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String now(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * 打印日志
     * @param msg
     */
    public static void log(String msg){
        System.out.printf("%s %s %s %n", now() , Thread.currentThread().getName() , msg);
    }
}
