package 代理模式.jdk动态代理;

import java.lang.reflect.Method;

/**
 * 模拟Cglib代理的实现
 * @author lenovo
 *
 */
public class CglibDbQueryIntercepter implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method m1, Object[] arr, MethodProxy m) {
		return null;
	}

}
