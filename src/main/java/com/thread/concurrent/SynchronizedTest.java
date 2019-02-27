package com.thread.concurrent;

/**
 * synchronized的使用
 */
public class SynchronizedTest {

	public static void main(String[] args) {
		// 开启5个线程执行相同的业务
		for (int i = 0; i < 1; i++) {
			new Thread(new MyThread(5000)).start();
			new Thread(new MyThread(0)).start();
		}
	}

	public void print(long time) {
		System.out.println(this);
		// 锁住相同对象调用的方法
		synchronized (SynchronizedTest.class) {
			for (int i = 0; i < 999; i++) {
				System.out.println(Thread.currentThread().getName() + "I=" + i);
			}
		}
	}

	public void print1(String str) {
		System.out.println(this);
		// 锁住相同对象调用的方法
		synchronized (SynchronizedTest.class) {
			for (int i = 0; i < 999; i++) {
				System.out.println(Thread.currentThread().getName() + "I=" + i);
			}
		}
	}


}

/**
 * 线程处理类
 */
class MyThread implements Runnable {

	private long str;
	private SynchronizedTest test = ObjUtils.test;
	// private SynchronizedTest test = new SynchronizedTest();

	public MyThread(long str) {
		super();
		this.str = str;
	}

	@Override
	public void run() {
		test.print(str);
	}

}

/**
 * 线程处理类
 */
class MyThread2 implements Runnable {

	private String str;
	private SynchronizedTest test = ObjUtils.test;
	// private SynchronizedTest test = new SynchronizedTest();

	public MyThread2(String str) {
		this.str = str;
	}

	@Override
	public void run() {
		test.print1("1");
	}

}

/**
 * 对象管理类
 */
class ObjUtils {
	public static SynchronizedTest test = new SynchronizedTest();
}