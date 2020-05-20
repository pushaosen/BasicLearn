package 模拟递归组装菜单;

import java.util.List;

public class Menu {
	
	private String name;
	private int id;
	private List<Menu> child;
	private int parentId;
	private String url;
	
	
	public Menu() {
		super();
	}
	
	
	public Menu(String name, int id, List<Menu> child, int parentId) {
		super();
		this.name = name;
		this.id = id;
		this.child = child;
		this.parentId = parentId;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Menu> getChild() {
		return child;
	}
	public void setChild(List<Menu> child) {
		this.child = child;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	public String toString() {
		return "Menu [name=" + name + ", id=" + id + ", child=" + child + ", parentId=" + parentId + ", url=" + url
				+ "]";
	}
	

}
