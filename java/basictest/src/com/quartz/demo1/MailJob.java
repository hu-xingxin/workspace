package com.quartz.demo1;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author huxingxin
 * @createTime 2021年08月22日 16:45:22
 * @Description
 */
public class MailJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail jobDetail = context.getJobDetail();
        String jobName = jobDetail.getJobDataMap().getString("jobName");
        String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        System.out.printf("%s : %s-%s%n",dateStr,jobName,Thread.currentThread().getName());
    }
}
