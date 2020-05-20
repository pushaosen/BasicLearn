package com.learn.com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * �߳����ź���Semaphore��ʹ��
 * @author wb-pss576863
 * 
 * Semaphore���Կ���ĳ��������Դ�ɱ�ͬʱ���ʵĴ����������Կ���ά����ǰ����ĳһ������Դ���̸߳�����
 * ���ṩ��ͬ�����ƣ�.�������ĳһ���ļ�����Ĳ������ʵ�����
 * 
 * ������������100̨����,��ô���ֻ���ṩ100����ͬʱ����,�����˵�101�����˵�ʱ��,����Ҫ����,
 * һ����һ�������»�,�Ϳ�������õ��˸��ջ�λ����ȥ.��������ź����ĸ���.
 */
public class SemaphoreTest {

	/**
	 * ����10���̣߳����ֻ����3���߳�ͬʱִ�й��ܴ���
	 * @param args
	 */
	public static void main(String[] args) {
		// ����һ���ɵ�����С�Ļ�����߳�
		ExecutorService service = Executors.newCachedThreadPool();
		// ֻ���������߳���ͬʱ����
		final Semaphore semaphore = new Semaphore(3);
		// ѭ������һ���߳�
		for(int i = 0; i < 10; i ++) {
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					try {
						// ��ȡһ����ɣ��õ���ɾͿ�������ִ�У��ò������������ȴ����ź����ճ����õ����
						semaphore.acquire();
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
					// ���ܴ���
					System.out.println("�߳�" + Thread.currentThread().getName() + 
							"���룬��ǰ����" + (3 - semaphore.availablePermits()) + "������");
					
					try {
						Thread.sleep((long) (Math.random() * 10000));
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println("�߳�" + Thread.currentThread().getName() + "�����뿪");
					semaphore.release();
					// ���������ʱ��ִ�в�׼ȷ����Ϊû�к�����Ĵ���ϳ�ԭ�ӵ�Ԫ
					System.out.println("�߳�" + Thread.currentThread().getName() + "���뿪����ǰ����" 
							+ (3-semaphore.availablePermits()) + "������");
				}
			};
			service.execute(runnable);
		}
	}
	
	//���,�Ѹ�����ź�����ʼ��Ϊ 1�����ڹ��캯���д���Ĳ���Ϊ1,ʹ������ʹ��ʱ���ֻ��һ�����õ���ɣ���ô�Ϳ�����һ���໥�ų����,���Lock��.
}
