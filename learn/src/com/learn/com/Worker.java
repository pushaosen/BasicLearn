package com.learn.com;

public class Worker extends Thread {

	private String name;
	private long time;
	
	public Worker(String name, long time) {
		this.name = name;
		this.time = time;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(name + "开始工作");
			Thread.sleep(time);
			System.out.println(name + "工作完成，耗时：" + time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
