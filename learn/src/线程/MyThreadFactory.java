package �߳�;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * �Զ����̳߳ص��̴߳���������
 * @author wb-pss576863
 *
 */
public class MyThreadFactory implements ThreadFactory {
	
//	private static final Logger logger = (Logger) LoggerFactory
//            .getLogger(MyThreadFactory.class);

	 /**
     * ������
     */
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    /**
     * �߳�����
     */
    private String               name;

    /**
     * ���������̹߳���
     * @param name ����
     */
    public MyThreadFactory(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, name + "-Thread-" + atomicInteger.getAndIncrement());
//        LoggerUtil.info(logger, String.format("Create ChangeMetaSaveThread %d with name %s on %s\n",
//                thread.getId(), thread.getName(), new Date()));
        return thread;
    }

}
