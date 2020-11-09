package 力扣算法.动态规划章节算法思想;

/**
 * 动态规划之最长子序列问题
 * @author lenovo
 *
 */
public class 动态规划之最长公共子序列问题 {

	public static int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length(), n = text2.length();
		// 构建 DP table 和 base case
        // dp[i][j] 表示： 字符串 str1[0:i] 和字符串 str2[0:j] 的最大公共子序列
		int[][] dp = new int[m+1][n+1];
		// 进行状态转移
		for(int i = 1; i <= m; i++){         
            for(int j = 1; j <= n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){ // 若两个字符相等，必然可以构成子问题的最优解
                    // 这个字符存在于 lcs 之中
                    dp[i][j] = dp[i-1][j-1] + 1; 
                }else{
                    // 此时 text1[i] != text2[j] 则表示至少有一个不在 lcs 中（要么 text1[i] 不在，要么 text2[j]不在，或者都不在）。
                    // 所以当前结果就相当于之前结果的中最大的那一个
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);  
                }
            }
        }
		return dp[m][n];
	}
}
