package 力扣算法刷题.哈希表系列;

import java.util.HashMap;
import java.util.Map;

public class 使数组和能被P整除 {
	
	/** 
	 * 题目：给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。
	 * 
	 * 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。
	 * 
	 * 子数组 定义为原数组中连续的一组元素。
	 */
	
	/** 
	 * 示例：
	 *    输入：nums = [3,1,4,2], p = 6
	 *    输出：1
	 *    解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6。
	 *    
	 *    输入：nums = [6,3,5,2], p = 9
	 *    输出：2
	 *    解释：我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。
	 *    
	 *    输入：nums = [1,2,3], p = 3
	 *    输出：0
	 *    解释：和恰好为 6 ，已经能被 3 整除了。所以我们不需要移除任何元素。
	 *    
	 *    输入：nums = [1,2,3], p = 7
	 *    输出：-1
	 *    解释：没有任何方案使得移除子数组后剩余元素的和被 7 整除。
	 *    
	 *    输入：nums = [1000000000,1000000000,1000000000], p = 3
	 *    输出：0
	 */
	
	/** 
	 * 测试：
	 */
	public static void main(String[] args) {
		int[] nums = {6,3,5,2};
		使数组和能被P整除  obj = new 使数组和能被P整除();
		int p = 9;
		System.out.println("哈希表解法的结果为：" + obj.minSubarray(nums, p));
		System.out.println("解法二的结果为：" + obj.minSubarray1(nums, p));
	}
	
	/** 
	 * 解法一：哈希表
	 */
	private int minSubarray(int[] nums, int p) {
		int ans = Integer.MAX_VALUE;
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		// 用 mod 存储 和的余数
		long mod = 0;
		for(int num : nums) {
			mod += num;
		}
		mod = mod % p;
		if(mod == 0) {
			return 0;   // 如果 余数 为零，就说明整个数组的和是能被整除的！
		}
		long sum = 0;   // sum存储的是nums[0]到nums[i]的和，也就是前缀和
		map.put((long)0, -1);   // 把 0 设置为-1，因为数组起始坐标为0！
		for(int i = 0; i < nums.length; i ++) {
			sum += nums[i];
			long counter = sum % p;    // 求出前缀和 对 p 取余！
			long ainmnum = (counter - mod + p) % p;  // 求出目标的前缀和
			if(map.get(ainmnum) != null) {
				ans = Math.min(ans, i - map.get(ainmnum));
			}
			map.put(counter, i);   // 将当前位置的前缀和存储map中！
		}
		return ans >= nums.length ? -1 : ans;
	}
	
	/** 
	 * 解法二：前缀和+哈希 两数之和
	 * 解题思路：
	 *       1、记录数组中每个位置的前缀和
	 *       2、使用哈希表 分别登记每个位置期望的余数值  并判断该位置是否满足了其它位置的要求(两数之和)
	 *       3、如果整个串对p的余数为A，位置为i处的前缀和对p的余数为B，那么该位置期望的余数是：(A+B)%p
	 */
	private int minSubarray1(int[] nums, int p) {
		int N = nums.length;
		// 记录位置为i时，由0->i的前缀和对p的余数
		int[] prefixSum = new int[N];
		int sum = 0;
		for(int i = 0; i < N; i ++) {
			sum += nums[i] % p;
			sum %= p;
			prefixSum[i] = sum;
		}
		
		// 整个数组的余数为sum(当然也等于prefixSum[N-1])
		// 余数为0  不必移除  整个串满足
		if(sum == 0) {
			return 0;
		}
		// 最终结果不超过N  定义N作为边界值
		int ans = N;
		// 这个map的key和value  表示索引值为value的位置，期望遇到前缀和对p取余的余数为key
		// 有点像两数之和 每个位置将自己的期望值记录在map中，并判断自己这个位置处的余数是否满足了其它位置的要求
		Map<Integer, Integer> record = new HashMap<>();
		// 在遍历之前，因为已经知道了整个串的余数为sum，那么闲提一次要求吧！
		record.put(sum, -1);
		for(int i = 0; i < N; i ++) {
			// 位置i处的余数
			int cur = prefixSum[i];
			// 该位置处  期望的余数
			int target = (cur + sum) % p;
			// 1、记录自己的要求 将当前位置的期望值和位置存入
			record.put(target, i);
			// 2、判断是否符合别人的要求
			if(record.containsKey(cur)) {
				int size = i - record.get(cur);
				ans = Math.min(ans, size);
				record.remove(cur);
			}
		}
		if(ans != N) {
			return ans;
		}
		return -1;
	}

}
