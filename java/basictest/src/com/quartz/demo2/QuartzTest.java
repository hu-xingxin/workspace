package com.quartz.demo2;

import com.quartz.demo1.MailJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


/**
 * @author huxingxin
 * @createTime 2021年08月22日 16:51:44
 * @Description
 */
public class QuartzTest {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        //创建调度器
        Scheduler scheduler = new StdSchedulerFactory().getDefaultScheduler();
        //定义一个触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("group", "TriggerTest")
                .startNow()
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(1)//每隔1秒执行一次
                        .withRepeatCount(2))//总共执行3次(第一次执行不算基数)
                .build();
        //定义一个JobDetail
        JobDetail job = JobBuilder.newJob(DatabaseJob.class)
                .withIdentity("group", "JobTest")
                .usingJobData("databaseName", "mybatis")
                .build();
        //调度加入这个job
        scheduler.scheduleJob(job,trigger);
        //启动
        scheduler.start();
        //等待20秒，让前面的任务都执行完了之后，再关闭调度器
        Thread.sleep(20000);
        scheduler.shutdown(true);
    }
}
