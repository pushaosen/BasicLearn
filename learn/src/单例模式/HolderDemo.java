package ����ģʽ;

/**
 * �������ʱ�򣬳�Ա�����в�����ʵ�����������ŵ��ڲ���̬����
 * @author wb-pss576863
 *
 */
public class HolderDemo {
	
	private HolderDemo() {}
	
	private static class Holder{
		private static HolderDemo instance = new HolderDemo();
	}
	
	// ������
	@SuppressWarnings("unused")
	private static HolderDemo getInstance() {
		return Holder.instance;
	}
	

}
