package �߳�;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * �Զ����̳߳صĵľܾ�����
 * @author lenovo
 *
 */
public class UserRejectHandler implements RejectedExecutionHandler {

	/**
	 * �Զ����̳߳صľܾ�����ʵ�����ʵ�ַ���(�������д����ľܾ�ҵ���߼�)
	 */
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("task rejected. " + executor.toString());
	}

}
