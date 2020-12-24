package �����㷨ˢ��.��ϵ��;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ������ȵ������� {
	/** 
	 * ��Ŀ����һ���ֿ����һ�������룬���е� i ��������Ϊ barcodes[i]��
	 *     ��������������Щ�����룬ʹ�����������ڵ������� ���� ��ȡ� ����Է�
	 *     ���κ������Ҫ��Ĵ𰸣����Ᵽ֤���ڴ𰸡�
	 */
	
	/** 
	 * ʾ��1��
	 *      ���룺[1,1,1,2,2,2]
	 *      �����[2,1,2,1,2,1]
	 *      
	 * ʾ��2��
	 *      ���룺[1,1,1,1,2,2,3,3]
	 *      �����[1,3,1,3,2,1,2,1]
	 */
	
	/**
	 * �������н����
	 */
	public static void main(String[] args) {
		������ȵ������� obj = new ������ȵ�������();
		int[] barcodes = {1,1,1,2,2,2};
		int[] result = obj.rearrangeBarcodes(barcodes);
		System.out.println("ʹ��map��������������Ľ��Ϊ��" + result);
		int[] barcodes1 = {1,1,1,1,2,2,3,3};
		result = obj.rearrangeBarcodes(barcodes1);
		System.out.println("ʹ��map��������������Ľ��Ϊ��" + result);
	}
	
	/** 
	 * �ⷨһ��ʹ��map��������������
	 */
	public int[] rearrangeBarcodes(int[] barcodes) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < barcodes.length; i ++) {
			int num = map.getOrDefault(barcodes[i], 0) + 1;
			map.put(barcodes[i], num);
		}
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		int[][] str = new int[map.size()][2];
		int j = 0;
		// �������������ļ���
		for(Map.Entry<Integer, Integer> mapping : list) {
			str[j][0] = mapping.getKey();
			str[j][1] = mapping.getValue();
			j ++;
		}
		int[] nn = new int[barcodes.length];
		int k = 1;
		for(int i = 0; i < str.length; i ++) {
			while(str[i][1] != 0) {
				if(k >= barcodes.length) {
					k  =0;
				}
				nn[k] = str[i][0];
				k += 2;
				str[i][1] --;
			}
		}
		return nn;
	}
}
