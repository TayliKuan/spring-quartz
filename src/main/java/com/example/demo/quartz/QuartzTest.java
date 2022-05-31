package com.example.demo.quartz;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

//啟動定時器
public class QuartzTest {
	//僅main方法 測試
	public static void main(String[] args) throws Exception {
		// 1.建立Scheduler的工廠
		SchedulerFactory sf = new StdSchedulerFactory();

		// 2.從工廠中獲取排程器例項
		Scheduler scheduler = sf.getScheduler();

		// 3.建立JobDetail(作業資訊)
		JobDetail jb = JobBuilder.newJob(MyJob.class).withDescription("this is a test job") // job的描述
				.withIdentity("testJob", "testGroup") // job 的name和group
				.build();

		// 向任務傳遞資料
		JobDataMap jobDataMap = jb.getJobDataMap();
		jobDataMap.put("uname", "TAYLI");

		// 任務執行的時間，SimpleSchedle型別觸發器有效
		long time = System.currentTimeMillis() + 3 * 1000L; // 3秒後啟動任務
		Date statTime = new Date(time);

		// 4.建立Trigger
		// 使用SimpleScheduleBuilder或者CronScheduleBuilder
		Trigger t = TriggerBuilder.newTrigger().withDescription("").withIdentity("ramTrigger", "ramTriggerGroup")
				.startAt(statTime) // 預設當前時間啟動
				// 普通計時器
				// .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).withRepeatCount(3))//間隔3秒，重複3次
				// 表示式計時器
				.withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?")) // 3秒執行一次
				.build();

		// 5.註冊任務和定時器
		scheduler.scheduleJob(jb, t);

		// 6.啟動 排程器
		scheduler.start();
	}
}
