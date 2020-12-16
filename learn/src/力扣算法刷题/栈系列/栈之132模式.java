package �����㷨ˢ��.ջϵ��;

import java.util.Stack;

public class ջ֮132ģʽ {

	/** 
	 * ��Ŀ������һ���������У�a1, a2, ..., an��һ��132ģʽ�������� ai, aj, ak ������
	 *     Ϊ���� i < j < k ʱ��ai < ak < aj�����һ���㷨���������� n �����ֵ���
	 *     ��ʱ����֤����������Ƿ���132ģʽ�������С�
	 *     
	 * ע�⣺n��ֵС��15000
	 * 
	 * ʾ����
	 *     ���룺 [1, 2, 3, 4]
	 *     �����False
	 */
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		System.out.println("ջ�ⷨ�Ľ��Ϊ��" + find132pattern(nums));
		int[] nums1 = {3, 1, 4, 2};
		System.out.println("ջ�ⷨ�Ľ��Ϊ��" + find132pattern(nums1));
	}
	
	/** 
	 * �ⷨһ��ջ�ⷨ
	 * ʱ�临�Ӷȣ�O(N)
	 * �ռ临�Ӷȣ�O(N)
	 */
	public static boolean find132pattern(int[] nums) {
		if(nums.length < 3) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		// �ȶ���һ������Сֵ������
		int[] min = new int[nums.length];
		// �ȸ������ʼ��һ����Сֵ����min[0] = nums[0]
		min[0] = nums[0];
		// ��������С���飬�ű��ϴε�һ����С������
		for(int i = 1; i < nums.length; i ++) {
			min[i] = Math.min(min[i-1], nums[i]);
		}
		for(int j = nums.length - 1; j >= 0; j --) {
			if(nums[j] > min[j]) {
				while(!stack.isEmpty() && stack.peek() <= min[j]) {
					stack.pop();
				}
				if(!stack.isEmpty() && stack.peek() < nums[j]) {
					return true;
				}
				stack.push(nums[j]);
			}
		}
		return false;
	}
}
