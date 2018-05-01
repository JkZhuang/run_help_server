package com.zjk.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SportsTask {

    @Scheduled(cron = "*/5 * * * * *")
    public void generateSportsSuggestion() {
        System.out.println("==============it is first task!时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
