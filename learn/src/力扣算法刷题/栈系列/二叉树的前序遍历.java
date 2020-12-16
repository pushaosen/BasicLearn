package 力扣算法刷题.栈系列;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的前序遍历 {
	/* 
	 * 题目：给你二叉树的根节点 root ，返回它节点值的 前序 遍历
	 */

	/**
 	 * 解法一：递归解法 
 	 * 时间复杂度：O(n)
 	 * 空间复杂度：O(n)
	 */
	public static List<Integer> fun(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		preorder(root, res);
        return res;
	}

	private static void preorder(TreeNode root, List<Integer> res) {
		// 递归的结束条件
		if(root == null) {
			return;
		}
		// 先获取跟节点的值
		res.add(root.val);
		// 再获取左孩子的值
		preorder(root.left, res);
		// 再获取右孩子的值
		preorder(root.right, res);
	}
	
	/** 
	 * 解法二：迭代
	 *  时间复杂度：O(n)
	 *  空间复杂度：O(n)
	 */
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode node = root;
		while(!stack.isEmpty() || node != null) {
			while(node != null) {
				res.add(node.val);
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			node = node.right;
		}
		return res;
	}
}
