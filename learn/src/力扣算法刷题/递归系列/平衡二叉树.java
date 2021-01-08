package 力扣算法刷题.递归系列;

public class 平衡二叉树 {
	
	/** 
	 * 题目：给定一个二叉树，判断它是否是高度平衡的二叉树。
	 *     本题中，一颗高度平衡二叉树定义为：
	 *          一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
	 */

	/** 
	 * 解法一：自顶向下的递归
	 * 解题思路：有了计算节点高度的函数，即可判断二叉树是否平衡。具体做法类似于二叉树的前序遍历，即对于当前遍历到的节点，首先计算左右子树的高度，如果左右子树的高度差是否不超过1，再分别递归
	 *       地遍历左右子节点，并判断左子树和右子树是否平衡。这是一个自顶向下的递归的过程。
	 * 时间复杂度：O(n*n)
	 * 空间复杂度：O(n)
	 */
	public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}else {
			return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
		}
	}
    // 获取节点的高度
	private int height(TreeNode root) {
		if(root == null) {
			return 0;
		}else {
			return Math.max(height(root.left), height(root.right));
		}
	}
	
	/** 
	 * 解法二：自底向上的递归
	 * 解题思路：方法一由于是自顶向下递归，因此对于同一个节点，函数height会被重复调用，导致时间复杂度较高。如果使用自底向上的做法，则对于每个节点，函数height只会被调用一次。
	 *        自底向上递归的做法类似于后序遍历，对于当前遍历到的节点，先递归地判断左右子树是否平衡，再判断以当前节点为根节点的子树是否平衡。如果一颗子树是平衡的，则返回其高度，否则返回-1.
	 *        如果存在一颗子树不平衡，则整个二叉树一定不平衡
	 * 时间复杂度：O(n)，其中n是二叉树中的节点个数。使用自顶向上的递归，每个节点的计算高度和判断是否平衡都只需要处理一次，最坏情况下需要遍历二叉树中的所有节点，因此时间复杂度是O(n)。
	 * 空间复杂度：O(n)，其中n是二叉树中的节点个数。空间复杂度主要取决于递归调用的层数，递归调用的层数不会超过n。
	 */
	public boolean isBalanced1(TreeNode root) {
		return height1(root) >= 0;
	}
	// 获取节点的高度
	private int height1(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = height1(root.left);
		int rightHeight = height1(root.right);
		if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
	}
}
