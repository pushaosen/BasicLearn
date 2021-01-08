package 力扣算法刷题.递归系列;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BiNode {
	
	/** 
	 * 题目：
	 *    二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，
	 *    把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
	 *    返回转化后的单向链表的头结点。
	 */
	
	/** 
	 * 示例：
	 *    输入：[4,2,5,1,3,null,6,0]
	 *    输出：[0,null,1,null,2,null,3,null,4,null,5,null,6]
	 */
	
	/** 
	 * 解法一：递归实现
	 * 解题思路：
	 *       使用中序遍历来获取到排序后的节点值，后将这些排序后的结果值生成题目需要的二分搜索树
	 * 缺陷：时间复杂度较高
	 */
	public TreeNode convertBiNode(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		convertBiNode(root, list);
		return listToTreeNode(list);
	}
	private void convertBiNode(TreeNode root, List<Integer> list) {
		if(root == null) {
			return;
		}
		convertBiNode(root.left, list);
		list.add(root.val);
		convertBiNode(root.right, list);
	}
	private TreeNode listToTreeNode(List<Integer> list) {
		if(list.size() == 0) {
			return null;
		}
		TreeNode root = new TreeNode(list.get(0));
		TreeNode cur = root;
		for(int i = 1; i < list.size(); i ++) {
			cur.left = null;
			cur.right = new TreeNode(list.get(i));
			cur = cur.right;
		}
		return root;
	}
	
	/** 
	 * 解法二：耗时比较少的递归
	 * 该递归方法的效率要比解法三的非递归方法的效率要高
	 */
	public TreeNode convertBiNode1(TreeNode root) {
		TreeNode head = new TreeNode(0);   // 单链表的头指针哨兵
		// 开始中序遍历
		inorder(root, head);
		return head.right;
	}
	private TreeNode inorder(TreeNode root, TreeNode prev) {
		if(root != null) {
			prev = inorder(root.left, prev);
			root.left = null;
			prev.right = root;
			prev = root;
			prev = inorder(root.right, prev);
		}
		return prev;
	}
	
	/** 
	 * 解法三：非递归
	 */
	public TreeNode convertBiNode2(TreeNode root) {
		TreeNode head = new TreeNode(0);   // 单链表的头指针哨兵
		TreeNode prev = head;   // 移动的链表前置指针
		// 开始中序遍历
		TreeNode node = root;
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		while(node != null || !stack.isEmpty()) {
			if(node != null) {
				stack.push(node);
				node = node.left;
			}else {
				node = stack.pop();
				// ---- 链表处理
				node.left = null;   // 当前节点指针置空
				prev.right = node;  // 前置指针右指针指向当前节点，作为链表的next指针，链表新增元素
				prev = node;   // 指针后移
				// ----链表处理
				// 中序遍历进入右子树
				node = node.right;
			}
		}
		return head.right;
	}

}
