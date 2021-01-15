package �����㷨ˢ��.˫ָ��ϵ��;

import java.util.Arrays;

public class �ϲ������������� {
	
	/** 
	 * ��Ŀ���������������������� nums1 �� nums2�����㽫 nums2 �ϲ��� nums1 �У�ʹ nums1�Ƴ�Ϊһ����������
	 * 
	 *     ��ʼ��nums1 �� nums2 ��Ԫ�������ֱ�Ϊ m �� n ������Լ��� nums1 ���㹻�Ŀռ䣨�ռ��С���� m + n�������� nums2 �е�Ԫ��
	 */
	
	/** 
	 * ʾ����
	 *    ���룺nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
	 *    �����[1,2,2,3,5,6]
	 *    
	 *    ���룺nums1 = [1], m = 1, nums2 = [], n = 0
	 *    �����[1]
	 */
	
	/** 
	 * �ⷨһ���ϲ�������
	 * ����˼·��
	 *       �����صĽⷨ���ǽ���������ϲ�֮�������򡣸��㷨ֻ��Ҫһ��(Java��2��)��ʱ�临�ӶȽϲΪO((n+m)log(n+m))�������������ַ���û�������������鱾���Ѿ�������һ�㡣
	 *       
	 * ʱ�临�Ӷȣ�O((n+m)log(n+m))
	 * �ռ临�Ӷȣ�O(1)
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		System.arraycopy(nums2, 0, nums1, m, n);
		Arrays.sort(nums1);
	}
	
	/** 
	 * �ⷨ����˫ָ�� / ��ǰ����
	 * ʱ�临�Ӷȣ�O(n+m)
	 * �ռ临�Ӷȣ�O(m)
	 */
	public void merge1(int[] nums1, int m, int[] nums2, int n) {
		int[] nums1_copy = new int[m];
		System.arraycopy(nums1, 0, nums1_copy, 0, m);
		
		int p1 = 0;
		int p2 = 0;
		
		int p = 0;
		
		while((p1 < m) && (p2 < n)) {
			nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
		}
		
		if(p1 < m) {
			System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
		}
		
		if(p2 < n) {
			System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
		}
	}
	
	/** 
	 * �ⷨ����˫ָ�� / �Ӻ���ǰ
	 * ʱ�临�Ӷȣ�O(m+n)
	 * �ռ临�Ӷȣ�O(1)
	 */
	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m - 1;
		int p2 = n - 1;
		
		int p = m + n -1;
		
		while((p1 >= 0) && (p2 >= 0)) {
			nums1[p --] = (nums1[p1] < nums2[p2]) ? nums2[p2 --] : nums1[p1 --];
		}
		System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
	}

}
