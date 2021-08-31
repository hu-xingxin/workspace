package com.quartz.demo4;

import cn.hutool.core.date.DateUtil;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author huxingxin
 * @createTime 2021年08月22日 19:49:37
 * @Description 永久执行的定时器  每隔一秒执行一次
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

        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("triggerGroup", "triggerGroup")
                .startAt(date)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .repeatForever()
                        .withIntervalInSeconds(1))
                .build();

        scheduler.scheduleJob(job,trigger);
        scheduler.start();

        Thread.sleep(20000);
        scheduler.shutdown(true);
    }
}
