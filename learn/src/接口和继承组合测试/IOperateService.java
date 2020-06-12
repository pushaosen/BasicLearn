package 接口和继承组合测试;

/**
 * 模拟接口
 * @author lenovo
 *
 */
public interface IOperateService {
	
	default void fun3() {
		System.out.println("测试接口的默认方法");
	}
	
}
