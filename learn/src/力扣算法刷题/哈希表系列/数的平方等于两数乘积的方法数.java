package �����㷨ˢ��.��ϣ��ϵ��;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ����ƽ�����������˻��ķ����� {
	
	/** 
	 * ��Ŀ������������������ nums1 �� nums2 �����㷵�ظ������¹����γɵ���Ԫ�����Ŀ������ 1 ������ 2 ����
	 *     ����1����Ԫ��(i,j,k)�����nums1[i]*nums1[i]=nums2[j]*nums2[k]  
	 *          ���� 0 <= i < nums1.length �� 0 <= j < k < nums2.length
	 *     ����2����Ԫ��(i,j,k)�����nums2[i]*nums2[i]=nums1[j]*nums1[k]
	 */
	
	/** 
	 * ʾ����
	 *    ���룺nums1 = [7,4], nums2 = [5,2,8,9]
	 *    �����1
	 *    ���ͣ����� 1��(1,1,2), nums1[1]^2 = nums2[1] * nums2[2] (4^2 = 2 * 8)
	 *    
	 *    ���룺nums1 = [1,1], nums2 = [1,1,1]
	 *    �����9
	 *    
	 *    ���룺nums1 = [7,7,8,3], nums2 = [1,2,9,7]
	 *    �����2
	 *    
	 *    ���룺nums1 = [4,7,9,11,23], nums2 = [3,5,1024,12,18]
	 *    �����0
	 */
	
	/** 
	 * ���ԣ�
	 */
	public static void main(String[] args) {
		int[] nums1 = {7,4};
		int[] nums2 = {5,2,8,9};
		����ƽ�����������˻��ķ�����  obj = new ����ƽ�����������˻��ķ�����();
		System.out.println("��ϣ��ⷨ�Ľ��Ϊ��" + obj.numTriplets(nums1, nums2));
	}
	
	/** 
	 * �ⷨһ����ϣ��
	 * ʱ�临�Ӷȣ�O(mn)
	 * �ռ临�Ӷȣ�O(m+n)
	 */
	private int numTriplets(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> map2 = new HashMap<>();
		for(int num : nums1) {
			int count = map1.getOrDefault(num, 0) + 1;
			map1.put(num, count);
		}
		for(int num : nums2) {
			int count = map2.getOrDefault(num, 0) + 1;
			map2.put(num, count);
		}
		return getTriplets(map1, map2) + getTriplets(map2, map1);
	}
	private int getTriplets(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
		int triplets = 0;
		Set<Integer> set1 = map1.keySet();
		Set<Integer> set2 = map2.keySet();
		for(int num1 : set1) {
			int coun1 = map1.get(num1);
			long square = (long)num1 * num1;
			for(int num2 : set2) {
				if(square % num2 == 0 && square / num2 <= Integer.MAX_VALUE) {
					int num3 = (int)(square / num2);
					if(num2 == num3) {
						int coun2 = map2.get(num2);
						int curTriplets = coun1 * coun2 * (coun2 - 1) / 2;
						triplets += curTriplets;
					}else if(num2 < num3 && set2.contains(num3)) {
						int count2 = map2.get(num2);
						int count3 = map2.get(num3);
						int curTriplets = coun1 * count2 * count3;
						triplets += curTriplets;
					}
				}
			}
		}
		return triplets;
	}

}
