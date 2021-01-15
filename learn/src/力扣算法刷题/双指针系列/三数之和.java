package 力扣算法刷题.双指针系列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
	
	/** 
	 * 题目：
	 *    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
	 *    
	 * 注意：答案中不可以包含重复的三元组
	 */
	
	/** 
	 * 示例：
	 *    输入：nums = [-1,0,1,2,-1,-4]
	 *    输出：[[-1,-1,2],[-1,0,1]]
	 *    
	 *    输入：nums = []
	 *    输出：[]
	 *    
	 *    输入：nums = [0]
	 *    输出：[]
	 */
	
	/** 
	 * 解法一：排序+双指针
	 * 时间复杂度：O(N*N)，其中N是数组nums的长度
	 * 空间复杂度：O(logN)，我们忽略存储答案的空间，额外的排序的空间复杂度为O(logN)。然而我们修改了输入的数组nums，在实际情况下不一定允许，
	 *         因此可以看成是使用了一个额外的数组存储了nums的副本并进行排序，空间复杂度为O(N)
	 */
	public List<List<Integer>> threeSum(int[] nums){
		int n = nums.length;
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();
		// 枚举a
		for(int first = 0; first < n; ++ first) {
			// 需要和上一次枚举的数不相同
			if(first > 0 && nums[first] == nums[first - 1]) {
				continue;
			}
			// c 对应的指针初始指向数组的最右端
			int third = n - 1;
			int target = -nums[first];
			// 枚举 b
			for(int second = first + 1; second < n; ++ second) {
				// 需要和上一次枚举的数不相同
				if(second > first + 1 && nums[second] == nums[second - 1]) {
					continue;
				}
				// 需要保证b的指针在c的指针的左侧
				while(second < third && nums[second] + nums[third] > target) {
					-- third;
				}
				// 如果指针重合，随着b后序的增加
				// 就不会有满足a+b+c=0 并且b<c的c了，可以退出循环
				if(second == third) {
					break;
				}
				if(nums[second] + nums[third] == target) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[first]);
					list.add(nums[second]);
					list.add(nums[third]);
					ans.add(list);
				}
			}
		}
		return ans;
	}

}
