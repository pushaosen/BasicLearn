package �����㷨ˢ��.��ϵ��;

import java.util.HashSet;
import java.util.PriorityQueue;

public class ���� {

	/** 
	 * ��Ŀ����дһ�������ҳ��� n ��������
	 *     ��������������ֻ���� 2, 3, 5 ����������
	 */
	
	/** 
	 * ʾ����
	 *     ���룺n = 10
	 *     �����12
	 *     ���ͣ�1, 2, 3, 4, 5, 6, 8, 9, 10, 12 ��ǰ 10 ��������
	 */
	
	public static void main(String[] args) {
		���� obj = new ����();
		int n = 10;
		System.out.println("ʹ�öѵĽⷨ���Ϊ��" + obj.nums[n - 1]);
		obj.fun();
		System.out.println("��̬�滮�Ľⷨ���Ϊ��" + obj.nums1[n - 1]);
	}
	
	/** 
	 * �ⷨһ��ʹ�ö�
	 */
	private int[] nums = new int[1690];
	public ����() {
		HashSet<Long> seen = new HashSet<>();
		PriorityQueue<Long> heap = new PriorityQueue<>();
		seen.add(1L);
		heap.add(1L);
		
		long currUgly, newUgly;
		int[] primes = new int[] {2, 3, 5};
		for(int i = 0; i < 1690; ++ i) {
			currUgly = heap.poll();
			nums[i] = (int)currUgly;
			for(int j : primes) {
				newUgly = currUgly * j;
				if(!seen.contains(newUgly)) {
					seen.add(newUgly);
					heap.add(newUgly);
				}
			}
		}
	}
//	���� u = new ����();
//	public int nthUglyNumber(int n) {
//		return u.nums[n - 1];
//	}
	
	/** 
	 * �ⷨ������̬�滮
	 * �㷨��˼·��
	 *    1����ʼ������nums ������ָ�� i2��i3��i5
	 *    2��ѭ���������г�����ÿһ����
	 *      ��nums[i2]*2��nums[i3]*3��nums[i5]*5ѡ����С��������ӵ�����nums��
	 *      �������ֶ�Ӧ������ָ����ǰ�ƶ�һ��
	 *    3���������з�������ĳ���
	 * ʱ�临�Ӷȣ�O(1)ʱ������𰸺ʹ�Լ1690X5=8450�ε�Ԥ���������
	 * �ռ临�Ӷȣ������ռ��ñ���1690������
	 */
	public int[] nums1 = new int[1690];
	public void fun() {
		nums1[0] = 1;
		int ugly, i2=0, i3=0, i5 = 0;
		
		for(int i = 1; i < 1690; ++ i) {
			ugly = Math.min(Math.min(nums1[i2] * 2, nums1[i3]*3), nums1[i5] * 5);
			nums1[i] = ugly;
			
			if(ugly == nums1[i2] * 2) {
				++i2;
			}
			if(ugly == nums1[i3]*3) {
				++i3;
			}
			if(ugly == nums1[i5]*5) {
				++ i5;
			}
		}
	}
}
