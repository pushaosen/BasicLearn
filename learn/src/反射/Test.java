package ∑¥…‰;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Test {
	
	private static Object get(Person person) {
      Field[] fields = person.getClass().getDeclaredFields();
      for (Field field : fields){
          if(field.getName().equals("name")){
              field.setAccessible(true);
              try {
                  if(field.get(person)!=null){
                      return field.get(person);
                  }
              } catch (IllegalAccessException e) {
                  e.printStackTrace();
              }

          }
      }
		return "";
	}
	
	public static void main(String[] args) {
		Person p = new Person("’≈»˝", "28");
		System.out.println(get(p));
		
		List<String> list = new ArrayList<String>();
		list.add("jay");
		list.add("zz");
		list.add("hh");
		for(String str : list) {
			switch (str) {
			case "jsy":
					System.out.println(str);
				break;
			case "hh":
				System.out.println(str);
			break;
			default:
				break;
			}
		}
	}

}
