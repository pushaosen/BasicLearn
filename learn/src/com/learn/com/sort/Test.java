package com.learn.com.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
	
	private static ExecutorService executorService = new ThreadPoolExecutor(2, 200,
	        0L, TimeUnit.MILLISECONDS,
	        new LinkedBlockingQueue<Runnable>(1024), new ThreadPoolExecutor.AbortPolicy());
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int oldCapacity = 11;
		int newCapacity = (oldCapacity << 1) + 1;
		System.out.println(newCapacity);
		
		System.out.println(2 << 4);
		
		System.out.println(1 << 30);
		
		List<String> list = new ArrayList<>(1);
		
		list.add("tom");
		list.add("jay");
		list.stream().forEach(str -> System.out.println(str));
		 @SuppressWarnings("unused")
		ExecutorService   taskExecutor = new ThreadPoolExecutor(2, 4, 0L,
	                TimeUnit.SECONDS, new LinkedBlockingQueue<>(1024));
		Future<String> submit = executorService.submit(() -> {
			// 这里直接调用下载的方法就是啦
			return "";
		});
		submit.get();
		
//		CacheOperationInvoker aopAllianceInvoker = () -> {};
		System.out.println(String.class.getClass());
		
		list.sort((a, b) -> {
			return a.compareTo(b);
		});
		
		list.forEach(str -> System.out.println(str));
		
	}

}
