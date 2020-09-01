package 力扣算法.动态规划章节算法思想;

import java.util.Arrays;

/**
 * 时间复杂度为：O(N^2)
 * @author lenovo
 *
 */
public class 最长递增子序列之动态规划解法 {

	public static int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		// dp数组全都初始化为1,dp数组应该全部初始化为1，因为子序列最少也要包含自己，所以长度最小为1
		Arrays.fill(dp, 1);
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) 
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		
		int res = 0;
		for (int i = 0; i < dp.length; i++) {
			res = Math.max(res, dp[i]);
		}
		return res;
	}
	
	/*
	 * 测试最长子序列问题
	 */
	public static void main(String[] args) {
		
	}
}
