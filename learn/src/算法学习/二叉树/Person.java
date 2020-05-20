package 算法学习.二叉树;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private List<String> list = new ArrayList<>();

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Person  p = new Person();
		p.setList(list);
//		list.add("这种话");
		System.out.println(p.getList().size());
		System.out.println(Integer.parseInt(""));
	}

}
