package �ӿںͼ̳���ϲ���;

/**
 * ���ԣ��ӿڵ�������ø���ķ���
 * 	         �ӿڵ�������ø���Ĭ�ϵķ���
 *     �ӿڵ�������ø��ӿڵķ���
 * @author lenovo
 *
 */
public class Main {

	public static void main(String[] args) {
		
		IOperateService obj = new OperateServiceImpl();
		// ʹ�ýӿڵ�������ø��ӿڵ�Ĭ�Ϸ���
		obj.fun3();
		
		// ʹ�ýӿڵ�������ø���ķ���
		((OperateAbstract) obj).fun1();
		
		// ����ֱ�ӵ��ø���ķ���
		OperateServiceImpl obj2 = new OperateServiceImpl();
		obj2.fun1();
	}
}
