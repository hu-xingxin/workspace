package com.basictest.xiancheng.how2j.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huxingxin
 * @createTime 2021年07月25日 13:52:55
 * @Description 使用Lock对象实现同步效果
 */
public class LockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(new Runnable() {
           @Override
           public void run() {
               while (true){
                   try{
                       log("线程启动");
                       log("试图占有对象" + lock);
                       lock.lock();
                       log("占有对象" + lock);
                       log("临时释放对象,并等待" + lock);
                       condition.await();
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }finally {
                       lock.unlock();
                       log("释放对象" + lock);
                   }
                   log("线程结束");
               }
           }
       }).start();

//        //休眠两秒
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try{
                        log("线程启动");
                        log("试图占有对象" + lock);
                        lock.lock();
                        log("占有对象" + lock);
                        Thread.sleep(1000);
                        log("唤醒等待中的线程" + lock);
                        condition.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                        log("释放对象" + lock);
                    }
                    log("线程结束");
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
