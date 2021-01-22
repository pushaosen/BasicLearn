package 力扣算法刷题.哈希表系列;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 独一无二的出现次数 {
	
	/** 
	 * 题目：给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
	 *     如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
	 */
	
	/** 
	 * 示例：
	 *    输入：arr = [1,2,2,1,1,3]
	 *    输出：true
	 *    解释：在该数组中，1出现了3次，2出现了2次，3只出现了1次，没有两个数的出现次数相同
	 *    
	 *    输入：arr=[1,2]
	 *    输出：false
	 *    
	 *    输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
	 *    输出：true
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		独一无二的出现次数  obj = new 独一无二的出现次数();
		int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};
		System.out.println("哈希表解法的结果为：" + obj.uniqueOccurrences(arr));
	}
	
	/**
	 * 解法一：哈希表
	 * 时间复杂度：O(N)
	 * 空间复杂度：O(N)
	 */
	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> occur = new HashMap<Integer, Integer>();
		for(int x : arr) {
			occur.put(x, occur.getOrDefault(x, 0) + 1);
		}
		Set<Integer> times = new HashSet<Integer>();
		for(Map.Entry<Integer, Integer> x : occur.entrySet()) {
			times.add(x.getValue());
		}
		return times.size() == occur.size();
	}

}
