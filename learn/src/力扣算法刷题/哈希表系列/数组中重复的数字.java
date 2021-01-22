package �����㷨ˢ��.��ϣ��ϵ��;

import java.util.HashSet;
import java.util.Set;

public class �������ظ������� {
	
	/** 
	 * ��Ŀ���ҳ��������ظ������֡�
	 *     
	 *     ��һ������Ϊ n ������ nums ����������ֶ��� 0��n-1 �ķ�Χ�ڡ�������ĳЩ�������ظ��ģ�����֪���м��������ظ��ˣ�
	 *     Ҳ��֪��ÿ�������ظ��˼��Ρ����ҳ�����������һ���ظ������֡�
	 */
	
	/** 
	 * ʾ����
	 *    ���룺[2, 3, 1, 0, 2, 5, 3]
	 *    �����2 �� 3
	 */
	
	/** 
	 * ����
	 */
	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 0, 2, 5, 3};
		�������ظ������� obj = new �������ظ�������();
		System.out.println("��������ⷨ�Ľ��Ϊ��" + obj.findRepeatNumber(nums));
	}
	
	/** 
	 * �ⷨһ����������
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 */
	public int findRepeatNumber(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		int repeat = -1;
		for(int num : nums) {
			if(!set.add(num)) {
				repeat = num;
				break;
			}
		}
		return repeat;
	}

}
