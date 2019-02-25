package com.sky.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * 定义任务类
 * quartz定时任务框架
 * job   任务    你要做什么事
 * Trigger  触发器  你什么时候去做
 * Scheduler  任务调度   你什么时候需要去做什么事
 */
public class QuartzDemo implements Job {

    /**
     * 任务被触发所执行的方法
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("任务被触发执行的方法"+new Date());

    }
}
