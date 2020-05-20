package com.learn.com;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch��һ��ͬ�������࣬������һ�������߳�һֱ�ȴ�ֱ�������߳�ִ����ϲſ�ʼִ�С�
 * �ø����ļ�����ʼ��CountDownLatch���京����Ҫ���ȴ�ִ������̸߳���
 * ÿ�ε���CountDown()��������1
 * ������ִ�е�await()�����������ȴ��̵߳�ִ�У�ֱ������Ϊ0
 * 
 * ʵ��ԭ��������ͨ��ʹ����(��������������)ʵ��
 * @author wb-pss576863
 *
 */

// ������ģ��10�����ܡ�10�������ź�"Game Over"
public class CountDownLatchTest {

	private static final int RUNNER_COUNT = 10;
	
	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch begin = new CountDownLatch(1);
		final CountDownLatch end = new CountDownLatch(RUNNER_COUNT);
		final ExecutorService exec = Executors.newFixedThreadPool(10);
		
		for(int i = 0; i < RUNNER_COUNT; i ++) {
			final int NO = i + 1;
			Runnable run = new Runnable() {
				@Override
				public void run() {
					try {
						begin.await();
						Thread.sleep((long)(Math.random() * 10000));
						System.out.println("No." + NO + " arrived");
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						end.countDown();
					}
				}
			};
			exec.submit(run);
		}
		
		System.out.println("Game Start ...");
		begin.countDown();
		end.await();
		System.out.println("Game Over.");
		
		exec.shutdown();
	}
}
