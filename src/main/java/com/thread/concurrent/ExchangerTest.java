package com.thread.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 交换者 EXCHANGER.exchange(A)告诉另一线程，该线程录入的值为A，返回另一线程录入的值
 */
public class ExchangerTest {

	private static final Exchanger<String> EXCHANGER = new Exchanger<String>();

	private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

	public static void main(String[] args) {
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					// A录入银行流水数据
					String A = "银行流水A";
					Thread.sleep(5000);
					String B = EXCHANGER.exchange(A);
					System.out.println("A和B数据是否一致（A）：" + A.equals(B) + "，A录入的是：" + A + "，B录入是：" + B);
				} catch (InterruptedException e) {
				}
			}
		});
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					// B录入银行流水数据
					String B = "银行流水B";
					// String A = EXCHANGER.exchange("B");

					String A = "";
					try {
						A = EXCHANGER.exchange("B", 3, TimeUnit.SECONDS);
					} catch (TimeoutException e) {
						System.out.println("另一线程没有录入值");
						e.printStackTrace();
					}

					System.out.println("A和B数据是否一致（B）：" + A.equals(B) + "，A录入的是：" + A + "，B录入是：" + B);
				} catch (InterruptedException e) {
				}
			}
		});
		threadPool.shutdown();
	}

}
