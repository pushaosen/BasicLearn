package �����㷨.��̬�滮�½��㷨˼��;

import java.util.Arrays;

/**
 * ʱ�临�Ӷ�Ϊ��O(N^2)
 * @author lenovo
 *
 */
public class �����������֮��̬�滮�ⷨ {

	public static int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		// dp����ȫ����ʼ��Ϊ1,dp����Ӧ��ȫ����ʼ��Ϊ1����Ϊ����������ҲҪ�����Լ������Գ�����СΪ1
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
	 * ���������������
	 */
	public static void main(String[] args) {
		
	}
}
