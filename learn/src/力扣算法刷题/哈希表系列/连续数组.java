package �����㷨ˢ��.��ϣ��ϵ��;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class �������� {
	
	/** 
	 * ��Ŀ������һ������������, �ҵ�������ͬ������ 0 �� 1 ������������飨�ĳ��ȣ���
	 */
	
	/** 
	 * ʾ����
	 *    ���룺[0,1]
	 *    �����2
	 *    ���ͣ�[0, 1] �Ǿ�����ͬ����0��1�������������
	 *    
	 *    ���룺[0,1,0]
	 *    �����2
	 *    ���ͣ�[0, 1] (�� [1, 0]) �Ǿ�����ͬ����0��1������������顣
	 */
	
	/** 
	 * ���ԣ�
	 */
	public static void main(String[] args) {
		��������  obj = new ��������();
		int[] nums = {0, 1, 0};
		System.out.println("�ⷨ��ϣ��Ľ��Ϊ��" + obj.findMaxLength(nums));
		System.out.println("ʹ������Ľ��Ϊ��" + obj.findMaxLength1(nums));
		System.out.println("ʹ�ñ����ⷨ�Ľ��Ϊ��" + obj.findMaxLength2(nums));
	}
	
	/** 
	 * �ⷨһ��ʹ�ù�ϣ��(���Խ���)
	 * ʱ�临�Ӷȣ�O(n)�������������һ��
	 * �ռ临�Ӷȣ�O(n)��HashMap  map���ʹ�ÿռ�Ϊn�����ҽ�������Ԫ�ض���1����0
	 */
	private int findMaxLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int maxLen = 0, count = 0;
		for(int i = 0; i < nums.length; i ++) {
			count = count + (nums[i] == 1 ? 1 : -1);
			if(map.containsKey(count)) {
				maxLen = Math.max(maxLen, i - map.get(count));
			}else {
				map.put(count, i);
			}
		}
		return maxLen;
	}
	
	/** 
	 * �ⷨ����ʹ�ö��������(���Խ���)
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)��arr�����СΪ2n+1
	 */
	private int findMaxLength1(int[] nums) {
		int[] arr = new int[2 * nums.length + 1];
		Arrays.fill(arr, -2);
		arr[nums.length] = -1;
		int maxLen = 0, count = 0;
		for(int i = 0; i < nums.length; i ++) {
			count = count + (nums[i] == 0 ? -1 : 1);
			if(arr[count + nums.length] >= -1) {
				maxLen = Math.max(maxLen, i - arr[count + nums.length]);
			}else {
				arr[count + nums.length] = i;
			}
		}
		return maxLen;
	}
	
	/** 
	 * �ⷨ���������ⷨ(��ʱ)
	 * ʱ�临�Ӷȣ�O(n*n)
	 * �ռ临�Ӷȣ�O(1)
	 */
	private int findMaxLength2(int[] nums) {
		int maxLen = 0;
		for(int start = 0; start < nums.length; start ++) {
			int zeroes = 0, ones = 0;
			for(int end = start; end < nums.length; end ++) {
				if(nums[end] == 0) {
					zeroes ++;
				}else {
					ones ++;
				}
				if(zeroes == ones) {
					maxLen = Math.max(maxLen, end - start + 1);
				}
			}
		}
		return maxLen;
	}

}
