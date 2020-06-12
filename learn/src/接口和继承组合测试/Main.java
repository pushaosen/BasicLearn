package 接口和继承组合测试;

/**
 * 测试：接口的子类调用父类的方法
 * 	         接口的子类调用父类默认的方法
 *     接口的子类调用父接口的方法
 * @author lenovo
 *
 */
public class Main {

	public static void main(String[] args) {
		
		IOperateService obj = new OperateServiceImpl();
		// 使用接口的子类调用父接口的默认方法
		obj.fun3();
		
		// 使用接口的子类调用父类的方法
		((OperateAbstract) obj).fun1();
		
		// 子类直接调用父类的方法
		OperateServiceImpl obj2 = new OperateServiceImpl();
		obj2.fun1();
	}
}
