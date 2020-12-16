package 力扣算法刷题.栈系列;

public class 不同路径 {
	/**
	 * 题目：一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

		        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

                                 问总共有多少条不同的路径？
	 */
	
	public static void main(String[] arg) {
		System.out.println(fun(3,3));
	}

	/** 
	 * 动态规划解法:
	 * 动态规划转移方程为：f(i,j)=f(i-1,j)+f(i,j-1)
	 * 细节：将所有的f(0,j)以及f(i,0)都设置为边界条件，它们的值均为1
	 * 时间复杂度：mn
	 * 空间复杂度：mn
	 */
	public static int fun(int m, int n) {
		int[][] f = new int[m][n];
		// 先进行初始化
		for(int i = 0; i < m; ++ i) {
			f[i][0] = 1;
		}
		for(int j = 0;j < n; ++ j) {
			f[0][j] = 1;
		}
		for(int i = 1; i < m; ++ i) {
			for(int j = 1; j < n; ++ j) {
				f[i][j] = f[i-1][j] + f[i][j - 1];
			}
		}
		return f[m-1][n-1];
	}
}
