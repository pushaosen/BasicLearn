package com.learn.com.CyclicBarrier;

/**
 * �����߳�
 * @author wb-pss576863
 *
 */
public class TourGuideTask implements Runnable {

	@Override
	public void run() {
		System.out.println("***���ηַ�����ǩ֤****");
		try {
			// ģ�ⷢ����ǩ֤��Ҫ2��
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
