package 线程;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 自定义线程工厂类
 * @author lenovo
 *
 */
public class UserThreadFactory implements ThreadFactory {
	
	private String namePrefix;
	private final AtomicInteger nextId = new AtomicInteger();

	// 定义线程组的名称
	UserThreadFactory(String name){
		namePrefix = "UserThreadFactory's" + name + "-worker-";
	}
	
	@Override
	public Thread newThread(Runnable task) {
		String name = namePrefix + nextId.getAndIncrement();
		Thread thread = new Thread(null, task, name, 0);
		System.out.println(thread.getName());
		return thread;
	}

}

class Task implements Runnable {
	private final AtomicLong count = new AtomicLong(0L);
	@Override
	public void run() {
		System.out.println("running_" + count.getAndIncrement());
	}
}
