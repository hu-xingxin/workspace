package com.quartz.demo4;

import com.utils.DateUtil;
import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;

/**
 * @author huxingxin
 * @createTime 2021年08月22日 19:47:46
 * @Description
 */
public class ForeverJob implements InterruptableJob {
    @Override
    public void interrupt() throws UnableToInterruptJobException {

    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.printf("%s: 持续工作中。。。%n", DateUtil.getDateTime());
    }
}
