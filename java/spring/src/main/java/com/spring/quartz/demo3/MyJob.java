package com.spring.quartz.demo3;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-12 20:04
 **/
@Component
public class MyJob {
    public  Long index = 1L;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");

    /**
     * 任务一
     */
    @Scheduled(cron = "0/5 * * * * ? ")
    public void execute(){
        String time = simpleDateFormat.format(new Date());
        System.out.println(time + "定时任务" + (index++));
    }

    /**
     * 任务二
     */
    @Scheduled(cron = "0/5 * * * * ? ")
    public void execute1(){
        String time = simpleDateFormat.format(new Date());
        System.out.println(time + "定时任务" + (index++));
    }
}
