package 力扣算法刷题.递归系列;

public class 数值的整数次方 {
	
	/** 
	 * 题目：实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
	 */
	
	/** 
	 * 示例：
	 *     输入：2.00000, 10
	 *     输出：1024.00000
	 *     
	 *     输入：2.10000, 3
	 *     输出：9.26100
	 */
	
	/** 
	 * 解法一：快速幂法
	 */
	public double myPow(double x, int n) {
		if(x == 0) {
			return 0;
		}
		long b = n;
		double res = 1.0;
		if(b<0) {
			x = 1/x;
			b = -b;
		}
		while(b > 0) {
			if((b & 1) == 1) {
				res *= x;
			} 
			x *= x;
			b >>= 1;
		}
		return res;
	}

}
