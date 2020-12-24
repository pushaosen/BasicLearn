package �����㷨ˢ��.��ϵ��;

import java.util.PriorityQueue;

public class �������еĵ�K��Ԫ�� {
	
	/**
	 * ��Ŀ�����һ���ҵ��������е� k ��Ԫ�ص��ࣨclass����ע���������ĵ� k
	 *     ��Ԫ�أ����ǵ� k ����ͬ��Ԫ�ء�
	 *     
	 *     ��ʵ�� KthLargest �ࣺ
	 *         1��KthLargest(int k, int[] nums) ʹ������ k �������� nums ��ʼ������
	 *         2��int add(int val) ���ص�ǰ�������е� k ���Ԫ�ء�
	 */
	
	/**
	 * ʾ����
	 *     ���룺["KthLargest", "add", "add", "add", "add", "add"]
	 *         [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
	 *     �����[null, 4, 5, 5, 8, 8]
	 */
	
	/** 
	 * �ⷨһ��ʹ����С����ʵ�֣�ʹ���������ȼ�����PriorityQueue��
	 * ����PriorityQueue��
	 *                  1�����̲߳���ȫ�Ķ���
	 *                  2���洢ʹ������ʵ��
	 *                  3�����ñȽ��������ȼ��Ƚ�
	 */
	private PriorityQueue<Integer> queue;
	private int limit;
	public �������еĵ�K��Ԫ��(int k, int[] nums) {
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
		�������еĵ�K��Ԫ�� obj = new �������еĵ�K��Ԫ��(k, arr);
		System.out.println("���صĽ��Ϊ��" + obj.add(3));
	}
}
