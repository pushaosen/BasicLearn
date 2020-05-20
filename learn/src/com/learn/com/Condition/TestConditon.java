package com.learn.com.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author wb-pss576863
 *
 *	ʵ�ֵȴ�/֪ͨģʽ��
 *	Object���е�wait()�����൱��Condition����await()������
 *  Object���е�wait(long time)�����൱��Condition����await(long time,TimeUnit unit)������
 *  Object���е�notify()�����൱��Condition����signal()������
 *  Object���е�notifyAll()�����൱��Condition����signalAll()������
 *  
 *  ����Object��wait()��notify()/notifyAll()������Ͽ���ʵ�ֵȴ�/֪ͨģʽ��������ʹ��notify/notifyAll
 *  ��������֪ͨʱ����֪ͨ���߳�ȴ����JVM���ѡ��ġ�Ϊ�˰�����һ������Java��1.5������ReentrantLock��Condition����
 *  ʹ�����ﵽ��ѡ���ԵĽ����߳�֪ͨ���ڵ����߳��ϸ�����
 */
public class TestConditon {

	public static void main(String[] args) throws InterruptedException {
		final ReentrantLock reentrantLock = new ReentrantLock();
		final Condition condition = reentrantLock.newCondition();
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				reentrantLock.lock();
				System.out.println("��Ҫ�ȴ�һ�����źţ�" + this);
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("�õ�һ���źţ���" + this);
				reentrantLock.unlock();
			}
		}, "waitThread");
		
		thread.start();
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				reentrantLock.lock();
				System.out.println("���õ�����");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				condition.signalAll();
				System.out.println("�ҷ���һ���źţ���");
				reentrantLock.unlock();
			}
		}, "signalThread");
		
		thread1.start();
	}
	
	/**
	 * Condition��һ�����̼߳�Э��ͨ�ŵĹ����࣬ʹ��ĳ��������ĳЩ�߳�һ��ȴ�ĳ������(Condition)��ֻ��
	 * �������߱�(Signal����signalAll������������)ʱ����Щ�ȴ��̲߳Żᱻ���ѣ��Ӷ�������������
	 * 
	 * Condition�ڲ�ά����һ�����У��ö��е�������ά��һ���ȴ�signal�źŵĶ��У��������е������ǲ���ͬ��
	 * ��ʵ�ϣ�ÿ���߳�Ҳ������ͬʱ�����������������е�һ���������������ģ�
	 * 1���߳�1����reentranLock.lockʱ���̱߳����뵽AQS�ĵȴ������С�
	 * 2���߳�1����await����������ʱ�����̴߳�AQS���Ƴ�����Ӧ�����������ͷš�
	 * 3���������ϼ��뵽Condition�ĵȴ������У���ζ�Ÿ��߳���ҪSignal�źš�
	 * 4���߳�2����Ϊ�߳�1�ͷ����Ĺ�ϵ�������ѣ����жϿ��Ի�ȡ���������߳�2��ȡ���������뵽AQS�����С�
	 * 5���߳�2����signal���������ʱ��Condition�ĵȴ�������ֻ���߳�1һ���ڵ㣬��������ȡ����������
	 * 	�뵽AQS�ĵȴ������С�ע�⣬���ʱ���߳�1��û�б����ѡ�
	 * 6��signal����ִ����ϣ��߳�2����reentrantLock.unLock()�������ͷ��������ʱ����ΪAQS��ֻ���߳�1��
	 *   ���ǣ�AQS�ͷ����󰴴�ͷ��β��˳�����߳�ʱ���߳�1�����ѣ������߳�1�ָ�ִ�С�
	 * 7��ֱ���ͷ���������ִ����ϡ�
	 */
}
