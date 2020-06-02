package 算法学习.图;

import java.util.ArrayList;
import java.util.List;

/**
 * 无向简单图的节点
 * @author lenovo
 *
 */
public class GraphNode<T> {
	
	T data;
	List<GraphNode<T>> neighborList;
	boolean visited;
	
	// 构造方法
	public GraphNode(T data) {
		this.data = data;
		neighborList = new ArrayList<GraphNode<T>>();
		visited = false;
	}
	
	// 比较节点的数据是否相等
	public boolean equals(GraphNode<T> node){
		return this.data.equals(node.data);
	}
	
	/**
	 * 还原图中所有节点为未访问
	 */
	public void restoreVisited() {
		restoreVisited(this);
	}
	
	private void restoreVisited(GraphNode<T> node) {
		if(node.visited) {
			node.visited = false;
		}
		
		List<GraphNode<T>> neighbors = node.neighborList;
		for(int i = 0, size = neighbors.size(); i < size; i ++) {
			// 循环递归调用将自己所有的子类的节点都设置为未访问
			restoreVisited(this);
		}
	}
	

}
