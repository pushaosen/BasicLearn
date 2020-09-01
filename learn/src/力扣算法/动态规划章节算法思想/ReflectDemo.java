package �����㷨.��̬�滮�½��㷨˼��;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> clazz = Class.forName("�����㷨.��̬�滮�½��㷨˼��.ReflectDemo");
		Object instance = clazz.getConstructor().newInstance();
		for(Method method :clazz.getMethods()) {
            if ("fun".equals(method.getName())) {
                Object result = method.invoke(instance,"���");
                System.out.println(result);
            }
        }
	}
	
	public static String fun(String name) {
		return name;
	}

}
