
package 模拟递归组装菜单;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	
	static List<Menu> list = new ArrayList<Menu>();
	static {
//		public Menu(String name, int id, List<Menu> child, int parentId) {
		Menu m1 = new Menu("用户", 1, null, 7);
		Menu m2 = new Menu("用户", 2, null, 7);
		Menu m3 = new Menu("用户", 3, null, 0);
		List<Menu> list1 = new ArrayList<>();
		list1.add(m1);
		list1.add(m2);
		Menu m7 = new Menu("用户", 7, list1, 8);
		List<Menu> list2 = new ArrayList<>();
		list2.add(m7);
		Menu m8 = new Menu("用户", 8, list2, 0);
		list.add(m8);
		list.add(m3);
		Menu m4 = new Menu("用户", 4, null, 9);
		Menu m5 = new Menu("用户", 5, null, 9);
		Menu m6 = new Menu("用户", 6, null, 9);
		List<Menu> list3 = new ArrayList<>();
		list3.add(m4);
		list3.add(m5);
		list3.add(m6);
		Menu m9 = new Menu("用户", 9, list3, 0);
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
		 // 最后的结果
	    List<Menu> menuList = new ArrayList<Menu>();
	    // 先找到所有的一级菜单
	    for (int i = 0; i < list.size(); i++) {
	        // 一级菜单没有parentId
	        if (list.get(i).getParentId() == 0) {
	            menuList.add(list.get(i));
	        }
	    }
	    // 为一级菜单设置子菜单，getChild是递归调用的
	    for (Menu menu : menuList) {
	        menu.setChild(getChild(menu.getId(), list));
	    }
	    Map<String,Object> jsonMap = new HashMap<>();
	    jsonMap.put("menu", menuList);
	    System.out.println(jsonMap);
	}
	
	private static List<Menu> getChild(int id, List<Menu> rootMenu){
		// 子菜单
		List<Menu> childList = new ArrayList<>();
		for(Menu menu : rootMenu) {
			// 遍历所有节点，将父菜单节点与穿过来的节点比较
			if(menu.getParentId() != 0) {
				if(menu.getParentId() == id) {
					childList.add(menu);
				}
			}
		}
		
		// 把子菜单的子菜单再循环一遍
		// 退出递归的条件就是：当子节点为空的时候，退出递归
		for(Menu menu : childList) {
			if(null != menu.getUrl() && !"".equals(menu.getUrl())) {
				// 递归
				menu.setChild(getChild(menu.getId(), rootMenu));
			}
		}
		
		// 退出递归的条件
//		if(childList.size() == 0) {
//			return new ArrayList<>();
//		}
		return childList;
	}

}
