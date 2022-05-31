package com.example.demo.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.service.SampleJobService;
import com.example.demo.utils.ExceptionUtility;

@Component
public class TestJob extends QuartzJob {
//	 @Autowired
//	 private SampleJobService sampleJobService; 這裡直接Autowired 拿不到
	//這裡使用靜態，讓 service 屬於類
	private static SampleJobService sampleJobService;

	// 注入的時候，給類的 service 注入
	@Autowired
	public void setSampleJobService(SampleJobService sampleJobService) {
		//step 2
		TestJob.sampleJobService = sampleJobService;
	}

	protected void handler(JobExecutionContext context) throws JobExecutionException {
		try {
			// step 10   15
			sampleJobService.executeSampleJob();
		} catch (Exception e) {
			System.out.println("處理失敗 - {}" + ExceptionUtility.getStackTrace(e));
		}

	}
}
