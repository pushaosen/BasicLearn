package 力扣算法刷题.栈系列;

import java.util.Stack;

/** 
 * 解法二：受控递归
 * @author lenovo
 *
 */
public class 二叉搜索树迭代器之受控递归 {

	private Stack<TreeNode> stack;
	
	public 二叉搜索树迭代器之受控递归(TreeNode root) {
		this.stack = new Stack<TreeNode>();
		// 开始处理正常逻辑了
		this._leftmostInorder(root);
	}

	/** 
	 * 
	 */
	private void _leftmostInorder(TreeNode root) {
		while(root != null) {
			this.stack.push(root);
			root = root.left;
		}
	}
	
	/** 
	 * 获取下一个元素
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(h)
	 */
	public int next() {
		 TreeNode topmostNode = this.stack.pop();
		 if(topmostNode.right != null) {
			 // 继续寻找右节点，直到右节点没有子节点，或者找到目标
			 this._leftmostInorder(topmostNode.right);
		 }
		 
		 return topmostNode.val;
	}
	
	/** 
	 * 是否还有下一个元素
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(h)
	 */
	public boolean hasNext() {
		return this.stack.size() > 0;
	}
}
