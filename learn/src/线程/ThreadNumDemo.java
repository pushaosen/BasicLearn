package �߳�;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * java�����������ٻ����������̣߳�   ���̡߳����������߳�
 * 5-Attach Listener
   4-Signal Dispatcher //�ַ������͸�JVM�źŵ��߳�
   3-Finalizer //���ö����finalize�������̣߳������������յ��߳�
   2-Reference Handler //���reference���߳�
   1-main //���߳�
 * @author wb-pss576863
 *
 */
public class ThreadNumDemo {
	public static void main(String[] args) {
        ThreadMXBean threadMXBean =ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos=threadMXBean.dumpAllThreads(false,false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadId()+"-"+threadInfo.getThreadName());
        }
    }
}
