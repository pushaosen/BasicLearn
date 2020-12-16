package 力扣算法刷题.栈系列;

import java.util.ArrayList;

/** 
 * 解法一：扁平化二叉搜索树
 */
public class 二叉搜索树迭代器 {

	/** 
	 * 题目：实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。调用 next() 将返回二叉搜索树中的下一个最小的数。
	 */
	
	/** 
	 * 二叉搜索树的一个重要的特性是二叉搜索树的中序序列是升序序列；
	 */
	
	private ArrayList<Integer> nodesSorted;
	private int index;
	
	public 二叉搜索树迭代器(TreeNode root) {
		this.nodesSorted = new ArrayList<Integer>();
		this.index = -1;
		this._inorder(root);
	}

	private void _inorder(TreeNode root) {
		if(root == null) {
			return;
		}
		// 先遍历左节点的值
		this._inorder(root.left);
		// 再遍历根节点的值
		this.nodesSorted.add(root.val);
		// 再遍历右节点的值
		this._inorder(root.right);
	}
	
	/** 
	 * 获取下一个的值
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(N)
	 */
	public int next() {
		return this.nodesSorted.get(++this.index);
	}
	
	/** 
	 * 判断是否还有元素的方法
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(N)
	 */
	public boolean hasNext() {
		return this.index + 1 < this.nodesSorted.size();
	}
}
