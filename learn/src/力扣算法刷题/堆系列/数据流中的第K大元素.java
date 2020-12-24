package 力扣算法刷题.堆系列;

import java.util.PriorityQueue;

public class 数据流中的第K大元素 {
	
	/**
	 * 题目：设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k
	 *     大元素，不是第 k 个不同的元素。
	 *     
	 *     请实现 KthLargest 类：
	 *         1、KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
	 *         2、int add(int val) 返回当前数据流中第 k 大的元素。
	 */
	
	/**
	 * 示例：
	 *     输入：["KthLargest", "add", "add", "add", "add", "add"]
	 *         [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
	 *     输出：[null, 4, 5, 5, 8, 8]
	 */
	
	/** 
	 * 解法一：使用最小堆来实现（使用内置优先级队列PriorityQueue）
	 * 关于PriorityQueue：
	 *                  1、是线程不安全的队列
	 *                  2、存储使用数组实现
	 *                  3、利用比较器做优先级比较
	 */
	private PriorityQueue<Integer> queue;
	private int limit;
	public 数据流中的第K大元素(int k, int[] nums) {
		this.limit = k;
		this.queue = new PriorityQueue<>(k);
		for(int num : nums) {
			add(num);
		}
	}
	private int add(int num) {
		if(queue.size() < limit) {
			queue.add(num);
		}else if(num > queue.peek()) {
			queue.poll();
			queue.add(num);
		}
		return queue.peek();
	}
	
	public static void main(String[] args) {
		int k = 3;
		int[] arr = new int[] { 4, 5, 8, 2 };
		数据流中的第K大元素 obj = new 数据流中的第K大元素(k, arr);
		System.out.println("返回的结果为：" + obj.add(3));
	}
}
