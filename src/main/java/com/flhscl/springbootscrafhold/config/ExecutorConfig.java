package com.flhscl.springbootscrafhold.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.TaskUtils;

/**
 * @author <a href="http://flcoder.com">cl</a>
 * @version 1.0 & 2017/6/26
 * @since 1.0
 */
@EnableAsync
@EnableScheduling
@Configuration
public class ExecutorConfig {

	private int schedulerPoolSize = 50;

	private int asyncCorePoolSize = 20;

	private int asyncMaxPoolSize = 50;

	@Bean(name = "taskScheduler")
	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(this.schedulerPoolSize);
		threadPoolTaskScheduler.setErrorHandler(TaskUtils.getDefaultErrorHandler(false));
		return threadPoolTaskScheduler;
	}

	@Bean(name = "taskExecutor")
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(this.asyncCorePoolSize);
		threadPoolTaskExecutor.setMaxPoolSize(this.asyncMaxPoolSize);
		threadPoolTaskExecutor.setQueueCapacity(this.asyncMaxPoolSize);
		return threadPoolTaskExecutor;
	}

}