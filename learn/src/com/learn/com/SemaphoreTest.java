package com.learn.com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 线程中信号量Semaphore的使用
 * @author wb-pss576863
 * 
 * Semaphore可以控制某个共享资源可被同时访问的次数，即可以控制维护当前访问某一共享资源的线程个数，
 * 并提供了同步机制，.例如控制某一个文件允许的并发访问的数量
 * 
 * 例如网吧里有100台机器,那么最多只能提供100个人同时上网,当来了第101个客人的时候,就需要等着,
 * 一旦有一个人人下机,就可以立马得到了个空机位补上去.这个就是信号量的概念.
 */
public class SemaphoreTest {

	/**
	 * 创建10个线程，最多只能有3个线程同时执行功能代码
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建一个可调整大小的缓冲池线程
		ExecutorService service = Executors.newCachedThreadPool();
		// 只能有三个线程能同时访问
		final Semaphore semaphore = new Semaphore(3);
		// 循环创建一个线程
		for(int i = 0; i < 10; i ++) {
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					try {
						// 获取一个许可，得到许可就可以往下执行，得不到就组赛，等待该信号量空出可用的许可
						semaphore.acquire();
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
					// 功能代码
					System.out.println("线程" + Thread.currentThread().getName() + 
							"进入，当前已有" + (3 - semaphore.availablePermits()) + "个并发");
					
					try {
						Thread.sleep((long) (Math.random() * 10000));
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println("线程" + Thread.currentThread().getName() + "即将离开");
					semaphore.release();
					// 下面代码有时候执行不准确，因为没有和上面的代码合成原子单元
					System.out.println("线程" + Thread.currentThread().getName() + "已离开，当前已有" 
							+ (3-semaphore.availablePermits()) + "个并发");
				}
			};
			service.execute(runnable);
		}
	}
	
	//如果,把该类的信号量初始化为 1，即在构造函数中传入的参数为1,使得它在使用时最多只有一个可用的许可，那么就可用作一个相互排斥的锁,类比Lock锁.
}
