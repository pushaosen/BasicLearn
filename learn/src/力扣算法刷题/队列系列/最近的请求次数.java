package 力扣算法刷题.队列系列;

import java.util.LinkedList;
import java.util.Queue;

public class 最近的请求次数 {
	
	/** 
	 * 题目：写一个 RecentCounter 类来计算特定时间范围内最近的请求。
	 * 请你实现一个类：
	 *     RecentCounter() 初始化计数器，请求数为 0 。
	 *     int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所
	 *     有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
	 *     
	 * 保证：每次对 ping 的调用都使用比之前更大的 t。
	 */
	
	/** 
	 * 示例：
	 *     输入：["RecentCounter", "ping", "ping", "ping", "ping"]
	 *         [[], [1], [100], [3001], [3002]]
	 *     输出：[null, 1, 2, 3, 3]
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		
	}
	
	/** 
	 * 解法一：使用队列
	 * 时间复杂度：O(Q)，其中Q是ping的次数
	 * 空间复杂度：O(W)，其中W=3000是队列中最多存储的 ping 的记录数目。
	 */
	private Queue<Integer> queue = new LinkedList<>();
	public int ping(int t) {
		queue.add(t);
		while(queue.peek() < t - 3000) {
			queue.poll();
		}
		return queue.size();
	}

}
