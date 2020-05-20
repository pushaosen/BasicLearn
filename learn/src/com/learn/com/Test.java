package com.learn.com;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * 如果,把该类的信号量初始化为 1，即在构造函数中传入的参数为1,使得它在使用时最多只有一个可用的许可，那么就可用作一个相互排斥的锁,类比Lock锁.
 * @author wb-pss576863
 *
 */

/**
 * 现成程序中的Test类中的代码在不断地产生数据，然后交给TestDo.doSome()方法去处理，
 * 就好像生产者在不断地产生数据，
 * 消费者在不断消费数据。请将程序改造成有10个线程来消费生成者产生的数据，
 * 这些消费者都调用TestDo.doSome()方法去进行处理，故每个消费者都需要一秒才能处理完，
 * 程序应保证这些消费者线程依次有序地消费数据，只有上一个消费者消费完后，下一个消费者才能消费数据，
 * 下一个消费者是谁都可以，但要保证这些消费者线程拿到的数据是有顺序的.
 * @author Administrator
 */
public class Test {

	public static void main(String[] args) {
		final BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
		//final Lock lock=new ReentrantLock();
		// 在这里Semaphore的个数为1的话就相当于ReentrantLock，和他的作用相似
		final Semaphore sp=new Semaphore(1);
		for(int i = 0; i < 10; i ++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						//lock.lock();
						sp.acquire();
						String input = queue.take();
						String output = TestDo.doSome(input);
						System.out.println(Thread.currentThread().getName()+ ":" + output);
						//lock.unlock();
	                    sp.release();
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		System.out.println("begin:"+(System.currentTimeMillis()/1000));
		for(int i = 0; i < 10; i ++) {  // 这行不能改动
			String input = i + "";   // 这行不能改动
			try {
				queue.put(input);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


// 不能改动此TestDo类
class TestDo{
	public static String doSome(String input) {
		try {
			// 默认该功能执行1秒钟
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		String output = input + ":"+ (System.currentTimeMillis() / 1000);
		return output;
	}
}
