package 力扣算法.动态规划章节算法思想;


public class 最小编辑距离问题 {
	
	public static int minDistance(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		int[][] dp = new int[m + 1][n + 1];
		// base case
		for(int i = 1; i <= m; i ++) {
			dp[i][0] = i;
		}
		for(int j = 1; j <= n; j ++) {
			dp[0][j] = j;
		}
		// 自底向上求解
		for(int i = 1; i <= m; i ++) {
			for(int j = 1; j <= n; j ++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				}else {
					dp[i][j] = min(dp[i-1][j] + 1,
							dp[i][j-1] + 1,
							dp[i-1][j-1] + 1);
				}
			}
		}
		// 储存整个s1和s2的最小编辑距离
		return dp[m][n];
	}

	public static int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
}
