package com.thread.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏 CyclicBarrier默认的构造方法是CyclicBarrier（int parties），其参数表示屏障拦截的线程数
 * 量，每个线程调用await方法告诉CyclicBarrier我已经到达了屏障，然后当前线程被阻塞;
 * 直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续运行。 await(long timeout,TimeUnit
 * unit)等待timeout时间,reset();--重置
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {
		// barrierTest1();
		barrierTest2();

	}
	private static void barrierTest1() {
		final CyclicBarrier barrier = new CyclicBarrier(3);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					barrier.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(111);

			}
		}).start();
		try {
			barrier.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(222);
	}

	private static void barrierTest2() {
		final CyclicBarrier barrier = new CyclicBarrier(3, new A());
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					barrier.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(111);

			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					barrier.await();
					// barrier.await(2, TimeUnit.SECONDS);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("------------");

			}
		}).start();
		try {
			barrier.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(222);
	}

	static class A implements Runnable {
		@Override
		public void run() {
			System.out.println(333);
		}
	}

}
