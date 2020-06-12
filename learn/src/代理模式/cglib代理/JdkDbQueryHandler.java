package ����ģʽ.cglib����;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import ����ģʽ.basic.DBquery;
import ����ģʽ.basic.IDBquery;

/**
 * JDK��̬�����handler
 * @author lenovo
 *
 */
public class JdkDbQueryHandler implements InvocationHandler {
	IDBquery real = null;   // ����ӿ�

	/**
	 * ��̬������Ҫ��ȡ�������෽����
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(real == null) {
			real = new DBquery();   // ����ǵ�һ�ε��ã���������ʵ����
		}
		return real.request();      // ʹ����ʵ�������ʵ�ʵĲ���
	}
	
	/**
	 * ��Ҫ�÷������ɶ�̬�������
	 * @return
	 */
	public static IDBquery createJdkProxy() {
		IDBquery jdkProxy = (IDBquery)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
				new Class[] {IDBquery.class}, new JdkDbQueryHandler());
		return jdkProxy;
	}

}
