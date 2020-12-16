package 力扣算法刷题.栈系列;

import java.util.Stack;

public class 栈之132模式 {

	/** 
	 * 题目：给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义
	 *     为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序
	 *     列时，验证这个序列中是否含有132模式的子序列。
	 *     
	 * 注意：n的值小于15000
	 * 
	 * 示例：
	 *     输入： [1, 2, 3, 4]
	 *     输出：False
	 */
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		System.out.println("栈解法的结果为：" + find132pattern(nums));
		int[] nums1 = {3, 1, 4, 2};
		System.out.println("栈解法的结果为：" + find132pattern(nums1));
	}
	
	/** 
	 * 解法一：栈解法
	 * 时间复杂度：O(N)
	 * 空间复杂度：O(N)
	 */
	public static boolean find132pattern(int[] nums) {
		if(nums.length < 3) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		// 先定义一个放最小值的数组
		int[] min = new int[nums.length];
		// 先给数组初始化一个最小值：即min[0] = nums[0]
		min[0] = nums[0];
		// 依次往最小数组，放比上次的一个的小的数字
		for(int i = 1; i < nums.length; i ++) {
			min[i] = Math.min(min[i-1], nums[i]);
		}
		for(int j = nums.length - 1; j >= 0; j --) {
			if(nums[j] > min[j]) {
				while(!stack.isEmpty() && stack.peek() <= min[j]) {
					stack.pop();
				}
				if(!stack.isEmpty() && stack.peek() < nums[j]) {
					return true;
				}
				stack.push(nums[j]);
			}
		}
		return false;
	}
}
