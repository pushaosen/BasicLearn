package ∑¥…‰;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> clazz = Class.forName("∑¥…‰.ReflectDemo");
		Object instance = clazz.getConstructor().newInstance();
		for(Method method :clazz.getMethods()) {
            if ("fun".equals(method.getName())) {
                Object result = method.invoke(instance,"¿Ó∞◊");
                System.out.println(result);
            }
        }
		
		String str = "[shshhs]";
		System.out.println(str.substring(str.indexOf("[") + 1, str.indexOf("]")));
	}
	
	public static String fun(String name) {
		return name;
	}

}
