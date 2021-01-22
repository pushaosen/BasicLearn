package �����㷨ˢ��.��ϣ��ϵ��;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ��һ�޶��ĳ��ִ��� {
	
	/** 
	 * ��Ŀ������һ���������� arr�������æͳ��������ÿ�����ĳ��ִ�����
	 *     ���ÿ�����ĳ��ִ������Ƕ�һ�޶��ģ��ͷ��� true�����򷵻� false��
	 */
	
	/** 
	 * ʾ����
	 *    ���룺arr = [1,2,2,1,1,3]
	 *    �����true
	 *    ���ͣ��ڸ������У�1������3�Σ�2������2�Σ�3ֻ������1�Σ�û���������ĳ��ִ�����ͬ
	 *    
	 *    ���룺arr=[1,2]
	 *    �����false
	 *    
	 *    ���룺arr = [-3,0,1,-3,1,1,1,-3,10,0]
	 *    �����true
	 */
	
	/** 
	 * ����
	 */
	public static void main(String[] args) {
		��һ�޶��ĳ��ִ���  obj = new ��һ�޶��ĳ��ִ���();
		int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};
		System.out.println("��ϣ��ⷨ�Ľ��Ϊ��" + obj.uniqueOccurrences(arr));
	}
	
	/**
	 * �ⷨһ����ϣ��
	 * ʱ�临�Ӷȣ�O(N)
	 * �ռ临�Ӷȣ�O(N)
	 */
	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> occur = new HashMap<Integer, Integer>();
		for(int x : arr) {
			occur.put(x, occur.getOrDefault(x, 0) + 1);
		}
		Set<Integer> times = new HashSet<Integer>();
		for(Map.Entry<Integer, Integer> x : occur.entrySet()) {
			times.add(x.getValue());
		}
		return times.size() == occur.size();
	}

}
