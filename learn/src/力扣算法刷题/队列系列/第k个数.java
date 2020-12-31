package 力扣算法刷题.队列系列;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class 第k个数 {
	
	/** 
	 * 题目：有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例
	 *     如，前几个数按顺序应该是 1，3，5，7，9，15，21。
	 */
	
	/** 
	 * 示例：
	 *     输入：k = 5
	 *     输出：9
	 */
	
	public static void main(String[] args) {
		第k个数 obj = new 第k个数();
		int k = 5;
		System.out.println("动态规划解法的结果为：" + obj.getKthMagicNumber(k));
		System.out.println("堆解法的结果为：" + obj.getKthMagicNumber1(k));
	}
	
	/** 
	 * 解法一：动态规划
	 * 解题思路：
	 *       1、1没有质因子，1与任何正整数(包括1本身)都是互质
	 *       2、设置1为第一位，dp[0]=1;
	 *       3、初始化三个指针p3、p5、p7
	 *       4、在dp[p3]*3,dp[p5]*5,dp[p7]*7中选取最小数字作为新的数字，并将该数字对应的指针向前移动一步
	 */
	public int getKthMagicNumber(int k) {
		int p3 = 0, p5 = 0, p7 = 0;
		int[] dp = new int[k];
		dp[0] = 1;
		for(int i = 1; i < k; i ++) {
			// 选出最小的数字
			dp[i] = Math.min(dp[p3] * 3, Math.min(dp[p5] * 5, dp[p7] * 7));
			// 将该数字对应的指针向前移动一步
			if(dp[i] == dp[p3] * 3) {
				p3++;
			}
			if(dp[i] == dp[p5] * 5) {
				p5++;
			}
			if(dp[i] == dp[p7] * 7) {
				p7++;
			}
		}
		return dp[k-1];
	}
	
	/** 
	 * 解法二：堆
	 * 解题思路：
	 *       1、用HashSet保存k个位数值
	 *       2、循环获取HashSet中的第k位
	 *       3、循环中获取最小位元素，如果该数不在HashSet中 写入
	 *       4、返回HashSet中第k个位数值
	 */
	public int getKthMagicNumber1(int k) {
		// 最小堆处理写数值  试了一下Integer不够
		PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
		// HashSet 保存k个位数值
		Set<Long> list = new HashSet<>();
		priorityQueue.add(1L);
		while(true) {
			// 获取并删除队首元素
			Long val = priorityQueue.poll();
			// 该元素是否已在HashSet中，在将不操作，否则插入
			if(!list.contains(val)) {
				list.add(val);
				priorityQueue.add(val * 3);
				priorityQueue.add(val * 5);
				priorityQueue.add(val * 7);
			}
			// 返回第k个位数值
			if(list.size() == k) {
				return val.intValue();
			}
		}
	}
	

}
