package com.example.demo.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

//定時器執行方法類
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

		System.out.println("定時器任務執行" + new Date(System.currentTimeMillis()));
    	JobDataMap map = jobExecutionContext.getMergedJobDataMap();
	    System.out.println("引數值 "+map.get("uname"));
    }
}