package 力扣算法刷题.递归系列;

public class 最长同值路径 {
	
	/** 
	 * 题目：给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过
	 *     过也可以不经过根节点。
	 *     
	 * 注意：两个节点之间的路径长度由它们之间的边数表示。
	 */

	/**
	 * 解法一：递归
	 * 时间复杂度：O(N)，其中N是树中节点数。我们处理每个节点一次。
	 * 空间复杂度：O(H)，其中H是树的高度。我们递归调用栈可以达到H层的深度。
	 */
	int ans;
	public int longestUnivaluePath(TreeNode root) {
		ans = 0;
		arrowLength(root);
		return ans;
	}
	private int arrowLength(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = arrowLength(root.left);
		int right = arrowLength(root.right);
		int arrowLeft = 0, arrowRight = 0;
		if(root.left != null && root.left.val == root.val) {
			arrowLeft += left + 1;
		}
		if(root.right != null && root.right.val == root.val) {
			arrowRight += right + 1;
		}
		ans = Math.max(ans, arrowLeft + arrowRight);
		return Math.max(arrowLeft, arrowRight);
	}
}
