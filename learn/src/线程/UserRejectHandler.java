package 线程;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义线程池的的拒绝策略
 * @author lenovo
 *
 */
public class UserRejectHandler implements RejectedExecutionHandler {

	/**
	 * 自定义线程池的拒绝策略实现类的实现方法(这个里面写具体的拒绝业务逻辑)
	 */
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("task rejected. " + executor.toString());
	}

}
