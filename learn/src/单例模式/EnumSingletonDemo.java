package 单例模式;

public class EnumSingletonDemo {
	
	private EnumSingletonDemo() {}
	
	// 延迟加载
	private enum EnumHolder{
		INSTANCE;
		private static EnumSingletonDemo instance = new EnumSingletonDemo();
		
//		public EnumSingletonDemo getInstance(){
//            instance=new EnumSingletonDemo();
//            return instance;
//		}
	}
	
	// 懒加载
	@SuppressWarnings("static-access")
	public static EnumSingletonDemo getInstance() {
		return EnumHolder.INSTANCE.instance;
	}
	
	public static void main(String[] args) {
		System.out.println(EnumSingletonDemo.getInstance());
	}

}
