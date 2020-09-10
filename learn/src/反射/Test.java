package 反射;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		String path = "dbqk(field-data[year{年}-month{月}-day{日}])--bzxxList(list)--bzr(list)--people(object)--name(field)=11";
        String pathPrefix = path.substring(0, path.indexOf(")") + 1);
        path = path.indexOf("--") > 0 ? path.substring(path.indexOf("--") + 2) : "";
        //获取key
        String key = pathPrefix.substring(0, pathPrefix.indexOf("("));

        // 拿到后序的路径
        pathPrefix = pathPrefix.substring(pathPrefix.indexOf("(") + 1, pathPrefix.indexOf(")"));

        int position = pathPrefix.indexOf("-");
        String type = position > 0 ? pathPrefix.substring(0, position) : pathPrefix;
        String lastPath = position > 0 ? pathPrefix.substring(position + 1) : "";
		
		if(lastPath !=null && lastPath != "") {
			String enumPath = lastPath.substring(0, lastPath.indexOf("["));
			String newPath = lastPath.substring(lastPath.indexOf("[") + 1, lastPath.indexOf("]"));
			String[] pathArr = newPath.split("-");
			String re = pathArr[0].substring(0, pathArr[0].indexOf("{"));
			System.out.println(re);
		}
		
		System.out.println("name[圆盖]".substring(0, "name[圆盖]".indexOf("[")));
		System.out.println("name[圆盖]".substring("name[圆盖]".indexOf("[") + 1, "name[圆盖]".indexOf("]")));

		
		AtomicInteger a = new AtomicInteger();
		fun(a);
		System.out.println(a.get());
		
		List<String> list1 = new ArrayList<>();
//		System.out.println(list1.get(3));
		
		String st33r = "dbqk(object)";
		String r = st33r.substring(0, st33r.indexOf("(") + 1);
//		r = r.substring(r.indexOf("(") + 1, r.indexOf(")"));
		System.out.println("结果为：" + r);
		
		Person p = new Person("张三", "28");
		System.out.println(get(p));
		
		AtomicInteger atomicInteger = new AtomicInteger(0);
		atomicInteger.addAndGet(1);
		System.out.println(atomicInteger.get());
		
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
	
	private static void fun(AtomicInteger a) {
		a.addAndGet(3);
	}

}
