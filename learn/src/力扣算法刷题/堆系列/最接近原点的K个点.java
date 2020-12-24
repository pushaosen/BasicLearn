package 力扣算法刷题.堆系列;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class 最接近原点的K个点 {
	
	/**
	 * 题目：我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点(0, 0)最近的点。
	 *     (这里，平面上两点之间的距离是欧几里德距离。)
	 *     你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
	 */
	
	/** 
	 * 示例1：
	 *      输入：points = [[1,3],[-2,2]], K = 1
	 *      输出：[[2,-2]]
	 *      解释：
	 *          (1,3)和原点之间的距离为 sqrt(10)，
	 *          (-2,2)和原点之间的距离为 sqrt(8),
	 *          由于 sqrt(8)<sqrt(10)，(-2,2)离原点更近。
	 *          我们只需要距离原点最近的k=1个点，所以答案就是[[-2,2]].
	 */
	
	/** 
	 * 示例2：
	 *      输入：points = [[3,3],[5,-1],[-2,4]], K = 2
	 *      输出：[[3,3],[-2,4]]
	 *      (答案[[-2,4],[3,3]] 也会被接受)
	 */
	
	/**
	 * 测试结果
	 */
	public static void main(String[] args) {
		最接近原点的K个点 obj = new 最接近原点的K个点();
		int[][] points = {{1,3},{-2,2}};
		int K = 1;
		int[][] result = obj.kClosest(points, K);
		System.out.println("排序解法的结果为：" + result);
		result = obj.kClosest1(points, K);
		System.out.println("优先队列解法的结果为：" + result);
		result = obj.kClosest2(points, K);
		System.out.println("快速选择解法的结果为：" + result);
		int[][] points1 = {{3,3},{5,-1},{-2,4}};
		K = 2;
		result = obj.kClosest(points1, K);
		System.out.println("排序解法的结果为：" + result);
		result = obj.kClosest1(points1, K);
		System.out.println("优先队列解法的结果为：" + result);
		result = obj.kClosest2(points1, K);
		System.out.println("快速选择解法的结果为：" + result);
	}
	
	/** 
	 * 解法一：排序(简单好理解)
	 * 思路和算法：将每个点到原点的欧几里德距离的平方从小到大排序后，取出钱K个即可
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：O(logn)
	 */
	public int[][] kClosest(int[][] points, int K){
		// 首先进行排序操作
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] point1, int[] point2) {
				return (point1[0] * point1[0] + point1[1] * point1[1]) 
						- (point2[0] * point2[0] + point2[1] * point2[1]);
			}
		});
		// 获取数组中的某个起点到目的地点的距离的数据
		return Arrays.copyOfRange(points, 0, K);
	}
	
	/**
	 *  解法二：优先队列
	 *  思路和算法：我们可以使用一个优先队列(大根堆)实时维护前K个最小的距离平方
	 *  时间复杂度：O(nlogK)，其中n是数组points的长度
	 *  空间复杂度：O(K)，因为优先队列中最多有K个点
	 */
	public int[][] kClosest1(int[][] points, int K){
		PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] array1, int[] array2) {
				return array2[0] - array1[0];
			}
		});
		for(int i = 0; i < K; ++ i) {
			priorityQueue.offer(new int[] {points[i][0] * points[i][0]
			     + points[i][1] * points[i][1], i});
		}
		int n = points.length;
		for(int i = K; i < n; ++ i) {
			int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
			if(dist < priorityQueue.peek()[0]) {
				priorityQueue.poll();
				priorityQueue.offer(new int[] {dist, i});
			}
		}
		int[][] ans = new int[K][2];
		for(int i = 0; i < K; ++ i) {
			ans[i] = points[priorityQueue.poll()[1]];
		}
		return ans;
	}
	
	/** 
	 * 解法三：快速选择(快速排序的思想)
	 * 思路和算法：快速排序中的划分操作每次执行完后，都能将数组分成两个部分，其中小于等于分界值pivot的元素
	 *         都会被放到左侧部分，而大于pivot的元素都会被放到左侧部分，而大于pivot的元素都会被放到右侧部分。
	 *         与快速排序不同的是，在本题中我们可以根据K与pivot下标的位置关系，只处理划分结果的一部分。
	 * 时间复杂度：期望为O(n)，最坏情况为O(n*n)
	 * 空间复杂度：期望为O(logn)，最坏情况为O(n)
	 */
	Random random = new Random();
	public int[][] kClosest2(int[][] points, int K){
		int n = points.length;
		random_select(points, 0, n -1, K);
		return Arrays.copyOfRange(points, 0, K);
	}
	// 随机选择
	private void random_select(int[][] points, int left, int right, int k) {
		int pivotId = left + random.nextInt(right - left + 1);
		int pivot = points[pivotId][0] * points[pivotId][0] + 
				points[pivotId][1] * points[pivotId][1];
		swap(points, right, pivotId);
		int i = left - 1;
		for(int j = left; j < right; ++ j) {
			int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
			if(dist <= pivot) {
				++ i;
				swap(points, i, j);
			}
		}
		++ i;
		swap(points, i, right);
		// [left, i-1] 都小于等于 pivot, [i+1, right] 都大于 pivot
		if(k < i - left + 1) {
			random_select(points, left, i - 1, k);
		}else if(k > i - left + 1) {
			random_select(points, i + 1, right, k - (i - left + 1));
		}
	}
	// 进行数据两两交换
	private void swap(int[][] points, int index1, int index2) {
		int[] temp = points[index1];
		points[index1] = points[index2];
		points[index2] = temp;
	}
}
