package 力扣算法刷题.递归系列;

public class 青蛙跳台阶问题 {
	
	/** 
	 * 题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * 
	 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
	 */
	
	/** 
	 * 示例：
	 *    输入：n = 2
	 *    输出：2
	 *    
	 *    输入：n = 7
	 *    输出：21
	 */
	
	/** 
	 * 解题思路：
	 *       类似于斐波那契数列，思路见斐波那契数列的解法
	 */
	
	/** 
	 * 测试：
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		青蛙跳台阶问题 obj = new 青蛙跳台阶问题();
		int n = 2;
		System.out.println("动态规划解法的结果为：" + obj.numWays(n));
		n = 7;
		System.out.println("动态规划的解法结果为：" + obj.numWays(n));
	}
	
	/** 
	 * 解法一：动态规划
	 * 时间复杂度：O(N)，计算 f(n)f(n) 需循环 nn 次，每轮循环内计算操作使用 O(1)O(1) 。
	 * 空间复杂度：O(1)，几个标志变量使用常数大小的额外空间。
	 */
	public int numWays(int n) {
		int a = 1, b = 1, sum;
		for(int i = 0; i < n; i ++) {
			sum = (a+b) % 1000000007;
			a = b;
			b = sum;
		}
		return a;
	}

}
