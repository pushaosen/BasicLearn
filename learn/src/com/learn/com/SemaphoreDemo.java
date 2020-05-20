package com.learn.com;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore是一个计数信号量，常用于限制可以访问某些资源（物理或逻辑的）线程数目。
 * @author wb-pss576863
 *
 */
public class SemaphoreDemo {
	
	// 排队总人数(请求总数)
	private static int clientTotal = 10;
	
	// 可同时受理业务的窗口数量(同时并发执行的线程数)
	private static int threadTotal = 2;

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		// 非公平获得锁，threadTotal就是允许同时运行的线程数目
		final Semaphore semaphore = new Semaphore(threadTotal);
		// 公平获取锁(获得锁的顺序与线程启动顺序有关)
//		final Semaphore semaphore = new Semaphore(threadTotal, true);
		final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for(int i = 0; i < clientTotal; i ++) {
			final int count = i;
			executorService.execute(() -> {
				try {
					// 获取许可
					semaphore.acquire();
					resolve(count);
					// 在释放许可之前，必须先获得许可
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}); 
			countDownLatch.countDown();
		}
		// 一直等待，等待线程执行完成
		countDownLatch.await();
		// 关闭线程池
		executorService.shutdown();
	}
	
	private static void resolve(int i) throws InterruptedException {
		System.out.println("服务号" + i + ",受理业务中。。。");
		Thread.sleep(2000);
	}
}
