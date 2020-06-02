package �㷨ѧϰ.ͼ;

/**
 * ͼ�Ĺ�����������������������ʵ�֣�ʹ�õ�����ʵ��
 * @author lenovo
 *
 * @param <T>
 */
public class GraphSearch<T> {
	
	public StringBuilder searchPathDFS = new StringBuilder();
	public StringBuilder searchPathBFS = new StringBuilder();
	
	/**
	 * �����������ʵ��
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
		
		// �����ýڵ�ĸ����ӽڵ�
		for(GraphNode<T> node : root.neighborList) {
			// ����ýڵ�δ�����ʣ�ʹ�õݹ��˼��������±�����ֱ�����нڵ㶼�����ʵ�
			if(!node.visited) {
				searchDFS(node);
			}
		}
	}
	
	/**
	 * �����������ʵ��
	 * @param root
	 */
//	public void searchBFS(GraphNode<T> root) {
//		IQueue<GraphNode<T>> queue = new Queue<GraphNode<T>>();
//	}

}
