package com.learn.com;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore��һ�������ź��������������ƿ��Է���ĳЩ��Դ��������߼��ģ��߳���Ŀ��
 * @author wb-pss576863
 *
 */
public class SemaphoreDemo {
	
	// �Ŷ�������(��������)
	private static int clientTotal = 10;
	
	// ��ͬʱ����ҵ��Ĵ�������(ͬʱ����ִ�е��߳���)
	private static int threadTotal = 2;

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		// �ǹ�ƽ�������threadTotal��������ͬʱ���е��߳���Ŀ
		final Semaphore semaphore = new Semaphore(threadTotal);
		// ��ƽ��ȡ��(�������˳�����߳�����˳���й�)
//		final Semaphore semaphore = new Semaphore(threadTotal, true);
		final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for(int i = 0; i < clientTotal; i ++) {
			final int count = i;
			executorService.execute(() -> {
				try {
					// ��ȡ���
					semaphore.acquire();
					resolve(count);
					// ���ͷ����֮ǰ�������Ȼ�����
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}); 
			countDownLatch.countDown();
		}
		// һֱ�ȴ����ȴ��߳�ִ�����
		countDownLatch.await();
		// �ر��̳߳�
		executorService.shutdown();
	}
	
	private static void resolve(int i) throws InterruptedException {
		System.out.println("�����" + i + ",����ҵ���С�����");
		Thread.sleep(2000);
	}
}
