package com.example.demo.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener implements JobListener {

	private static final String SYSTEM_DATETIME_PATTERN = "yyyyMMddHHmmss";


	@Override
	public String getName() {
		return "TestListener";
	}

	//step 6  8   13 again  18 again...
	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		String jobName = context.getJobDetail().getKey().getName();
		String jobStartTime = new SimpleDateFormat(SYSTEM_DATETIME_PATTERN).format(context.getFireTime());
		System.out.println("執行 前==========start=============");
		System.out.println("jobName= " + jobName);
		System.out.println("jobStartTime= " + jobStartTime);
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
	}

	//step 12 end  17 end
	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		String jobName = context.getJobDetail().getKey().getName();
		String jobEndTime = new SimpleDateFormat(SYSTEM_DATETIME_PATTERN)
				.format((new Date(context.getFireTime().getTime() + context.getJobRunTime())));
		System.out.println("執行 後===========end============");
		System.out.println("jobName= " + jobName);
		System.out.println("jobEndTime= " + jobEndTime);
	}
}
