package �����㷨.��̬�滮�½��㷨˼��;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ����֮��ҽ������⣺ǿ�����������ڵķ���
 * ��һ���⣺�ǱȽϱ�׼�Ķ�̬�滮���⣺������һ��
 * �ڶ����⣺�����˻�������ĸ��������һ����
 * �������⣺�Ѷ�̬�滮���Ե����Ϻ��Զ����½ⷨ�Ͷ�����������������Ӳ���һ�ţ�����һȦ������һ�Ŷ������������ڶ������Ľڵ��ϣ�
 *        �������������Ӳ���ͬʱ��������Ȼ�Ǵ�˵�еĸ����̷��
 * 
 * �����̬�滮����������ҡ�״̬���͡�ѡ��
 * ����ǰ�ķ��ӵ���������״̬�����Ͳ�������ѡ��
 * @author lenovo
 *
 */
public class �����ҽ������� {
	
	// ��һ���⣺
	// ������
	public static int rob(int[] nums) {
		return dp(nums, 0);
	}
	// ����nums[start...]�����������ֵ
	@SuppressWarnings("unused")
	private static int dp(int[] nums, int start) {
		if(start >= nums.length) {
			return 0;
		}
		int res = Math.max(
				// ������ȥ�¼�
				dp(nums, start + 1),
				// ����ȥ���¼�
				nums[start] + dp(nums, start + 2));
		return res;
	}
	// ��ȷ��״̬ת�ƣ��Ϳ��Է��ֶ���ͬһstartλ�ã��Ǵ����ص�������ģ�
	// �����ж���ѡ������ߵ����λ�ã����ÿ�ε��ⶼ����ݹ飬�����˷�ʱ�䣿����˵�����ص������⣬�����ñ���¼�����Ż�
	private int[] memo;
	// ������
	public int robMemo(int[] nums) {
		// ��ʼ������¼
		memo = new int[nums.length];
		Arrays.fill(memo, -1);
		// ǿ���ӵ�0�䷿�ӿ�ʼ����
		return dpMemo(nums, 0);
	}
	// ����dp[start...]�����������ֵ
	private int dpMemo(int[] nums, int start) {
		if(start >= nums.length) {
			return 0;
		}
		// �����ظ�����
		if(memo[start] != -1) {
			return memo[start];
		}
		
		int res = Math.max(dpMemo(nums, start + 1), 
                nums[start] + dpMemo(nums, start + 2));
		// ���뱸��¼
		memo[start] = res;
		return res;
	}
	// ������Զ����µĶ�̬�滮�ⷨ������Ҳ���������޸ģ�д���Ե����ϵĽⷨ��
	int rob1(int[] nums) {
		int n = nums.length;
		// dp[i] = x ��ʾ��
		// �ӵ�i�䷿�ӿ�ʼ���٣������������ǮΪ X
		// base case��dp[n] = 0
		int[] dp = new int[n + 2];
		for(int i = n -1; i >= 0; i --) {
			dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
		}
		return dp[0];
	}
	// �����ַ���״̬ת��ֻ��dp[i]���������״̬�йأ����Կ��Խ�һ���Ż������ռ临�ӶȽ��͵�O(1)
	int rob2(int[] nums) {
		int n = nums.length;
		// ��¼dp[i+1]��dp[i+2]
		int dp_i_1 = 0, dp_i_2 = 0;
		// ��¼ dp[i]
		int dp_i = 0;
		for(int i = n -1; i >= 0; i --) {
			dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
			dp_i_2 = dp_i_1;
			dp_i_1 = dp_i;
		}
		return dp_i;
	}
	// ���ϵ����̣������ǡ���̬�滮������ϸ���͹������Ŵ�Ҷ����ֵ������ˡ�����Ϊ������˼������������follow up��
	// ��Ҫ�����������ڵ�˼·��һЩ�����Ӧ�䡣
	
	
	
	// �ڶ����⣺�����ų�һ������Χ��һ��Ȧ
	// ���ȣ���β���䲻��ͬʱ��������ôֻ���������ֲ�ͬ�����Ҫô����������Ҫô��һ�����ӱ������һ�䲻����Ҫô���һ�䷿�ӱ�����һ�䲻��
	// ��ʵ���ǲ���Ҫ�Ƚ����������ֻҪ�Ƚ������������������ˣ���Ϊ������������ڷ��ӵ�ѡ����ر����һ��ѽ���������Ǯ���ǷǸ�����
	// ����ѡ����ش����ž��߽���϶�����С
	public int rob3(int[] nums) {
		int n = nums.length;
		if(n == 1) {
			return nums[0];
		}
		return Math.max(robRange(nums, 0, n - 2), 
                robRange(nums, 1, n - 1));
	}
	// ����������� [start, end] �����Ž��
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
	
	
	
	// �������⣺�����ų�һ��������
	// �����˼·��ȫû�䣬�����������߲�����ѡ��ȥ����ϴ��ѡ���������ǿ���ֱ�Ӱ������·д������
	Map<TreeNode, Integer> memo1 = new HashMap<>();
	public int rob3(TreeNode root) {
		if(root == null) {
			return 0;
		}
		// ���ñ���¼�����ص�������
		if(memo1.containsKey(root)) {
			return memo1.get(root);
		}
		// ����Ȼ��ȥ���¼�
		int do_it = root.val
		        + (root.left == null ? 
		            0 : rob3(root.left.left) + rob3(root.left.right))
		        + (root.right == null ? 
		            0 : rob3(root.right.left) + rob3(root.right.right));
		    // ������Ȼ��ȥ�¼�
		    int not_do = rob3(root.left) + rob3(root.right);
		    
		    int res = Math.max(do_it, not_do);
		    memo1.put(root, res);
		    return res;
	}
	// �����ͽ���ˣ�ʱ�临�Ӷ�O(N),NΪ���Ľڵ���
	// ������������Ҿ�������ĵ����ڣ����и�Ư���Ľⷨ������������������������������һ���ⷨ��
	int rob4(TreeNode root) {
		int[] res = dp(root);
		 return Math.max(res[0], res[1]);
	}
	/** 
	 * ����һ����СΪ2������arr
	 * arr[0]��ʾ����root�Ļ����õ�������Ǯ��
	 * arr[1]��ʾ��root�Ļ����õ�������Ǯ��
	 */
	int[] dp(TreeNode root) {
		if(root == null) {
			return new int[] {0,0};
		}
		int[] left = dp(root.left);
		int[] right  = dp(root.right );
		// �����¼ҾͲ�������
		int rob = root.val + left[0] + right[0];
		// �������¼ҿ����ɲ�����ȡ���������С
		int not_rob = Math.max(left[0], left[1])
                + Math.max(right[0], right[1]);
    
    return new int[]{not_rob, rob};
	}
	/** 
	 * ʱ�临�Ӷ�O(N)���ռ临�Ӷ�ֻ�еݹ麯����ջ����Ŀռ䣬����Ҫ����¼�Ķ���ռ�
	 * 
	 * �㿴�������ǵ�˼·��һ�����޸��˵ݹ麯���Ķ��壬��΢�޸���˼·��ʹ���߼����Σ���Ȼ�õ�����ȷ�Ĵ𰸣����Ҵ����Ư����
	 * ���������ǰ�ġ���ͬ���������ͬ�ⷨ����˵���Ķ�̬�滮�����һ�����ԡ�
	 * 
	 * ʵ���ϣ�����ⷨ�����ǵĽⷨ����ʱ��Ҫ��ö࣬��Ȼ�㷨��������ʱ�临�Ӷ�����ͬ�ġ�ԭ�����ڴ˽ⷨû��ʹ�ö���ı���¼��
	 * ���������ݲ����ĸ����ԣ�����ʵ������Ч�ʻ�졣
	 */
	
	
	static class TreeNode{
		public TreeNode left;
		public TreeNode right;
		public int val;
	}
}
