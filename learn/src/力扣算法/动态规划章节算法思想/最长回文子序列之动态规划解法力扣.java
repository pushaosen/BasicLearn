package 力扣算法.动态规划章节算法思想;

public class 最长回文子序列之动态规划解法力扣 {

	// 测试方法
	public static void main(String[] args) {
		long start1 = System.nanoTime();
		int result2 = longestPalindromeSubseq2("abbbbbssbsbsbsba");
		System.out.println(result2);
		System.out.println("花费时间为：" + (System.nanoTime() - start1));
	}
	
	/**
	 * 算法分析：
	 * 设n为字符串str的长度
	 * 1、只需要填dp table的右上角，有n(n-1)/2个状态需要填，时间复杂度为O(n*n)
	 * 2、几个变量O(1)，dp table的大小O(n*n)，空间复杂度为O(n*n)
	 * @param str
	 * @return
	 */
	public static int longestPalindromeSubseq2(String str) {
		if(str == null) {
			return 0;
		}
		int[][] dp = new int[str.length()][str.length()];
		int n = str.length();
		for(int i = 0; i < n; i ++) {
			dp[i][i] = 1;
		}
		// 从下往上遍历
		for(int i = n - 1; i >= 0; i --) {
			for(int j = i + 1; j < n; j ++) {
				// 那么就说明在原先的基础上又增加了回文子序列的长度
				if(str.charAt(i) == str.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				}
				// 表明这时dp[i][j]只需取两者之间的最大值即可
				else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][n - 1];
	}
	
}
