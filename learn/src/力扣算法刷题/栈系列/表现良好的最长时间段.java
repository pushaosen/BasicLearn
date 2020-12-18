package 力扣算法刷题.栈系列;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 表现良好的最长时间段 {
	
	/** 
	 * 题目：给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
	 *     我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」
	 *     
	 *     所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格大于「不劳累的天数」
	 *     
	 *     请你返回「表现良好时间段」的最大长度
	 */

	/** 
	 * 实例：
	 *     输入：hours = [9,9,6,0,6,6,9]
	 *     输出：3
	 *     解释：最长的表现良好的时间段是[9, 9, 6]
	 */
	
	/** 
	 * 解法一：单调栈
	 */
	public int longestWPI(int[] hours) {
		for(int i = 0; i < hours.length; i ++) {
			hours[i] = hours[i] > 8 ? 1 : -1;
		}
		int[] score = new int[hours.length + 1];
		score[0] = 0;
		for(int i = 1; i < score.length; i ++) {
			score[i] = score[i - 1] + hours[i - 1];
		}
		// 递减栈
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < score.length; i ++) {
			if(!stack.empty() && score[stack.peek()] <= score[i]) {
				continue;
			}
			stack.push(i);
		}
		int ans = 0;
		for(int i = score.length - 1; i >= 0; i --) {
			if(score[i] > score[stack.peek()]) {
				ans = Math.max(ans, i - stack.peek());
				stack.pop();
				i ++;
				if(stack.empty()) {
					break;
				}
				continue;
			}
		}
		return ans;
	}
	
	/** 
	 * 解法二：前缀+hash
	 * 简单易用，
	 */
	public int longestWPI1(int[] hours) {
		int[] pre_sum = new int[hours.length + 1];
		pre_sum[0] = 0;
		int res = 0;
		// 初始化前缀和数组 pre_sum[i]表示长度为i的数组的前缀和
		for(int i = 1; i <= hours.length; i ++) {
			pre_sum[i] = pre_sum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
			// 1、考虑[0:i-1]是最长序列  res是满足sum[0:i-1]>0的最长序列长度
			if(pre_sum[i] > 0) {
				res = 1;
			}
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		// 记录第一次出现pre_sum[i]的索引i 即 使得前缀和是pre_sum[i]的最小索引
		for(int i = 0; i < hours.length; i ++) {
			if(pre_sum[i] < 0 && !map.containsKey(pre_sum[i])) {
				map.put(pre_sum[i], i);
			}
		}
		
		/** 
		 * 2、考虑[i:j]是最长序列  此时只需考虑pre_sum[j] <= 0的情况
		 * 在区间[0,j)中找一个i，使sum[i:j]>0且尽可能小。
		 * 推论1：pre_sum[i + 1] < pre_sum[j + 1] <= 0
		 * 推论2：如果存在-(a+1)，那么-a一定存在且-a一定会出现在-(a+1)之前     
		 * 根据推论，pre_sum[i+1]是小于pre_sum[j+1]的最大的负数只能等于pre_sum[j+1]-1
		 */
		for(int j = 0; j < hours.length; j ++) {
			if(pre_sum[j] <= 0 && map.containsKey(pre_sum[j+1]-1)) {
				int i = map.get(pre_sum[j+1] - 1);
				if(i <= j) {
					res = Math.max(j - i + 1, res);
				}
			}
		}
		return res;
	}
	
	/*
	 * 解法三：哈希表记录前缀和索引
	 */
	public int longestWPI2(int[] hours) {
		int sum = 0;
		int res = 0;
		Map<Integer, Integer> sumToIndex = new HashMap<>();
		for(int i = 0; i < hours.length; i ++) {
			int temp = hours[i] > 8 ? 1 : -1;
			sum += temp;
			if(sum > 0) {
				res = i + 1;
			}else {
				if(!sumToIndex.containsKey(sum)) {
					sumToIndex.put(sum, i);
				}
				if(sumToIndex.containsKey(sum - 1)) {
					res = Math.max(res, i - sumToIndex.get(sum - 1));
				}
			}
		}
		return res;
	}
	
	/*
	 * 解法四：暴力法
	 */
	public int longestWPI3(int[] hours) {
		int n = hours.length;
		for(int i = 0; i < n; i ++) {
			hours[i] = hours[i] > 8 ? 1 : -1;
		}
		int res = 0;
		for(int i = 0; i < n; i ++) {
			int count = 0;
			for(int j = i; j < n; j ++) {
				count += hours[j];
				if(count > 0) {
					res = Math.max(res, j - i + 1);
				}
			}
			if(n - i <= res) {
				return res;
			}
		}
		return res;
	}
}
