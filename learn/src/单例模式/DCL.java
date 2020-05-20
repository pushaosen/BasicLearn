package 单例模式;

/**
 *  性能比较好
	懒加载
	线程的安全性
	问题：因为指令重排一起空指针异常
 * @author wb-pss576863
 *
 */
public class DCL {
	
	private DCL() {
	}
	
	private static DCL instance = null;

	public static DCL getInstance() {
		if(null == instance) {
			synchronized (DCL.class) {
				if(null == instance) {
					instance = new DCL();
				}
			}
		}
		return instance;
	}
}
