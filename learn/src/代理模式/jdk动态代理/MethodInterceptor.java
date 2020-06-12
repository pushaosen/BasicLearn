package 代理模式.jdk动态代理;

import java.lang.reflect.Method;

/**
 * 模拟Cglib代理的接口
 * @author lenovo
 *
 */
public interface MethodInterceptor {
	Object intercept(Object obj, Method m1, Object[] arr, MethodProxy m);
}
