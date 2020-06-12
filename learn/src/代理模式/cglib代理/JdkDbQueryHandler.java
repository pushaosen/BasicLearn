package 代理模式.cglib代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import 代理模式.basic.DBquery;
import 代理模式.basic.IDBquery;

/**
 * JDK动态代理的handler
 * @author lenovo
 *
 */
public class JdkDbQueryHandler implements InvocationHandler {
	IDBquery real = null;   // 主题接口

	/**
	 * 动态代理主要获取被代理类方法的
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(real == null) {
			real = new DBquery();   // 如果是第一次调用，则生成真实对象
		}
		return real.request();      // 使用真实主题完成实际的操作
	}
	
	/**
	 * 需要该方法生成动态代理对象
	 * @return
	 */
	public static IDBquery createJdkProxy() {
		IDBquery jdkProxy = (IDBquery)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
				new Class[] {IDBquery.class}, new JdkDbQueryHandler());
		return jdkProxy;
	}

}
