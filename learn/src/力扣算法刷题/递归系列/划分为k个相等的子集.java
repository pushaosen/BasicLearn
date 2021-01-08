package �����㷨ˢ��.�ݹ�ϵ��;

import java.util.Arrays;

public class ����Ϊk����ȵ��Ӽ� {
	
	/** 
	 * ��Ŀ������һ����������  nums ��һ�������� k���ҳ��Ƿ��п��ܰ��������ֳ� k ���ǿ��Ӽ������ܺͶ���ȡ�
	 */
	
	/** 
	 * ʾ����
	 *    ���룺nums = [4, 3, 2, 3, 5, 2, 1], k = 4
	 *    �����True
	 *    ˵�����п��ܽ���ֳ�4���Ӽ�(5)��(1,4)��(2,3)��(2,3)�����ܺ�
	 */

	/** 
	 * �ⷨһ����̬�滮(���¶���)
	 */
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int N = nums.length;
		// ��������
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
