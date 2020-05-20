package com.learn.com;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * ���,�Ѹ�����ź�����ʼ��Ϊ 1�����ڹ��캯���д���Ĳ���Ϊ1,ʹ������ʹ��ʱ���ֻ��һ�����õ���ɣ���ô�Ϳ�����һ���໥�ų����,���Lock��.
 * @author wb-pss576863
 *
 */

/**
 * �ֳɳ����е�Test���еĴ����ڲ��ϵز������ݣ�Ȼ�󽻸�TestDo.doSome()����ȥ����
 * �ͺ����������ڲ��ϵز������ݣ�
 * �������ڲ����������ݡ��뽫����������10���߳������������߲��������ݣ�
 * ��Щ�����߶�����TestDo.doSome()����ȥ���д�����ÿ�������߶���Ҫһ����ܴ����꣬
 * ����Ӧ��֤��Щ�������߳�����������������ݣ�ֻ����һ�����������������һ�������߲����������ݣ�
 * ��һ����������˭�����ԣ���Ҫ��֤��Щ�������߳��õ�����������˳���.
 * @author Administrator
 */
public class Test {

	public static void main(String[] args) {
		final BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
		//final Lock lock=new ReentrantLock();
		// ������Semaphore�ĸ���Ϊ1�Ļ����൱��ReentrantLock����������������
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
		for(int i = 0; i < 10; i ++) {  // ���в��ܸĶ�
			String input = i + "";   // ���в��ܸĶ�
			try {
				queue.put(input);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


// ���ܸĶ���TestDo��
class TestDo{
	public static String doSome(String input) {
		try {
			// Ĭ�ϸù���ִ��1����
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		String output = input + ":"+ (System.currentTimeMillis() / 1000);
		return output;
	}
}
