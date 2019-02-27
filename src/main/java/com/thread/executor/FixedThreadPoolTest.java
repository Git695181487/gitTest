package com.thread.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 */
public class FixedThreadPoolTest {
	
	private static ExecutorService service = Executors.newFixedThreadPool(10);
	public static void main(String[] args) {
//		for (int i = 1; i <= 10; i++) {
//			service.execute(new ThreadTest(i));
//		}
		
		Future<String> rsult = service.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(3000);
				return "aaaaa";
			}
		});
		System.out.println("已经开始线程执行");
		try {
			String retStr = rsult.get();
			System.out.println(retStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("******************************");

	}

}

