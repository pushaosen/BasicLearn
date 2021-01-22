package 力扣算法刷题.哈希表系列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class 数对和 {
	
	/** 
	 * 题目：设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		数对和  obj = new 数对和();
		int[] nums = {5,6,5,6};
		int target = 11;
		List<List<Integer>> result = obj.pairSums(nums, target);
		System.out.println("双指针的解法的结果为：" + result.toString());
	}
	
	/** 
	 * 示例：
	 *    输入：nums = [5,6,5], target = 11
	 *    输出：[[5,6]]
	 *    
	 *    输入：nums = [5,6,5,6], target = 11
	 *    输出：[[5,6],[6,5]]
	 */
	
	/** 
	 * 解法一：双指针
	 */
	private List<List<Integer>> pairSums(int[] nums, int target){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		// 排序
		Arrays.sort(nums);
		// 头尾指针
		int i = 0, j = nums.length - 1;
		while(i < j) {
			int sum = nums[i] + nums[j];
			if(sum == target) {   // 1、刚好相等，两个指针都往中间走
				list.add(Arrays.asList(nums[i], nums[j]));
				i ++;
				j --;
			}else if(target > sum) {   // 2、两数之和太小，左指针右移，让和变大
				i++;
			}else {      // 3、两数之和太大，右指针左移，让和变小
				j --;
			}
		}
		return list;
	}
	
	/** 
	 * 解法二：哈希表
	 * 解题思路：1、先通过一个Map存储数据出现的次数
	 *        2、通过判断是否存在与之相加达到k的数据
	 *        3、统计结果
	 */
	private List<List<Integer>> pairSums1(int[] nums, int target){
		List<List<Integer>> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		// 统计每个数据出现的次数，key为数据，value为次数
		for(int num : nums) {
			Integer i = map.getOrDefault(num, 0);
			map.put(num, i + 1);
		}
		for(int num : nums) {
			// 求和达到k的数据
			int x = target - num;
			// 从map获取x
			int i = map.get(num);
			// 如果次数想小于等于0，说明数据被使用过了【就算后面遍历到，也可以跳过了】
			if(i <= 0) {
				continue;
			}
			// 统计数量减一，先减去，防止两个相同的数据相加达到k，而只有一个数据
			map.put(num, i - 1);
			// 是否有另一个数据，且统计的数量大于0
			if(map.containsKey(x) && map.get(x) > 0) {
				list.add(Arrays.asList(num, x));
				map.put(x, map.get(num) - 1);    // 数量减1
			}
		}
		return list;
	}

}
