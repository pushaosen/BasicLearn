package �����㷨ˢ��.˫ָ��ϵ��;

import java.util.Arrays;

public class ��С�� {
	
	/** 
	 * ��Ŀ������������������ a��b�����������С�����ֵ��һ����ֵ(ÿ��������ȡһ��ֵ)��
	 *     �����ظö���ֵ�Ĳ�
	 */
	
	/** 
	 * ʾ����
	 *    ���룺{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
	 *    �����3������ֵ��(11, 8)
	 */
	
	/** 
	 * ���ԣ�
	 */
	public static void main(String[] args) {
		��С�� obj = new ��С��();
		int[] a = {1, 3, 15, 11, 2};
		int[] b = {23, 127, 235, 19, 8};
		System.out.println("˫ָ��ⷨ�Ľ��Ϊ��" + obj.smallestDifference(a, b));
	}
	
	/** 
	 * �ⷨһ��˫ָ��+���Abs�������
	 */
	public int smallestDifference(int[] a, int[] b) {
		if(a == null || b == null || a.length == 0 || b.length == 0) {
			return -1;
		}
		int minDiff = Integer.MIN_VALUE, aIdx = 0, bIdx = 0;
		// �ȶ����������������
		Arrays.sort(a);
		Arrays.sort(b);
		while(aIdx < a.length && bIdx < b.length) {
			// �ؼ�����������������  ����������
			minDiff = Math.max(minDiff, -Math.abs(a[aIdx] - b[bIdx]));
			
			if(a[aIdx] < b[bIdx]) {
				aIdx ++;
			}else {
				bIdx ++;
			}
		}
		// ����
		return Math.abs(minDiff);
	}

}
