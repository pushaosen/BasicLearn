package 算法学习.二叉树;

/**
 * 二叉树的具体方法
 * @author lenovo
 *
 */
public interface Tree {

	/**
	 * 查找节点
	 * @param key
	 * @return
	 */
	public Node find(int key);
	
	/**
	 * 插入新节点
	 * @param key
	 * @return
	 */
	public boolean insert(int key);
	
	/**
	 * 删除节点
	 * @param key
	 * @return
	 */
	public boolean delete(int key);
}
