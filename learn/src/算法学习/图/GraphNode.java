package �㷨ѧϰ.ͼ;

import java.util.ArrayList;
import java.util.List;

/**
 * �����ͼ�Ľڵ�
 * @author lenovo
 *
 */
public class GraphNode<T> {
	
	T data;
	List<GraphNode<T>> neighborList;
	boolean visited;
	
	// ���췽��
	public GraphNode(T data) {
		this.data = data;
		neighborList = new ArrayList<GraphNode<T>>();
		visited = false;
	}
	
	// �ȽϽڵ�������Ƿ����
	public boolean equals(GraphNode<T> node){
		return this.data.equals(node.data);
	}
	
	/**
	 * ��ԭͼ�����нڵ�Ϊδ����
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
			// ѭ���ݹ���ý��Լ����е�����Ľڵ㶼����Ϊδ����
			restoreVisited(this);
		}
	}
	

}
