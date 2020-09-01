package 力扣算法.动态规划章节算法思想;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> clazz = Class.forName("力扣算法.动态规划章节算法思想.ReflectDemo");
		Object instance = clazz.getConstructor().newInstance();
		for(Method method :clazz.getMethods()) {
            if ("fun".equals(method.getName())) {
                Object result = method.invoke(instance,"李白");
                System.out.println(result);
            }
        }
	}
	
	public static String fun(String name) {
		return name;
	}

}
