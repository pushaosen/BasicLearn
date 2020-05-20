package 线程;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义线程池的线程创建工厂类
 * @author wb-pss576863
 *
 */
public class MyThreadFactory implements ThreadFactory {
	
//	private static final Logger logger = (Logger) LoggerFactory
//            .getLogger(MyThreadFactory.class);

	 /**
     * 计数类
     */
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    /**
     * 线程名称
     */
    private String               name;

    /**
     * 生产攻击线程工场
     * @param name 名称
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
