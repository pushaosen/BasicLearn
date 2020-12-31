package 力扣算法刷题.队列系列;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 任务调度器 {

	/** 
	 * 题目：给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，
	 *     并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
	 *     然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，
	 *     或者在待命状态。
	 * 你需要计算完成所有任务所需要的最短时间。
	 */
	
	/** 
	 * 示例：
	 *     输入：tasks = ["A","A","A","B","B","B"], n = 2
	 *     输出：8
	 *     解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
	 *         在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
		int n = 2;
		任务调度器 obj = new 任务调度器();
		System.out.println("模拟解法的结果为：" + obj.leastInterval(tasks, n));
		System.out.println("构造解法的结果为：" + obj.leastInterval1(tasks, n));
	}
	
	/**
	 * 解法一：模拟
	 * 时间复杂度：O(∣tasks∣⋅∣Σ∣)，其中∣Σ∣是数组task中出现任务的种类，在本题中任务用大写字母表示，因此∣Σ∣不会超过26，在对
	 *         time的更新进行优化后，每一次遍历中我们都可以安排一个任务，因此会进行|tasks|次遍历，每次遍历的时间复杂度
	 *         为O(∣Σ∣)，相乘即可以得到总时间复杂度。
	 * 空间复杂度：O(∣Σ∣)
	 */
	public int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> freq = new HashMap<Character, Integer>();
		// 先将所有的任务放进一个对象中，可以起到去重的作用，和统计出一个任务被执行的次数
		for(char ch : tasks) {
			freq.put(ch, freq.getOrDefault(ch, 0) + 1);
		}
		
		// 任务总数
		int m = freq.size();
		List<Integer> nextValid = new ArrayList<Integer>();
		List<Integer> rest = new ArrayList<>();
		Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
		for(Map.Entry<Character, Integer> entry : entrySet) {
			int value = entry.getValue();
			nextValid.add(1);
			rest.add(value);
		}
		
		int time = 0;
		for(int i = 0; i < tasks.length; i ++) {
			++ time;
			int minNextValid = Integer.MAX_VALUE;
			for(int j = 0; j < m; ++ j) {
				if(rest.get(j) != 0) {
					minNextValid = Math.min(minNextValid, nextValid.get(j));
				}
			}
			time = Math.max(time, minNextValid);
			int best = -1;
			for(int j = 0; j < m; ++ j) {
				if(rest.get(j) != 0 && nextValid.get(j) <= time) {
					if(best == -1 || rest.get(j) > rest.get(best)) {
						best = j;
					}
				}
			}
			nextValid.set(best, time + n + 1);
			rest.set(best, rest.get(best) - 1);
		}
		return time;
	}
	
	/** 
	 * 解法二：构造
	 * 时间复杂度：O(∣tasks∣⋅∣Σ∣)
	 * 空间复杂度：∣Σ∣
	 */
	public int leastInterval1(char[] tasks, int n) {
		Map<Character, Integer> freq = new HashMap<>();
		// 最多的执行次数
		int maxExec = 0;
		for(char ch : tasks) {
			int exec = freq.getOrDefault(ch, 0) + 1;
			freq.put(ch, exec);
			maxExec = Math.max(maxExec, exec);
		}
		
		// 具有最多执行次数的任务数量
		int maxCount = 0;
		Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
		for(Map.Entry<Character, Integer> entry : entrySet) {
			int value = entry.getValue();
			if(value == maxExec) {
				++ maxCount;
			}
		}
		
		return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
	}
}
