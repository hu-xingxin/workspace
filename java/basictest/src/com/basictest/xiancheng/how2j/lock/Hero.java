package com.basictest.xiancheng.how2j.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huxingxin
 * @createTime 2021年07月24日 03:55:39
 * @Description
 */
public class Hero {
    public String name;
    public float hp;

    public int damage;

    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void recover(){
        try {
            lock.lock();

            // 通知那些等待在this对象上的线程，可以醒过来了，如第20行，等待着的减血线程，苏醒过来
//           while (hp==10){
//               condition.await();
//           }
           condition.signal();
            hp=hp+1;
            System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f %s %s %n", name, name, hp,Thread.currentThread().getName(),now());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void hurt(){
        lock.lock();
        try {
//            让占有lock的减血线程，暂时释放对lock的占有，并等待
            while (hp==1){
                condition.await();
            }
            condition.signal();
            hp=hp-1;
            System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f %s %s %n", name, name, hp, Thread.currentThread().getName(),now());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void attackHero(Hero h) {
        h.hp-=damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f %s %n",name,h.name,h.name,h.hp,Thread.currentThread().getName());
        if(h.isDead())
            System.out.println(h.name +"死了！");
    }


    public boolean isDead() {
        return 0>=hp?true:false;
    }

    /**
     * 获取当时的时间 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String now(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
