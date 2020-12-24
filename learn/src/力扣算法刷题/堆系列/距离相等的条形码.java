package 力扣算法刷题.堆系列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class 距离相等的条形码 {
	/** 
	 * 题目：在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
	 *     请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返
	 *     回任何满足该要求的答案，此题保证存在答案。
	 */
	
	/** 
	 * 示例1：
	 *      输入：[1,1,1,2,2,2]
	 *      输出：[2,1,2,1,2,1]
	 *      
	 * 示例2：
	 *      输入：[1,1,1,1,2,2,3,3]
	 *      输出：[1,3,1,3,2,1,2,1]
	 */
	
	/**
	 * 测试运行结果：
	 */
	public static void main(String[] args) {
		距离相等的条形码 obj = new 距离相等的条形码();
		int[] barcodes = {1,1,1,2,2,2};
		int[] result = obj.rearrangeBarcodes(barcodes);
		System.out.println("使用map集合排序解决问题的结果为：" + result);
		int[] barcodes1 = {1,1,1,1,2,2,3,3};
		result = obj.rearrangeBarcodes(barcodes1);
		System.out.println("使用map集合排序解决问题的结果为：" + result);
	}
	
	/** 
	 * 解法一：使用map集合排序解决问题
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
		// 遍历经过排序后的集合
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
