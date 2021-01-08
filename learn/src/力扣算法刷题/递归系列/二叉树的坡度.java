package 力扣算法刷题.递归系列;

public class 二叉树的坡度 {
	
	/** 
	 * 题目：给定一个二叉树，计算整个树的坡度
	 * 
	 *     一个树的节点的坡度定义即为：该节点左子树的节点之和和右子树节点之和的差的绝对值，
	 *     如果没有左子树的话，左子树的节点之和为0；没有右子树的话也是一样。空节点的坡度是0.
	 *     
	 *     整个树的坡度就是其所有节点的坡度之和。
	 */
	
    /**
     * 示例：
     *     输入：root = [1,2,3]
     *     输出：1
     *     解释：
     *     节点2的坡度：|0-0|=0(没有子节点)
     *     节点3的坡度：|0-0|=0(没有子节点)
     *     节点1的坡度：|2-3|=1(左子树就是左子节点，所以和是2；右子树就是右子节点，所以和是3)
     *     坡度总和：0+0+1=1
     */
	/** 
	 * 解法一：递归
	 * 时间复杂度：O(n)，其中n是节点的数目。每个节点访问一次
	 * 空间复杂度：O(n)
	 */
	int tilt = 0;
	public int findTilt(TreeNode root) {
		traverse(root);
		return tilt;
	}
	private int traverse(TreeNode root) {
		if(root == null) {
			return 0;
		}
		// 先递归求出左节点的所有坡度
		int left = traverse(root.left);
		// 再递归求出右节点的所有坡度
		int right = traverse(root.right);
		// 求出左右子节点的差值
		tilt+=Math.abs(left-right);
		// 返回左节点+右节点+自身节点的值
		return left+right+root.val;
	}

}
