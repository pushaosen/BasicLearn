package 力扣算法刷题.双指针系列;

import java.util.Arrays;

public class 最小差 {
	
	/** 
	 * 题目：给定两个整数数组 a和b，计算具有最小差绝对值的一对数值(每个数组中取一个值)，
	 *     并返回该对数值的差
	 */
	
	/** 
	 * 示例：
	 *    输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
	 *    输出：3，即数值对(11, 8)
	 */
	
	/** 
	 * 测试：
	 */
	public static void main(String[] args) {
		最小差 obj = new 最小差();
		int[] a = {1, 3, 15, 11, 2};
		int[] b = {23, 127, 235, 19, 8};
		System.out.println("双指针解法的结果为：" + obj.smallestDifference(a, b));
	}
	
	/** 
	 * 解法一：双指针+解决Abs溢出方法
	 */
	public int smallestDifference(int[] a, int[] b) {
		if(a == null || b == null || a.length == 0 || b.length == 0) {
			return -1;
		}
		int minDiff = Integer.MIN_VALUE, aIdx = 0, bIdx = 0;
		// 先对两个数组进行排序
		Arrays.sort(a);
		Arrays.sort(b);
		while(aIdx < a.length && bIdx < b.length) {
			// 关键，解决溢出，负数域  大于正数域
			minDiff = Math.max(minDiff, -Math.abs(a[aIdx] - b[bIdx]));
			
			if(a[aIdx] < b[bIdx]) {
				aIdx ++;
			}else {
				bIdx ++;
			}
		}
		// 反置
		return Math.abs(minDiff);
	}

}
