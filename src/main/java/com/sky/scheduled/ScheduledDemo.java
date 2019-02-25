package com.sky.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Scheduled 定时任务
 * 是spring3.0以后自带的一个定时任务器
 * 启动主任务就会触发执行
 */
@Component
public class ScheduledDemo {

    /*@Scheduled(cron = "0/2 * * * * ?")
    public void scheduledMethod(){
        System.out.println("定时器被触发" + new Date());

    }*/

}
