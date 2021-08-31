package com.tools.hutool.auxiliary.crontask;


import cn.hutool.core.date.DateUtil;

/**
 * @author huxingxin
 * @createTime 2021年08月02日 10:01:23
 * @Description 定时任务
 */
public class CronTask implements Runnable{
    @Override
    public void run() {
        System.out.println(DateUtil.now() + "this is HutoolCronTask");
    }
}
