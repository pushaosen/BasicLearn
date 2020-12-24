package �����㷨ˢ��.��ϵ��;

import java.util.Collections;
import java.util.PriorityQueue;

public class �������е���λ�� {

	/** 
	 * ��Ŀ����εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
	 *     ������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
	 */
	
	/** 
	 * ʾ����
	 *     ���룺["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
	 *         [[],[1],[2],[],[3],[]]
	 *     �����[null,null,null,1.50000,null,2.00000]
	 */
	
	/** 
	 * �ⷨһ��ʹ��˫�ѣ�����С�ѵ�˼��(���ȶ���)
	 * 1��������鳤��Ϊ��������λ�������м���Ǹ����������Ϊż�����м�ƫ����Ǹ�Ԫ��
	 * 2��ʹ���������洢���ڻ�С����λ����ֵ��ֻ��pollһ�ξͿɵ�����ǰ����λ����ʹ����С�����洢������λ����ֵ
	 * 3��������Ҫ����������ƽ�⣬��Ϊ����Ҫ�����λ�����������ѵĴ�Сʼ�յ��ڻ����С�ѵĴ�С��1��
	 *   ����ƽ��ͺá�
	 */
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	private PriorityQueue<Integer> minHeap  = new PriorityQueue<>();
	public void addNum(int num) {
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
		// �����ƽ�������
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
