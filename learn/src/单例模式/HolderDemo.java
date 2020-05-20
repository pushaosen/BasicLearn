package 单例模式;

/**
 * 声明类的时候，成员变量中不声明实例变量，而放到内部静态类中
 * @author wb-pss576863
 *
 */
public class HolderDemo {
	
	private HolderDemo() {}
	
	private static class Holder{
		private static HolderDemo instance = new HolderDemo();
	}
	
	// 懒加载
	@SuppressWarnings("unused")
	private static HolderDemo getInstance() {
		return Holder.instance;
	}
	

}
