package com.basictest.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author huxingxin
 * @createTime 2021年07月28日 20:38:30
 * @Description
 */
public class LogUtil {
    private Class aClass;
    private String level;
    private Long startTime = System.currentTimeMillis();

    public LogUtil(Class aClass){
        this.aClass =aClass;
    }

    public static LogUtil getLogUtil(Class aClass){
        return new LogUtil(aClass);
    }

    /**
     * 获特定格式的时间字符串
     * @return
     */
    private String getDateTime(){
        Date date = new Date();
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static void log(String msg){
        System.out.println(msg);
    }

    /**
     * 输出
     * @param msg
     */
    public void info(String msg){
        Long endTime = System.currentTimeMillis();
        System.out.printf("[INFO] %s [%s] %s --> %s \n",getDateTime(),Thread.currentThread().getName(),aClass.getName(),msg);
    }
}
