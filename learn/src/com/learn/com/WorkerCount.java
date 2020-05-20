package com.learn.com;

import java.util.concurrent.CountDownLatch;

public class WorkerCount extends Thread {

	private String name;
	private long time;
	private CountDownLatch countDownLatch;
	
	// ȫ�ι�����
	public WorkerCount(String name, long time, CountDownLatch countDownLatch) {
		super();
		this.name = name;
		this.time = time;
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(name + "��ʼ����");
			Thread.sleep(time);
			System.out.println(name + "������ɣ���ʱ��" + time);
			countDownLatch.countDown();
			System.out.println("countDownLatch.getCount():" + countDownLatch.getCount());
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
