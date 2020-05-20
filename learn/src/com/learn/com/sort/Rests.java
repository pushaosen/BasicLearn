package com.learn.com.sort;

import java.util.concurrent.Callable;

public class Rests {
	
	private Rests() {}
	
	private static DefaultHandler defaultHandler = new DefaultHandler();
	
	/**
	 * 执行服务调用并判断返回状态
	 * @param callable   // 表示一个函数
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
	 * 获取调用服务的url
	 */
	public static String toUrl(String serviceName, String path) {
		return "http://" + serviceName + path;
	}
	
	public static class DefaultHandler implements ResultHandler{

		@Override
		public <T> T handle(T result) {
			// 使用反射获取结果参数值
			return null;
		}
		
	}
	
	public interface ResultHandler{
		<T> T handle(T result);
	}
	
	/**
	 * 对返回结果进行封装
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
			System.out.println("执行结果为：" + result);
		}
		return result;
	}
}
