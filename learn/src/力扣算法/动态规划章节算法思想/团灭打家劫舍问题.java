package 力扣算法.动态规划章节算法思想;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 团灭之打家劫舍问题：强盗不能抢相邻的房子
 * 第一道题：是比较标准的动态规划问题：房子是一排
 * 第二道题：融入了环形数组的概念：房子是一个环
 * 第三道题：把动态规划的自底向上和自顶向下解法和二叉树结合起来：房子不是一排，不是一圈，而是一颗二叉树，房子在二叉树的节点上，
 *        相连的两个房子不能同时被抢，果然是传说中的高智商犯罪；
 * 
 * 解决动态规划的问题就是找【状态】和【选择】
 * 你面前的房子的索引就是状态，抢和不抢就是选择
 * @author lenovo
 *
 */
public class 团灭打家劫舍问题 {
	
	// 第一道题：
	// 主函数
	public static int rob(int[] nums) {
		return dp(nums, 0);
	}
	// 返回nums[start...]能抢到的最大值
	@SuppressWarnings("unused")
	private static int dp(int[] nums, int start) {
		if(start >= nums.length) {
			return 0;
		}
		int res = Math.max(
				// 不抢，去下家
				dp(nums, start + 1),
				// 抢，去下下家
				nums[start] + dp(nums, start + 2));
		return res;
	}
	// 明确了状态转移，就可以发现对于同一start位置，是存在重叠子问题的，
	// 盗贼有多种选择可以走到这个位置，如果每次到这都进入递归，岂不是浪费时间？所以说存在重叠子问题，可以用备忘录进行优化
	private int[] memo;
	// 主函数
	public int robMemo(int[] nums) {
		// 初始化备忘录
		memo = new int[nums.length];
		Arrays.fill(memo, -1);
		// 强盗从第0间房子开始抢劫
		return dpMemo(nums, 0);
	}
	// 返回dp[start...]能抢到的最大值
	private int dpMemo(int[] nums, int start) {
		if(start >= nums.length) {
			return 0;
		}
		// 避免重复计算
		if(memo[start] != -1) {
			return memo[start];
		}
		
		int res = Math.max(dpMemo(nums, start + 1), 
                nums[start] + dpMemo(nums, start + 2));
		// 记入备忘录
		memo[start] = res;
		return res;
	}
	// 这就是自顶向下的动态规划解法，我们也可以略作修改，写出自底向上的解法：
	int rob1(int[] nums) {
		int n = nums.length;
		// dp[i] = x 表示：
		// 从第i间房子开始抢劫，最多能抢到的钱为 X
		// base case：dp[n] = 0
		int[] dp = new int[n + 2];
		for(int i = n -1; i >= 0; i --) {
			dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
		}
		return dp[0];
	}
	// 我们又发现状态转移只和dp[i]最近的两个状态有关，所以可以进一步优化，将空间复杂度降低到O(1)
	int rob2(int[] nums) {
		int n = nums.length;
		// 记录dp[i+1]和dp[i+2]
		int dp_i_1 = 0, dp_i_2 = 0;
		// 记录 dp[i]
		int dp_i = 0;
		for(int i = n -1; i >= 0; i --) {
			dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
			dp_i_2 = dp_i_1;
			dp_i_1 = dp_i;
		}
		return dp_i;
	}
	// 以上的流程，在我们【动态规划】中详细解释过，相信大家都能手到擒来了。我认为很有意思的是这个问题的follow up，
	// 需要基于我们现在的思路做一些巧妙的应变。
	
	
	
	// 第二道题：房子排成一个环，围成一个圈
	// 首先，首尾房间不能同时被抢，那么只可能有三种不同情况：要么都不被抢；要么第一件房子被抢最后一间不抢；要么最后一间房子被抢第一间不抢
	// 其实我们不需要比较三种情况，只要比较情况二和情况三就行了，因为这两种情况对于房子的选择余地比情况一大呀，房子里的钱都是非负数，
	// 所以选择余地大，最优决策结果肯定不会小
	public int rob3(int[] nums) {
		int n = nums.length;
		if(n == 1) {
			return nums[0];
		}
		return Math.max(robRange(nums, 0, n - 2), 
                robRange(nums, 1, n - 1));
	}
	// 仅计算闭区间 [start, end] 的最优结果
	@SuppressWarnings("unused")
	private int robRange(int[] nums, int start, int end) {
		int n = nums.length;
		int dp_i_1 = 0,dp_i_2 = 0;
		int dp_i = 0;
		for(int i = end; i >= start; i --) {
			dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
			dp_i_2 = dp_i_1;
			dp_i_1 = dp_i;
		}
		return dp_i;
	}
	
	
	
	// 第三道题：房子排成一个二叉树
	// 整体的思路完全没变，还是做抢或者不抢的选择，去收益较大的选择，甚至我们可以直接按这个套路写出代码
	Map<TreeNode, Integer> memo1 = new HashMap<>();
	public int rob3(TreeNode root) {
		if(root == null) {
			return 0;
		}
		// 利用备忘录消除重叠子问题
		if(memo1.containsKey(root)) {
			return memo1.get(root);
		}
		// 抢，然后去下下家
		int do_it = root.val
		        + (root.left == null ? 
		            0 : rob3(root.left.left) + rob3(root.left.right))
		        + (root.right == null ? 
		            0 : rob3(root.right.left) + rob3(root.right.right));
		    // 不抢，然后去下家
		    int not_do = rob3(root.left) + rob3(root.right);
		    
		    int res = Math.max(do_it, not_do);
		    memo1.put(root, res);
		    return res;
	}
	// 这道题就解决了，时间复杂度O(N),N为树的节点数
	// 但是这道题让我觉得巧妙的点在于，还有更漂亮的解法。比如下面是我们在评论区看到的一个解法：
	int rob4(TreeNode root) {
		int[] res = dp(root);
		 return Math.max(res[0], res[1]);
	}
	/** 
	 * 返回一个大小为2的数组arr
	 * arr[0]表示不抢root的话。得到的最大的钱数
	 * arr[1]表示抢root的话，得到的最大的钱数
	 */
	int[] dp(TreeNode root) {
		if(root == null) {
			return new int[] {0,0};
		}
		int[] left = dp(root.left);
		int[] right  = dp(root.right );
		// 抢，下家就不能抢了
		int rob = root.val + left[0] + right[0];
		// 不抢，下家可抢可不抢，取决于收益大小
		int not_rob = Math.max(left[0], left[1])
                + Math.max(right[0], right[1]);
    
    return new int[]{not_rob, rob};
	}
	/** 
	 * 时间复杂度O(N)，空间复杂度只有递归函数堆栈所需的空间，不需要备忘录的额外空间
	 * 
	 * 你看他和我们的思路不一样，修改了递归函数的定义，略微修改了思路，使得逻辑自治，依然得到了正确的答案，而且代码更漂亮。
	 * 这就是我们前文【不同定义产生不同解法】所说过的动态规划问题的一个特性。
	 * 
	 * 实际上，这个解法比我们的解法运行时间要快得多，虽然算法分析层面时间复杂度是相同的。原因在于此解法没有使用额外的备忘录，
	 * 减少了数据操作的复杂性，所以实际运行效率会快。
	 */
	
	
	static class TreeNode{
		public TreeNode left;
		public TreeNode right;
		public int val;
	}
}
