package com.learn.com.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author wb-pss576863
 *
 *	实现等待/通知模式：
 *	Object类中的wait()方法相当于Condition类中await()方法。
 *  Object类中的wait(long time)方法相当于Condition类中await(long time,TimeUnit unit)方法。
 *  Object类中的notify()方法相当于Condition类中signal()方法。
 *  Object类中的notifyAll()方法相当于Condition类中signalAll()方法。
 *  
 *  但是Object的wait()和notify()/notifyAll()方法结合可以实现等待/通知模式。但是在使用notify/notifyAll
 *  方法进行通知时，被通知的线程却是由JVM随机选择的。为了摆脱这一窘境，Java在1.5引入了ReentrantLock和Condition类结合
 *  使用来达到有选择性的进行线程通知，在调度线程上更加灵活。
 */
public class TestConditon {

	public static void main(String[] args) throws InterruptedException {
		final ReentrantLock reentrantLock = new ReentrantLock();
		final Condition condition = reentrantLock.newCondition();
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				reentrantLock.lock();
				System.out.println("我要等待一个新信号：" + this);
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("拿到一个信号！！" + this);
				reentrantLock.unlock();
			}
		}, "waitThread");
		
		thread.start();
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				reentrantLock.lock();
				System.out.println("我拿到锁了");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				condition.signalAll();
				System.out.println("我发了一个信号！！");
				reentrantLock.unlock();
			}
		}, "signalThread");
		
		thread1.start();
	}
	
	/**
	 * Condition是一个多线程间协调通信的工具类，使得某个，或者某些线程一起等待某个条件(Condition)，只有
	 * 该条件具备(Signal或者signalAll方法被带调用)时，这些等待线程才会被唤醒，从而重新争夺锁。
	 * 
	 * Condition内部维护了一个队列，该队列的作用是维护一个等待signal信号的队列，两个队列的作用是不相同，
	 * 事实上，每个线程也仅仅会同时存在以上两个队列中的一个，流程是这样的：
	 * 1、线程1调用reentranLock.lock时，线程被加入到AQS的等待队列中。
	 * 2、线程1调用await方法被调用时，该线程从AQS中移除，对应操作是锁的释放。
	 * 3、接着马上加入到Condition的等待队列中，意味着该线程需要Signal信号。
	 * 4、线程2，因为线程1释放锁的关系，被唤醒，并判断可以获取锁，于是线程2获取锁，并加入到AQS队列中。
	 * 5、线程2调用signal方法，这个时候Condition的等待队列中只有线程1一个节点，于是它被取出来，并加
	 * 	入到AQS的等待队列中。注意，这个时候，线程1并没有被唤醒。
	 * 6、signal方法执行完毕，线程2调用reentrantLock.unLock()方法，释放锁。这个时候因为AQS中只有线程1，
	 *   于是，AQS释放锁后按从头到尾的顺序唤醒线程时，线程1被唤醒，于是线程1恢复执行。
	 * 7、直到释放整个过程执行完毕。
	 */
}
