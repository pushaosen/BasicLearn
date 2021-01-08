package 力扣算法刷题.递归系列;

public class 递归乘法 {
	
	/** 
	 * 题目：递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
	 * 
	 * 提示：保证乘法不会溢出
	 */
	
	/** 
	 * 示例：
	 *    输入：A = 1, B = 10
	 *    输出：10
	 *    
	 *    输入：A = 3, B = 4
	 *    输出：12
	 */
	
	/** 
	 * 测试：
	 */
	public static void main(String[] args) {
		递归乘法 obj = new 递归乘法();
		int A = 1, B = 10;
		System.out.println("解法一的结果为：" + obj.multiply(A, B));
		A = 3; B= 4;
		System.out.println("解法一的结果为：" + obj.multiply(A, B));
	}
	
	/**
	 * 解法一：
	 * 时间复杂度：O(logn)，n不会超过65536。
	 * 空间复杂度：O(1)
	 */
	public int multiply(int A, int B) {
		int min = Math.min(A, B);
		int max = Math.max(A, B);
		int ans = 0;
		
		for(int i = 0; min != 0; i ++) {
			if((min & 1) == 1) {
				ans += max << i;
			}  
			min >>= 1;
		}
		
		return ans;
	}

}
