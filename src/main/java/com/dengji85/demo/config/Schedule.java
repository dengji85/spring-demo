package com.dengji85.demo.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {

	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("HH:mm:ss");
	@Scheduled(fixedRate=5000)
	public void sc(){
		System.out.println("定时任务执行：现在时间"+FORMAT.format(new Date()));
	}

}
