package com.learn.com;

import java.util.concurrent.CountDownLatch;

public class WorkerCount extends Thread {

	private String name;
	private long time;
	private CountDownLatch countDownLatch;
	
	// 全参构造器
	public WorkerCount(String name, long time, CountDownLatch countDownLatch) {
		super();
		this.name = name;
		this.time = time;
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(name + "开始工作");
			Thread.sleep(time);
			System.out.println(name + "工作完成，耗时：" + time);
			countDownLatch.countDown();
			System.out.println("countDownLatch.getCount():" + countDownLatch.getCount());
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
