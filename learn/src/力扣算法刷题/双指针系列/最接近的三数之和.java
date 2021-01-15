package 力扣算法刷题.双指针系列;

import java.util.Arrays;

public class 最接近的三数之和 {
	
	/** 
	 * 题目：给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整
	 *     数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
	 */
	
	/** 
	 * 示例：
	 *    输入：nums = [-1,2,1,-4], target = 1
	 *    输出：2
	 *    解释：与target最接近的和是 2(-1 + 2 + 1 = 2)。
	 */
	
	/** 
	 * 测试：
	 */
	public static void main(String[] args) {
		int[] nums = {-1,2,1,-4};
		int target = 1;
		最接近的三数之和 obj = new 最接近的三数之和();
		System.out.println("排序+双指针的解法的结果为：" + obj.threeSumClosest(nums, target));
	}
	
	/** 
	 * 解法一：排序+双指针
	 */
	public int threeSumClosest(int[] nums, int target) {
		// 先进行一个排序
		Arrays.sort(nums);
		int n = nums.length;
		int best = 10000000;
		
		// 枚举a
		for(int i = 0; i < n; i ++) {
			// 保证和上一次枚举的元素不相等
			if(i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			// 使用双指针枚举b和c
			int j = i + 1, k = n - 1;
			while(j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				// 如果和为target，直接返回答案
				if(sum == target) {
					return target;
				}
				// 根据差值的绝对值来更新答案
				if(Math.abs(sum - target) < Math.abs(best - target)) {
					best = sum;
				}
				if(sum > target) {
					// 如果和大于target，移动c对应的指针
					int k0 = k - 1;
					// 移动到下一个不相等的元素
					while(j < k0 && nums[k0] == nums[k]) {
						-- k0;
					}
					k = k0;
				}else {
					// 如果和小于target，移动b对应的指针
					int j0 = j + 1;
					// 移动到下一个不相等的元素
					while(j0 < k && nums[j0] == nums[j]) {
						++ j0;
					}
					j = j0;
				}
			}
		}
		return best;
	}

}
