package com.quartz.demo3;

import com.utils.DateUtil;
import lombok.SneakyThrows;
import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;

/**
 * @author huxingxin
 * @createTime 2021年08月22日 18:57:29
 * @Description 可以终止的定时任务
 */
public class StopTestJob implements InterruptableJob {
    private boolean flag = false;

    @Override
    public void interrupt() throws UnableToInterruptJobException {
        flag = true;
        System.out.println("被调度叫停");
    }

    @SneakyThrows
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        while (true){
            if (flag){
                break;
            }
            System.out.printf("%s: 持续工作中。。。%n", DateUtil.getDateTime());
            Thread.sleep(1000);
        }
    }
}
