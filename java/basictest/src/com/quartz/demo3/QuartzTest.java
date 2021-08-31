package com.quartz.demo3;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author huxingxin
 * @createTime 2021年08月22日 19:00:35
 * @Description
 */
public class QuartzTest {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        //创建调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //定义一个触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("triggerGroup", "triggerGroup")
                .startNow()
                .build();
        //定义一个jobDetail
        JobDetail jobDetail = JobBuilder.newJob(StopTestJob.class)
                .withIdentity("jobGroup", "jobGroup")
                .build();
        //调度加入job
        scheduler.scheduleJob(jobDetail,trigger);
        //启动
        scheduler.start();
        //等待十秒 终止定时任务
        Thread.sleep(5000);
        scheduler.interrupt(jobDetail.getKey());

        //等待20秒 任务执行完毕 再关闭调度器
        Thread.sleep(10000);
        scheduler.shutdown(true);
    }
}
