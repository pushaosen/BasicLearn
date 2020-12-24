package 力扣算法刷题.堆系列;

import java.util.PriorityQueue;

public class 最后一块石头的重量 {

	/** 
	 * 题目：有一堆石头，每块石头的重量都是正整数。
	 *     每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的
	 *     重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
	 *        如果 x == y，那么两块石头都会被完全粉碎；
	 *        如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x
	 *     最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回0。
	 */
	
	/** 
	 * 示例：
	 *     输入：[2,7,4,1,8,1]
	 *     输出：1
	 *     解释：
	 *         先选出7和8，得到1，所以数组转换为：[2,4,1,1,1]，
	 *         再选出2和4，得到2，所以数组转换为：[2,1,1,1]，
	 *         接着是2和1，得到1，所以数组转换为：[1,1,1]，
	 *         最后选出1和1，得到0，最终数组转换为：[1]，这就是最后剩下的那块石头的重量。
	 */
	
	public static void main(String[] args) {
		最后一块石头的重量 obj = new 最后一块石头的重量();
		int[] stones = {2,7,4,1,8,1};
		System.out.println("使用优先队列解法的结果为：" + obj.lastStoneWeight(stones));
	}
	
	/** 
	 * 解法一：使用优先队列
	 * 分析：由于需要动态维护数组的有序性(支持增加、删除)，这里使用优先队列是最合适的数据结构。
	 * 时间复杂度：O(NlogN)
	 * 空间复杂度：O(N)，优先队列的大小
	 */
	public int lastStoneWeight(int[] stones) {
		int len = stones.length;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (o1, o2) -> -o1 + o2);;
		// 先把所有石头放进优先队列中
		for(int stone : stones) {
			maxHeap.add(stone);
		}
		
		while(maxHeap.size() > 2) {
			Integer head1 = maxHeap.poll();
			Integer head2 = maxHeap.poll();
			if(head1.equals(head2)) {
				continue;
			}
			maxHeap.offer(head1 - head2);
		}
		
		if(maxHeap.isEmpty()) {
			return 0;
		}
		return maxHeap.poll();
	}
}
