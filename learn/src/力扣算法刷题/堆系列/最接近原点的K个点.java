package �����㷨ˢ��.��ϵ��;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class ��ӽ�ԭ���K���� {
	
	/**
	 * ��Ŀ��������һ����ƽ���ϵĵ���ɵ��б� points����Ҫ�����ҳ� K ������ԭ��(0, 0)����ĵ㡣
	 *     (���ƽ��������֮��ľ�����ŷ����¾��롣)
	 *     ����԰��κ�˳�򷵻ش𰸡����˵������˳��֮�⣬��ȷ����Ψһ�ġ�
	 */
	
	/** 
	 * ʾ��1��
	 *      ���룺points = [[1,3],[-2,2]], K = 1
	 *      �����[[2,-2]]
	 *      ���ͣ�
	 *          (1,3)��ԭ��֮��ľ���Ϊ sqrt(10)��
	 *          (-2,2)��ԭ��֮��ľ���Ϊ sqrt(8),
	 *          ���� sqrt(8)<sqrt(10)��(-2,2)��ԭ�������
	 *          ����ֻ��Ҫ����ԭ�������k=1���㣬���Դ𰸾���[[-2,2]].
	 */
	
	/** 
	 * ʾ��2��
	 *      ���룺points = [[3,3],[5,-1],[-2,4]], K = 2
	 *      �����[[3,3],[-2,4]]
	 *      (��[[-2,4],[3,3]] Ҳ�ᱻ����)
	 */
	
	/**
	 * ���Խ��
	 */
	public static void main(String[] args) {
		��ӽ�ԭ���K���� obj = new ��ӽ�ԭ���K����();
		int[][] points = {{1,3},{-2,2}};
		int K = 1;
		int[][] result = obj.kClosest(points, K);
		System.out.println("����ⷨ�Ľ��Ϊ��" + result);
		result = obj.kClosest1(points, K);
		System.out.println("���ȶ��нⷨ�Ľ��Ϊ��" + result);
		result = obj.kClosest2(points, K);
		System.out.println("����ѡ��ⷨ�Ľ��Ϊ��" + result);
		int[][] points1 = {{3,3},{5,-1},{-2,4}};
		K = 2;
		result = obj.kClosest(points1, K);
		System.out.println("����ⷨ�Ľ��Ϊ��" + result);
		result = obj.kClosest1(points1, K);
		System.out.println("���ȶ��нⷨ�Ľ��Ϊ��" + result);
		result = obj.kClosest2(points1, K);
		System.out.println("����ѡ��ⷨ�Ľ��Ϊ��" + result);
	}
	
	/** 
	 * �ⷨһ������(�򵥺����)
	 * ˼·���㷨����ÿ���㵽ԭ���ŷ����¾����ƽ����С���������ȡ��ǮK������
	 * ʱ�临�Ӷȣ�O(nlogn)
	 * �ռ临�Ӷȣ�O(logn)
	 */
	public int[][] kClosest(int[][] points, int K){
		// ���Ƚ����������
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] point1, int[] point2) {
				return (point1[0] * point1[0] + point1[1] * point1[1]) 
						- (point2[0] * point2[0] + point2[1] * point2[1]);
			}
		});
		// ��ȡ�����е�ĳ����㵽Ŀ�ĵص�ľ��������
		return Arrays.copyOfRange(points, 0, K);
	}
	
	/**
	 *  �ⷨ�������ȶ���
	 *  ˼·���㷨�����ǿ���ʹ��һ�����ȶ���(�����)ʵʱά��ǰK����С�ľ���ƽ��
	 *  ʱ�临�Ӷȣ�O(nlogK)������n������points�ĳ���
	 *  �ռ临�Ӷȣ�O(K)����Ϊ���ȶ����������K����
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
	 * �ⷨ��������ѡ��(���������˼��)
	 * ˼·���㷨�����������еĻ��ֲ���ÿ��ִ����󣬶��ܽ�����ֳ��������֣�����С�ڵ��ڷֽ�ֵpivot��Ԫ��
	 *         ���ᱻ�ŵ���ಿ�֣�������pivot��Ԫ�ض��ᱻ�ŵ���ಿ�֣�������pivot��Ԫ�ض��ᱻ�ŵ��Ҳಿ�֡�
	 *         ���������ͬ���ǣ��ڱ��������ǿ��Ը���K��pivot�±��λ�ù�ϵ��ֻ�����ֽ����һ���֡�
	 * ʱ�临�Ӷȣ�����ΪO(n)������ΪO(n*n)
	 * �ռ临�Ӷȣ�����ΪO(logn)������ΪO(n)
	 */
	Random random = new Random();
	public int[][] kClosest2(int[][] points, int K){
		int n = points.length;
		random_select(points, 0, n -1, K);
		return Arrays.copyOfRange(points, 0, K);
	}
	// ���ѡ��
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
		// [left, i-1] ��С�ڵ��� pivot, [i+1, right] ������ pivot
		if(k < i - left + 1) {
			random_select(points, left, i - 1, k);
		}else if(k > i - left + 1) {
			random_select(points, i + 1, right, k - (i - left + 1));
		}
	}
	// ����������������
	private void swap(int[][] points, int index1, int index2) {
		int[] temp = points[index1];
		points[index1] = points[index2];
		points[index2] = temp;
	}
}
