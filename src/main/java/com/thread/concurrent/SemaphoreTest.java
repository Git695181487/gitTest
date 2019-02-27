package com.thread.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore（信号量）是用来控制同时访问特定资源的线程数量，它通过协调各个线程，以保证合理的使用公共资源。
 * 超过指定的数量，后面的线程只能等前面线程执行完，释放许可证才可以执行
 */
public class SemaphoreTest {

	private final static int THREAD_COUNT = 10;
	private static ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(THREAD_COUNT);

	private static Semaphore semaphore = new Semaphore(20);

	public static void main(String[] args) {

		for (int i = 0; i < THREAD_COUNT; i++) {
			final int a = i;
			newFixedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						// 获取许可证
						semaphore.acquire();
						System.out.println("执行第" + a + "个线程");
						System.out.println("当前还可以执行的线程数：" + semaphore.availablePermits());
						System.out.println("正在等待的线程数：" + semaphore.getQueueLength());
						Thread.sleep(2000);
						// 释放许可证
						semaphore.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}

	}
}
