
package ģ��ݹ���װ�˵�;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {
	
	static List<Menu> list = new ArrayList<Menu>();
	static {
		// ����ģ�⵽�����˵�
		Menu m1 = new Menu("�û�", 1, null, 7);
		Menu m2 = new Menu("�û�", 2, null, 7);
		Menu m3 = new Menu("�û�", 3, null, 0);
		Menu m7 = new Menu("�û�", 7, null, 8);
		Menu m8 = new Menu("�û�", 8, null, 0);
		Menu m4 = new Menu("�û�", 4, null, 9);
		Menu m5 = new Menu("�û�", 5, null, 9);
		Menu m6 = new Menu("�û�", 6, null, 5);
		Menu m9 = new Menu("�û�", 9, null, 0);
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		list.add(m6);
		list.add(m7);
		list.add(m8);
		list.add(m9);
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
		for(Menu menu : childList) {
			// ����ڵ��urlΪ�գ��ͱ�ʾ�ýڵ��Ǹ��ڵ㣬���滹���ӽڵ㣬����Ҫ�������µݹ���ø÷��������ӽڵ��
			if(null == menu.getUrl() || "".equals(menu.getUrl())) {
				// �ݹ���ñ�������
				menu.setChild(getChild(menu.getId(), rootMenu));
			}
		}
		
		// �˳��ݹ������(�ݹ���ñ���Ҫ���˳��ݹ������)
		if(childList.size() == 0) {
			return null;
		}
		return childList;
	}

}
