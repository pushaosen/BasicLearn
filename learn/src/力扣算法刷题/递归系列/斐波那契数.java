package 力扣算法刷题.递归系列;

public class 斐波那契数 {
	
	/**
	 * 题目：斐波那契数，通常用F(n)表示，形成的序列称为 斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
	 * 
	 *     F(0) = 0，F(1) = 1
	 *     F(n) = F(n-1) + F(n-2)，其中 n > 1
	 */
	
	/**
	 * 示例：
	 *    输入：3
	 *    输出：2
	 *    解释：F(3) = F(2) + F(1) = 1 + 1 = 2
	 */
	
	public static void main(String[] args) {
		斐波那契数 obj = new 斐波那契数();
		int n = 3;
		System.out.println("斐波那契数动态规划解法结果为：" + obj.fib(n));
		System.out.println("通项公式的解法的结果为：" + obj.fib1(n));
	}
	
	/** 
	 * 解法一：动态规划
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 */
	public int fib(int n) {
		if(n < 2) {
			return n;
		}
		int p = 0, q = 0, r = 1;
		for(int i = 2; i <= n; ++ i) {
			p = q;
			q = r;
			r = p + q;
		}
		return r;
	}
	
	/** 
	 * 解法二：通项公式
	 * F(n) = F(n-1) + F(n-2)，    可以推出：x*x = x + 1
	 */
	public int fib1(int n) {
		double sqrt5 = Math.sqrt(5);
		double fibN = Math.pow((1+sqrt5)/2, n) - Math.pow((1 - sqrt5)/2, n);
		return (int)Math.round(fibN/sqrt5);
	}

}
