package com.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 */
public class SingleThreadExecutorTest {

	private static ExecutorService service = Executors.newSingleThreadExecutor();
	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {
			service.execute(new ThreadTest(i));
		}
	}
}
