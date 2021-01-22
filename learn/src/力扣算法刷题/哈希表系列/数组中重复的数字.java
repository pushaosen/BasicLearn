package 力扣算法刷题.哈希表系列;

import java.util.HashSet;
import java.util.Set;

public class 数组中重复的数字 {
	
	/** 
	 * 题目：找出数组中重复的数字。
	 *     
	 *     在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
	 *     也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
	 */
	
	/** 
	 * 示例：
	 *    输入：[2, 3, 1, 0, 2, 5, 3]
	 *    输出：2 或 3
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 0, 2, 5, 3};
		数组中重复的数字 obj = new 数组中重复的数字();
		System.out.println("遍历数组解法的结果为：" + obj.findRepeatNumber(nums));
	}
	
	/** 
	 * 解法一：遍历数组
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 */
	public int findRepeatNumber(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		int repeat = -1;
		for(int num : nums) {
			if(!set.add(num)) {
				repeat = num;
				break;
			}
		}
		return repeat;
	}

}
