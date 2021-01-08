package 力扣算法刷题.递归系列;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最大深度 {
	
	/** 
	 * 题目：给定一个二叉树，找出其最大深度。
	 *     二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
	 */
	
	/** 
	 * 示例：
	 *    输入：给定二叉树 [3,9,20,null,null,15,7]
	 *    输出：3
	 */
	
	/** 
	 * 解法一：递归
	 * 解题思路：我们知道了左子树和右子树的最大深度l和r，那么该二叉树的最大深度为：max(l,r) + 1
	 * 时间复杂度：O(n)，其中n为二叉树节点的个数。每个节点在递归中只遍历一次。
	 * 空间复杂度：O(height)，其中height为二叉树的高度。
	 */
	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}else {
			int leftHeight = maxDepth(root.left);
			int rightHeight = maxDepth(root.right);
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	/** 
	 * 解法二：广度优先搜索
	 * 时间复杂度：O(n)
	 * 空间复杂度：此方法空间的消耗取决于队列存储的元素数量，其在最坏情况下会达到O(n)。
	 */
	public int maxDepth1(TreeNode root) {
		if(root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int ans = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size > 0) {
				TreeNode node = queue.poll();
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
				size --;
			}
			ans ++;
		}
		return ans;
	}

}
