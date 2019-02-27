package com.thread.executor;

public class ThreadTest implements Runnable {
	private int a;
	public ThreadTest(int a) {
		super();
		this.a = a;
	}

	@Override
	public void run() {
		System.out.println("开始执行线程" + a);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("线程" + a + "执行结束...");
	}

}