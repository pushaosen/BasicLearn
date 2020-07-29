package �߳�;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * �Զ����̹߳�����
 * @author lenovo
 *
 */
public class UserThreadFactory implements ThreadFactory {
	
	private String namePrefix;
	private final AtomicInteger nextId = new AtomicInteger();

	// �����߳��������
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
