package com.learn.com.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier�ͻ��˵�ʹ��
 * @author wb-pss576863
 *
 */
public class Client {

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new TourGuideTask());
        Executor executor = Executors.newFixedThreadPool(3);
        //�Ǹ�����ƣ���������
        executor.execute(new TravelTask(cyclicBarrier,"����",5));
        executor.execute(new TravelTask(cyclicBarrier,"����",3));
        executor.execute(new TravelTask(cyclicBarrier,"���",1));
	}
	
	/**
	 * CyclicBarrier�ĵײ�ԭ��:
	 * 1��CyclicBarrier����concurrent�������µ�һ�����ࡣ
	 * 2���̼߳�ͬ�������ƺ�ʹ�õ���ReentrantLock������������
	 * 3���̼߳�ͨ��ʹ�õ���Condition��Condition��Object����������(wait��notify��notifyAll)�ֽ��
	 * 	 ��Ȼ��ͬ�Ķ����Ա�ͨ������Щ����������Lockʵ�����ʹ��
	 */
}
