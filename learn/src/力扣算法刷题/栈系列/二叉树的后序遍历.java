package 力扣算法刷题.栈系列;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的后序遍历 {

	/** 
	 * 题目：给定一个二叉树，返回它的 后序 遍历
	 */
	
	/**
	 * 解法一：递归解法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 */
	public static List<Integer> fun(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		postorder(root, res);
		return res;
	}

	private static void postorder(TreeNode root, List<Integer> res) {
		if(root == null) {
			return;
		}
		// 先遍历左孩子的节点的值
		postorder(root.left, res);
		// 再遍历右孩子节点的值
		postorder(root.right, res);
		// 再处理根节点的值
		res.add(root.val);
	}
	
	/** 
	 * 解法二：迭代解法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n) 
	 */
	public static List<Integer> postorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode prev = null;
		while(root != null || !stack.isEmpty()) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if(root.right == null || root.right == prev) {
				res.add(root.val);
				prev = root;
				root = null;
			}else {
				stack.push(root);
				root = root.right;
			}
		}
		return res;
	} 
}
