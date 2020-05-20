package com.learn.com.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier客户端的使用
 * @author wb-pss576863
 *
 */
public class Client {

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new TourGuideTask());
        Executor executor = Executors.newFixedThreadPool(3);
        //登哥最大牌，到的最晚
        executor.execute(new TravelTask(cyclicBarrier,"哈登",5));
        executor.execute(new TravelTask(cyclicBarrier,"保罗",3));
        executor.execute(new TravelTask(cyclicBarrier,"戈登",1));
	}
	
	/**
	 * CyclicBarrier的底层原理:
	 * 1、CyclicBarrier类是concurrent并发包下的一工具类。
	 * 2、线程间同步阻塞似乎使用的是ReentrantLock，可重入锁。
	 * 3、线程间通信使用的是Condition，Condition将Object监视器方法(wait、notify和notifyAll)分解成
	 * 	 截然不同的对象，以便通过将这些对象与任意Lock实现组合使用
	 */
}
