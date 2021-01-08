package 力扣算法刷题.递归系列;

import java.util.Arrays;

public class 划分为k个相等的子集 {
	
	/** 
	 * 题目：给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
	 */
	
	/** 
	 * 示例：
	 *    输入：nums = [4, 3, 2, 3, 5, 2, 1], k = 4
	 *    输出：True
	 *    说明：有可能将其分成4个子集(5)，(1,4)，(2,3)，(2,3)等于总和
	 */

	/** 
	 * 解法一：动态规划(自下而上)
	 */
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int N = nums.length;
		// 进行排序
		Arrays.sort(nums);
		int sum = Arrays.stream(nums).sum();
		int target = sum / k;
		if(sum % k > 0 || nums[N-1] > target) {
			return false;
		}
		
		boolean[] dp = new boolean[1<<N];
		dp[0] = true;
		int[] total = new int[1<<N];
		
		for(int state = 0; state < (1<<N); state ++) {
			if(!dp[state]) {
				continue;
			}
			for(int i = 0; i < N; i ++) {
				int future = state | (1<<i);
				if(state != future && !dp[future]) {
					if(nums[i] <= target - (total[state] % target)) {
						dp[future] = true;
						total[future] = total[state] + nums[i];
					}else {
						break;
					}
				}
			}
		}
		return dp[(1 << N) - 1];
	}
	
}
