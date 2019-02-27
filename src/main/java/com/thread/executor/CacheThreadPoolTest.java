package com.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 */
public class CacheThreadPoolTest {

	private static ExecutorService service = Executors.newCachedThreadPool();
	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {
			service.execute(new ThreadTest(i));
		}
	}
}
