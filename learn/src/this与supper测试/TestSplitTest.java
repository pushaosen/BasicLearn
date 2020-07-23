package thisÓësupper²âÊÔ;

import java.util.ArrayList;
import java.util.List;

public class TestSplitTest {
	
	public static void main(String[] args) {
		String str = "123¡¢234¡¢)567¡¢";
		if(str.endsWith("¡¢")) {
			str = str.substring(0, str.length() - 1);
		}
		while(str.contains("¡¢)")) {
			int index = str.indexOf("¡¢)");
			String prefix = str.substring(0, index);
			String pre = str.substring(index + "¡¢)".length(), str.length());
			str = prefix + ")" + pre;
		}
		System.out.println(str);
		
		List<String> list1 = new ArrayList<String>();
		list1.add("zhangsan");
		List<String> list2 = new ArrayList<String>();
		list2.add("zhangsan");
		list2.add("lisi");
		List<String> list3 = list2.subList(0, 1);
		list3.add("wangwu");
//		list2.add("zhou");   // »á±¨´í
		System.out.println(list2);
		System.out.println(list3);
		System.out.println(list1.equals(list2));
		
	}

}
