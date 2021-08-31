package com.quartz.demo5;

import cn.hutool.core.date.DateUtil;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;


/**
 * @author huxingxin
 * @createTime 2021年08月22日 19:49:37
 * @Description 永久执行的定时器  每隔2秒执行一次 cron表达式
 */
public class QuartzTest {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        System.out.println(DateUtil.now());
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

//        Date date = DateBuilder.nextGivenSecondDate(null, 8);
        Date date = DateBuilder.futureDate(0, DateBuilder.IntervalUnit.SECOND);//任务开始时间

        JobDetail job = JobBuilder.newJob(ForeverJob.class)
                .withIdentity("jobGroup", "jobGroup")
                .build();

        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("triggerGroup", "triggerGroup")
                .startAt(date)
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();

        scheduler.scheduleJob(job,trigger);
        scheduler.start();

        Thread.sleep(20000);
        scheduler.shutdown(true);
    }
}
