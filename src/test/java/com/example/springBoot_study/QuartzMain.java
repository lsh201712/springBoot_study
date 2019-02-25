package com.example.springBoot_study;

import com.sky.quartz.QuartzDemo;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzMain {
    public static void main(String[] args) throws SchedulerException {
        //1.创建Job对象: 你要做什么事
        JobDetail job = JobBuilder.newJob(QuartzDemo.class).build();

        /**
         * 简单的trigger触发时间:通过Quartz提供一个方法来完成简单的重复调用cron
         * Trigger:按照Cron表达式来给定触发的时间
         *
         */

        //2.创建Trigger对象: 在什么时间做？

        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();

        //3.创建 Scheduler对象:在什么时间做些什么事?
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(job,trigger);

        //启动
        scheduler.start();





    }

}
