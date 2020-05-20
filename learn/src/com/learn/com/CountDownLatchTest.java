package com.learn.com;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch是一个同步辅助类，它允许一个或多个线程一直等待直到其他线程执行完毕才开始执行。
 * 用给定的计数初始化CountDownLatch，其含义是要被等待执行完的线程个数
 * 每次调用CountDown()，计数减1
 * 主程序执行到await()函数会阻塞等待线程的执行，直到计数为0
 * 
 * 实现原理：计数器通过使用锁(共享锁、排它锁)实现
 * @author wb-pss576863
 *
 */

// 场景：模拟10人赛跑。10人跑完后才喊"Game Over"
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
