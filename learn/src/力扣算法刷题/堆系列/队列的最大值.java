package 力扣算法刷题.堆系列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 队列的最大值 {
	
	/** 
	 * 题目：请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数
	 *     max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
	 *     
	 *     若队列为空，pop_front 和 max_value 需要返回 -1
	 */
	
	/** 
	 * 示例：
	 *     输入：["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
	 *         [[],[1],[2],[],[],[]]
	 *     输出：[null,null,null,2,1,2]
	 */
	
	/** 
	 * 解法一：暴力解法
	 * 时间复杂度：O(1)，最坏情况下为：O(n)
	 * 空间复杂度：O(n)，需要用队列存储所有插入的元素。
	 */
	int[] q = new int[20000];
	int begin = 0, end = 0;
	public int max_value() {
		int ans = -1;
		for(int i = begin; i != end; ++ i) {
			ans = Math.max(ans, q[i]);
		}
		return ans;
	}
	
	public void push_back(int value) {
		q[end ++] = value;
	}
	
	public int pop_front() {
		if(begin == end) {
			return -1;
		}
		return q[begin ++];
	}
	
	/** 
	 * 解法二：维护一个单调的双端队列
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(n)，需要用队列存储所有插入的元素
	 */
	Queue<Integer> q1 = new LinkedList<Integer>();
	Deque<Integer> d = new LinkedList<Integer>();
	public int max_value1() {
		if(d.isEmpty()) {
			return -1;
		}
		return d.peekFirst();
	}
	public void push_back1(int value) {
		while(!d.isEmpty() && d.peekLast() < value) {
			d.pollLast();
		}
		d.offerLast(value);
		q1.offer(value);
	}
	public int pop_front1() {
		if(q1.isEmpty()) {
			return -1;
		}
		int ans = q1.poll();
		if(ans == d.peekFirst()) {
			d.pollFirst();
		}
		return ans;
	}
}
