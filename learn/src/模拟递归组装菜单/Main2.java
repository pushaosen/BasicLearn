
package 模拟递归组装菜单;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {
	
	static List<Menu> list = new ArrayList<Menu>();
	static {
		// 这里模拟到三级菜单
		Menu m1 = new Menu("用户", 1, null, 7);
		Menu m2 = new Menu("用户", 2, null, 7);
		Menu m3 = new Menu("用户", 3, null, 0);
		Menu m7 = new Menu("用户", 7, null, 8);
		Menu m8 = new Menu("用户", 8, null, 0);
		Menu m4 = new Menu("用户", 4, null, 9);
		Menu m5 = new Menu("用户", 5, null, 9);
		Menu m6 = new Menu("用户", 6, null, 5);
		Menu m9 = new Menu("用户", 9, null, 0);
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
		for(Menu menu : childList) {
			// 如果节点的url为空，就表示该节点是父节点，下面还有子节点，就需要继续向下递归调用该方法进行子节点绑定
			if(null == menu.getUrl() || "".equals(menu.getUrl())) {
				// 递归调用本方阿飞
				menu.setChild(getChild(menu.getId(), rootMenu));
			}
		}
		
		// 退出递归的条件(递归调用必须要有退出递归的条件)
		if(childList.size() == 0) {
			return null;
		}
		return childList;
	}

}
