package 力扣算法刷题.哈希表系列;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 连续数组 {
	
	/** 
	 * 题目：给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
	 */
	
	/** 
	 * 示例：
	 *    输入：[0,1]
	 *    输出：2
	 *    解释：[0, 1] 是具有相同数量0和1的最长连续子数组
	 *    
	 *    输入：[0,1,0]
	 *    输出：2
	 *    解释：[0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
	 */
	
	/** 
	 * 测试：
	 */
	public static void main(String[] args) {
		连续数组  obj = new 连续数组();
		int[] nums = {0, 1, 0};
		System.out.println("解法哈希表的结果为：" + obj.findMaxLength(nums));
		System.out.println("使用数组的结果为：" + obj.findMaxLength1(nums));
		System.out.println("使用暴力解法的结果为：" + obj.findMaxLength2(nums));
	}
	
	/** 
	 * 解法一：使用哈希表(可以接受)
	 * 时间复杂度：O(n)，整个数组遍历一遍
	 * 空间复杂度：O(n)，HashMap  map最大使用空间为n，当且仅当所有元素都是1或者0
	 */
	private int findMaxLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int maxLen = 0, count = 0;
		for(int i = 0; i < nums.length; i ++) {
			count = count + (nums[i] == 1 ? 1 : -1);
			if(map.containsKey(count)) {
				maxLen = Math.max(maxLen, i - map.get(count));
			}else {
				map.put(count, i);
			}
		}
		return maxLen;
	}
	
	/** 
	 * 解法二：使用额外的数组(可以接受)
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)，arr数组大小为2n+1
	 */
	private int findMaxLength1(int[] nums) {
		int[] arr = new int[2 * nums.length + 1];
		Arrays.fill(arr, -2);
		arr[nums.length] = -1;
		int maxLen = 0, count = 0;
		for(int i = 0; i < nums.length; i ++) {
			count = count + (nums[i] == 0 ? -1 : 1);
			if(arr[count + nums.length] >= -1) {
				maxLen = Math.max(maxLen, i - arr[count + nums.length]);
			}else {
				arr[count + nums.length] = i;
			}
		}
		return maxLen;
	}
	
	/** 
	 * 解法三：暴力解法(超时)
	 * 时间复杂度：O(n*n)
	 * 空间复杂度：O(1)
	 */
	private int findMaxLength2(int[] nums) {
		int maxLen = 0;
		for(int start = 0; start < nums.length; start ++) {
			int zeroes = 0, ones = 0;
			for(int end = start; end < nums.length; end ++) {
				if(nums[end] == 0) {
					zeroes ++;
				}else {
					ones ++;
				}
				if(zeroes == ones) {
					maxLen = Math.max(maxLen, end - start + 1);
				}
			}
		}
		return maxLen;
	}

}
