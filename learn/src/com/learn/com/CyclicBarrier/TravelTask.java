package com.learn.com.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * ͬ��������դ����ʹ��(ʵ��ͬ��)
 * @author wb-pss576863
 * �����߳�
 */
public class TravelTask implements Runnable {
	
	private CyclicBarrier cyclicBarrier;
	private String name;
	private int arriveTime;  // �ϵ���ʱ��
	
	public TravelTask(CyclicBarrier cyclicBarrier,
			String name, int arriveTime) {
		this.cyclicBarrier = cyclicBarrier;
		this.name = name;
		this.arriveTime = arriveTime;
	}

	@Override
	public void run() {
		try {
			// ģ��ﵽ��Ҫ����ʱ��
			Thread.sleep(arriveTime * 1000);
			System.out.println(name + "���Ｏ�ϵ�");
			cyclicBarrier.await();
			System.out.println(name + "��ʼ������...");
		}catch (InterruptedException e) {
			e.printStackTrace();
		}catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		
	}

}
