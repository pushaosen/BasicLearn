package com.learn.com.sort;

import java.util.concurrent.Callable;

public class Rests {
	
	private Rests() {}
	
	private static DefaultHandler defaultHandler = new DefaultHandler();
	
	/**
	 * ִ�з�����ò��жϷ���״̬
	 * @param callable   // ��ʾһ������
	 * @return
	 */
	public static <T> T exc(Callable<T> callable) {
		return exc(callable, defaultHandler);
	}
	
	public static <T> T exc(Callable<T> callable, ResultHandler resultHandler) {
		T result = sendReq(callable);
		return resultHandler.handle(result);
	}

	/**
	 * ��ȡ���÷����url
	 */
	public static String toUrl(String serviceName, String path) {
		return "http://" + serviceName + path;
	}
	
	public static class DefaultHandler implements ResultHandler{

		@Override
		public <T> T handle(T result) {
			// ʹ�÷����ȡ�������ֵ
			return null;
		}
		
	}
	
	public interface ResultHandler{
		<T> T handle(T result);
	}
	
	/**
	 * �Է��ؽ�����з�װ
	 * @param callable
	 * @return
	 */
	public static <T> T sendReq(Callable<T> callable) {
		T result = null;
		try {
			result = callable.call();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("ִ�н��Ϊ��" + result);
		}
		return result;
	}
}
