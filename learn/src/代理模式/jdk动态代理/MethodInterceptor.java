package ����ģʽ.jdk��̬����;

import java.lang.reflect.Method;

/**
 * ģ��Cglib����Ľӿ�
 * @author lenovo
 *
 */
public interface MethodInterceptor {
	Object intercept(Object obj, Method m1, Object[] arr, MethodProxy m);
}
