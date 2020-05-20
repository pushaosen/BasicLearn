package ����ģʽ;

public class EnumSingletonDemo {
	
	private EnumSingletonDemo() {}
	
	// �ӳټ���
	private enum EnumHolder{
		INSTANCE;
		private static EnumSingletonDemo instance = new EnumSingletonDemo();
		
//		public EnumSingletonDemo getInstance(){
//            instance=new EnumSingletonDemo();
//            return instance;
//		}
	}
	
	// ������
	@SuppressWarnings("static-access")
	public static EnumSingletonDemo getInstance() {
		return EnumHolder.INSTANCE.instance;
	}
	
	public static void main(String[] args) {
		System.out.println(EnumSingletonDemo.getInstance());
	}

}
