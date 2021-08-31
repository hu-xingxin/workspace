package com.spring.quartz.demo1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-12 20:04
 **/
public class MyJob {
    public  Long index = 1L;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");

    public void execute(){
        String time = simpleDateFormat.format(new Date());
        System.out.println(time + "定时任务" + (index++));
    }
}
