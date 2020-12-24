package 力扣算法刷题.堆系列;

import java.util.HashSet;
import java.util.PriorityQueue;

public class 丑数 {

	/** 
	 * 题目：编写一个程序，找出第 n 个丑数。
	 *     丑数就是质因数只包含 2, 3, 5 的正整数。
	 */
	
	/** 
	 * 示例：
	 *     输入：n = 10
	 *     输出：12
	 *     解释：1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
	 */
	
	public static void main(String[] args) {
		丑数 obj = new 丑数();
		int n = 10;
		System.out.println("使用堆的解法结果为：" + obj.nums[n - 1]);
		obj.fun();
		System.out.println("动态规划的解法结果为：" + obj.nums1[n - 1]);
	}
	
	/** 
	 * 解法一：使用堆
	 */
	private int[] nums = new int[1690];
	public 丑数() {
		HashSet<Long> seen = new HashSet<>();
		PriorityQueue<Long> heap = new PriorityQueue<>();
		seen.add(1L);
		heap.add(1L);
		
		long currUgly, newUgly;
		int[] primes = new int[] {2, 3, 5};
		for(int i = 0; i < 1690; ++ i) {
			currUgly = heap.poll();
			nums[i] = (int)currUgly;
			for(int j : primes) {
				newUgly = currUgly * j;
				if(!seen.contains(newUgly)) {
					seen.add(newUgly);
					heap.add(newUgly);
				}
			}
		}
	}
//	丑数 u = new 丑数();
//	public int nthUglyNumber(int n) {
//		return u.nums[n - 1];
//	}
	
	/** 
	 * 解法二：动态规划
	 * 算法与思路：
	 *    1、初始化数组nums 和三个指针 i2，i3，i5
	 *    2、循环计算所有丑数。每一步：
	 *      在nums[i2]*2，nums[i3]*3和nums[i5]*5选出最小的数字添加到数组nums中
	 *      将该数字对应的因子指针向前移动一步
	 *    3、在数组中返回所需的丑数
	 * 时间复杂度：O(1)时间检索答案和大约1690X5=8450次的预计算操作。
	 * 空间复杂度：常数空间用保存1690个丑数
	 */
	public int[] nums1 = new int[1690];
	public void fun() {
		nums1[0] = 1;
		int ugly, i2=0, i3=0, i5 = 0;
		
		for(int i = 1; i < 1690; ++ i) {
			ugly = Math.min(Math.min(nums1[i2] * 2, nums1[i3]*3), nums1[i5] * 5);
			nums1[i] = ugly;
			
			if(ugly == nums1[i2] * 2) {
				++i2;
			}
			if(ugly == nums1[i3]*3) {
				++i3;
			}
			if(ugly == nums1[i5]*5) {
				++ i5;
			}
		}
	}
}
