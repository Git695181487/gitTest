package com.thread.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定长线程池，支持定时及周期性任务执行。
 */
public class ScheduleThreadPoolTest {
	private static ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
	public static void main(String[] args) {
		for (int i = 0; i <= 0; i++) {
//			service.execute(new ThreadTest(i));
			// service.schedule(new ThreadTest(i), 3, TimeUnit.SECONDS);
			// 表示延迟1秒后每3秒执行一次，当前线程结束3秒后
			service.scheduleWithFixedDelay(new ThreadTest(i), 1, 3, TimeUnit.SECONDS);
			// 表示延迟1秒后每3秒执行一次，当前线程开始3秒后
			service.scheduleAtFixedRate(new ThreadTest(i), 1, 3, TimeUnit.SECONDS);
		}
	}
}
