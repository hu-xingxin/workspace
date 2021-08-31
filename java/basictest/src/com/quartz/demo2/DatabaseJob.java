package com.quartz.demo2;

import lombok.SneakyThrows;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author huxingxin
 * @createTime 2021年08月22日 17:13:35
 * @Description
 * 默认的情况下，无论上一次任务是否结束或者完成，只要规定的时间到了，那么下一次就开始。
 * 上一次成功结束之后，才开始下一次 用@DisallowConcurrentExecution注解实现
 */
@DisallowConcurrentExecution
public class DatabaseJob implements Job {
    @SneakyThrows
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String databaseName = context.getJobDetail().getJobDataMap().getString("databaseName");

        //模拟任务需要五秒进行处理
        System.out.printf("给数据库 %s 备份, 耗时5秒 %n" ,databaseName);
        Thread.sleep(5000);

    }
}
