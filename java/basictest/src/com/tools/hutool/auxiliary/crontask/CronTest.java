package com.tools.hutool.auxiliary.crontask;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import org.junit.Test;

/**
 * @author huxingxin
 * @createTime 2021年08月02日 10:02:53
 * @Description 启动定时任务
 */
public class CronTest {

    @Test
    public void test(){
        cronTask1();
//        cronTask2();
    }

    public void cronTask1(){
        CronUtil.setMatchSecond(true);
        CronUtil.start();
        CronUtil.schedule("*/1 * * * * ?",
                (Task) ()->System.out.println(DateUtil.now() + Thread.currentThread().getName() + " 执行新任务1"));

        CronUtil.schedule("*/1 * * * * ?",
                (Task) ()->System.out.println(DateUtil.now() + Thread.currentThread().getName() + " 执行新任务2"));
        //junit测试在TestRunner类里开启main方法来进行对方法的测试,
        // main方法里有System.exit();
        // 测试多线程时main线程会执行System.exist(),
        // jvm就会结束运行，不执行其他线程
        ThreadUtil.sleep(10000);
    }

}
