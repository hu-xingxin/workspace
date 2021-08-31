package com.basictest.xiancheng.how2j.mypool;

import java.util.LinkedList;

/**
 * @author huxingxin
 * @createTime 2021年07月24日 12:44:32
 * @Description 线程池模拟
 */
public class ThreadPool {
    int threadPoolSize;//线程池大小

    LinkedList<Runnable> tasks = new LinkedList<>();//任务容器

    public ThreadPool(){
        threadPoolSize = 10;

        synchronized (tasks){
            //创建线程池的时候 初始化十个线程
            for (int i = 0; i < threadPoolSize; i++){
                new TaskConsumeThread("任务消费者线程" + i).start();
            }
        }
    }

    /**
     * 将线程任务 添加到线程池
     * @param r
     */
    public void add(Runnable r){
        synchronized (tasks){
            tasks.add(r);
            tasks.notifyAll();
        }
    }

    class TaskConsumeThread extends Thread{
        public TaskConsumeThread(String name){
            super(name);
        }

        Runnable task;

        @Override
        public void run() {
            System.out.println("启动" + this.getName());
            while (true){
                synchronized (tasks){
                    while (tasks.isEmpty()){
                        try {
                            tasks.wait();
//                            System.out.println("等待添加新线程");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = tasks.removeLast();
                    tasks.notifyAll();
                }
                System.out.println(this.getName()+"获取到任务, 并执行");
                task.run();
            }
        }
    }
}
