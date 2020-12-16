package 力扣算法刷题.栈系列;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 每日温度 {
	
	/** 
	 * 题目：请根据每日 气温 列表，重新生成一个列表。
	 * 对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
	 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
	 * 
	 * 例如：给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 
	 * 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
	 */
	
	public static void main(String[] args) {
		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
		int[] result = fun(temperatures);
		int[] dailyTemperaturesResult = dailyTemperatures(temperatures);
		System.out.println("暴力解法的结果为：" + Arrays.asList(result).toString());
		System.out.println("单调栈解法的结果为：" + Arrays.asList(dailyTemperaturesResult).toString());
	}

	/** 
	 * 解法一：暴力解法
	 * 时间复杂度：O(mn)
	 * 空间复杂度：O(m)
	 */
	public static int[] fun(int[] t) {
		int length = t.length;
		int[] ans = new int[length];
		int[] next =new int[101];
		// 先把每个数组初始化为：Integer的最大值
		Arrays.fill(next, Integer.MAX_VALUE);
		for(int i = length - 1; i >= 0; -- i) {
			int warmerIndex  = Integer.MAX_VALUE;
			for(int j = t[i] + 1; j <= 100; ++ j) {
				if(next[j] < warmerIndex) {
					warmerIndex = next[j];
				}
			}
			if(warmerIndex < Integer.MAX_VALUE) {
				ans[i] = warmerIndex - i;
			}
			next[t[i]] = i;
		}
		return ans;
	}
	
	/** 
	 * 解法二：单调栈
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 */
	public static int[] dailyTemperatures(int[] t) {
		int length = t.length;
		int[] ans = new int[length];
		Deque<Integer> stack = new LinkedList<Integer>();
		for(int i = 0; i < length; i ++) {
			int temperature = t[i];
			while(!stack.isEmpty() && temperature > t[stack.peek()]) {
				int prevIndex = stack.pop();
				ans[prevIndex] = i - prevIndex;
			}
			stack.push(i);
		}
		return ans;
	}
	
	
}
