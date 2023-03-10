package com.example.onboarding.poc2.job;


import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.example.onboarding.poc2.services.IBooksService;

public class JobInsertDataService extends QuartzJobBean {
	private static final Logger logger = LoggerFactory.getLogger(JobInsertDataService.class);

	@Autowired
	IBooksService bookService;

	@Override
	protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		try {

			logger.info("Executing Job with key {}", jobExecutionContext.getJobDetail().getKey());

			JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
			String title = jobDataMap.getString("title");
			String description = jobDataMap.getString("description");
			String author = jobDataMap.getString("author");

//			bookService.insert(title, description, author);
		} catch (Exception e) {
			logger.error("Failed to send insert.", e);
			throw e;
		}
	}

}
