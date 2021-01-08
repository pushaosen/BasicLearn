package 力扣算法刷题.递归系列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 二叉搜索树节点最小距离 {
	
	/**
	 * 题目：给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
	 */
	
	/** 
	 * 示例：
	 *    输入：root = [4,2,6,1,3,null,null]
	 *    输出：1
	 */
	
	/** 
	 * 解法一：排序
	 * 解题思路：将树中所有节点的值写入数组，之后将数组排序。依次计算相邻数之间的差值，找出其中的最小值
	 * 时间复杂度：O(NlogN)，其中 NN 是树中节点的个数，其为排序所消耗的时间。
	 * 空间复杂度：O(N)，其为 vals 的大小。
	 */
	List<Integer> vals;
	public int minDiffInBST(TreeNode root) {
		vals = new ArrayList<>();
		dfs(root);
		Collections.sort(vals);
		
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < vals.size(); ++ i) {
			ans = Math.max(ans, vals.get(i + 1) - vals.get(i));
		}
		return ans;
	}
	private void dfs(TreeNode root) {
		if(root == null) {
			return;
		}
		vals.add(root.val);
		dfs(root.left);
		dfs(root.right);
	}
	
	/** 
	 * 解法二：中序遍历
	 * 解题思路：在二叉搜索树中，中序遍历会将树中节点按数值大小顺序输出。只需要遍历计算相邻数的差值，取其中最小的就可以了
	 * 时间复杂度：O(N)，其中 N 为树中节点的个数
	 * 空间复杂度：O(H)，其中 H 为树的高度，其为递归调用 dfs 产生函数栈的大小
	 */
	Integer prev, ans;
	public int minDiffInBST1(TreeNode root) {
		prev = null;
		ans = Integer.MAX_VALUE;
		dfs1(root);
		return ans;
	}
	private void dfs1(TreeNode root) {
		if(root == null) {
			return;
		}
		dfs1(root.left);
		if(prev != null) {
			ans = Math.min(ans, root.val - prev);
		}
		prev = root.val;
		dfs1(root.right);
	}
}
