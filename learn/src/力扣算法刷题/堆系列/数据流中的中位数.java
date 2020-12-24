package 力扣算法刷题.堆系列;

import java.util.Collections;
import java.util.PriorityQueue;

public class 数据流中的中位数 {

	/** 
	 * 题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
	 *     如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
	 */
	
	/** 
	 * 示例：
	 *     输入：["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
	 *         [[],[1],[2],[],[3],[]]
	 *     输出：[null,null,null,1.50000,null,2.00000]
	 */
	
	/** 
	 * 解法一：使用双堆：即大小堆的思想(优先队列)
	 * 1、如果数组长度为基数，中位数是最中间的那个，如果长度为偶数是中间偏左的那个元素
	 * 2、使用最大堆来存储等于或小于中位数的值，只需poll一次就可弹出当前的中位数，使用最小堆来存储大于中位数的值
	 * 3、此外需要保持两个堆平衡，因为我们要获得中位数，所以最大堆的大小始终等于或比最小堆的大小大1，
	 *   保持平衡就好。
	 */
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	private PriorityQueue<Integer> minHeap  = new PriorityQueue<>();
	public void addNum(int num) {
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
		// 如果不平衡则调整
		if(minHeap.size() > maxHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
	}
	
	public double findMedian() {
		if(maxHeap.size() == minHeap.size()) {
			return (maxHeap.peek() + minHeap.peek()) * 0.5;
		}
		return maxHeap.peek();
	}
}
