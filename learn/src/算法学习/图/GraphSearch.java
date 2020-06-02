package 算法学习.图;

/**
 * 图的广度优先搜索和深度优先搜索实现：使用的链表实现
 * @author lenovo
 *
 * @param <T>
 */
public class GraphSearch<T> {
	
	public StringBuilder searchPathDFS = new StringBuilder();
	public StringBuilder searchPathBFS = new StringBuilder();
	
	/**
	 * 深度优先搜索实现
	 * @param root
	 */
	public void searchDFS(GraphNode<T> root) {
		if(root == null) {
			return;
		}
		
		// visited root
		if(searchPathDFS.length() > 0) {
			searchPathDFS.append("->");
		}
		searchPathDFS.append(root.data.toString());
		root.visited = true;
		
		// 遍历该节点的各个子节点
		for(GraphNode<T> node : root.neighborList) {
			// 如果该节点未被访问，使用递归的思想继续向下遍历，直至所有节点都被访问到
			if(!node.visited) {
				searchDFS(node);
			}
		}
	}
	
	/**
	 * 广度优先搜索实现
	 * @param root
	 */
//	public void searchBFS(GraphNode<T> root) {
//		IQueue<GraphNode<T>> queue = new Queue<GraphNode<T>>();
//	}

}
