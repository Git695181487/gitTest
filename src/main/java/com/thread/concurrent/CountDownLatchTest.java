package com.thread.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 测试计数器
 */
public class CountDownLatchTest {

	public static void main(String[] args) throws Exception {
		// joinTest();
		countDownLatchTest();
	}

	/**
	 * join用于让当前执行线程等待join线程执行结束。其实现原理是不停检查, join线程是否存活，如果join线程存活则让当前线程永远等待。
	 */
	private static void joinTest() throws InterruptedException {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("thread1执行完成");
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("thread2执行完成");
			}
		});
		thread1.start();
		thread2.start();
		// join用于让当前执行线程等待join线程执行结束。其实现原理是不停检查,
		// join线程是否存活，如果join线程存活则让当前线程永远等待。
		thread1.join();
		thread2.join();
		System.out.println("主线程执行完成");
	}

	private static void countDownLatchTest() throws InterruptedException {
		final CountDownLatch latch = new CountDownLatch(2);
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("1111111111111111111");
				latch.countDown();
				// latch.countDown();
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("22222222222222222222");
				latch.countDown();
			}
		}).start();
		// CountDownLatch的await方法会阻碍当前线程，直到构造参数的N变为0
		latch.await(2, TimeUnit.SECONDS);
		System.out.println("333333333333333");
		latch.await();
		System.out.println("444444444444444444444");
	}

}
