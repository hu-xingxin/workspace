package com.spring.quartz.demo2;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-12 20:04
 **/
public class MyJob extends QuartzJobBean {
    public static Long index = 1L;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String time = simpleDateFormat.format(new Date());
        System.out.println(time + "定时任务" + (index++));
    }
}
