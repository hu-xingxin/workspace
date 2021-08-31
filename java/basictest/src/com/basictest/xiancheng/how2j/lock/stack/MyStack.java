package com.basictest.xiancheng.how2j.lock.stack;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huxingxin
 * @createTime 2021年07月25日 21:56:19
 * @Description 借助Lock，把MyStack修改为线程安全的类
 */
public class MyStack<T> {
    LinkedList<T> values = new LinkedList<T>();

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void push(T t){
        try {
            lock.lock();
            //如果values里面的数据大于等于200条 则等待取出
            while (values.size()>=3){
                condition.await();
            }
            condition.signalAll();
            values.add(t);
            log("放入" + t + "--" +values.size());
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T pull(){
        T t = null;
        try {
            lock.lock();
            //如果values里面的数据为空 则等待放入
            while (values.isEmpty()){
                condition.await();
            }
            condition.signalAll();
            t = values.removeLast();
            log("取出" + t + "--" +values.size());
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    /**
     * 打印日志
     * @param msg
     */
    public static void log(String msg){
        System.out.printf("%s %s %n", Thread.currentThread().getName() , msg);
    }

}
