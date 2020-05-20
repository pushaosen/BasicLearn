
package ģ��ݹ���װ�˵�;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	
	static List<Menu> list = new ArrayList<Menu>();
	static {
//		public Menu(String name, int id, List<Menu> child, int parentId) {
		Menu m1 = new Menu("�û�", 1, null, 7);
		Menu m2 = new Menu("�û�", 2, null, 7);
		Menu m3 = new Menu("�û�", 3, null, 0);
		List<Menu> list1 = new ArrayList<>();
		list1.add(m1);
		list1.add(m2);
		Menu m7 = new Menu("�û�", 7, list1, 8);
		List<Menu> list2 = new ArrayList<>();
		list2.add(m7);
		Menu m8 = new Menu("�û�", 8, list2, 0);
		list.add(m8);
		list.add(m3);
		Menu m4 = new Menu("�û�", 4, null, 9);
		Menu m5 = new Menu("�û�", 5, null, 9);
		Menu m6 = new Menu("�û�", 6, null, 9);
		List<Menu> list3 = new ArrayList<>();
		list3.add(m4);
		list3.add(m5);
		list3.add(m6);
		Menu m9 = new Menu("�û�", 9, list3, 0);
		list.add(m9);
	}
	
	@SuppressWarnings("unused")
	private static void test() {
		list.stream().map(str ->{
			boolean flag = true;
			if(!flag) {
//				continue;
			}
			return str;
		}).collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
//		Map<Integer, List<Menu>> collect = list.stream()
//        .collect(Collectors.groupingBy(Menu::getParentId));
//		System.out.println(collect);
		 // ���Ľ��
	    List<Menu> menuList = new ArrayList<Menu>();
	    // ���ҵ����е�һ���˵�
	    for (int i = 0; i < list.size(); i++) {
	        // һ���˵�û��parentId
	        if (list.get(i).getParentId() == 0) {
	            menuList.add(list.get(i));
	        }
	    }
	    // Ϊһ���˵������Ӳ˵���getChild�ǵݹ���õ�
	    for (Menu menu : menuList) {
	        menu.setChild(getChild(menu.getId(), list));
	    }
	    Map<String,Object> jsonMap = new HashMap<>();
	    jsonMap.put("menu", menuList);
	    System.out.println(jsonMap);
	}
	
	private static List<Menu> getChild(int id, List<Menu> rootMenu){
		// �Ӳ˵�
		List<Menu> childList = new ArrayList<>();
		for(Menu menu : rootMenu) {
			// �������нڵ㣬�����˵��ڵ��봩�����Ľڵ�Ƚ�
			if(menu.getParentId() != 0) {
				if(menu.getParentId() == id) {
					childList.add(menu);
				}
			}
		}
		
		// ���Ӳ˵����Ӳ˵���ѭ��һ��
		// �˳��ݹ���������ǣ����ӽڵ�Ϊ�յ�ʱ���˳��ݹ�
		for(Menu menu : childList) {
			if(null != menu.getUrl() && !"".equals(menu.getUrl())) {
				// �ݹ�
				menu.setChild(getChild(menu.getId(), rootMenu));
			}
		}
		
		// �˳��ݹ������
//		if(childList.size() == 0) {
//			return new ArrayList<>();
//		}
		return childList;
	}

}
