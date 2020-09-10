package 力扣算法.动态规划章节算法思想;

/**
 * 字符匹配问题之动态规划解法
 * @author lenovo
 *
 */
public class 字符匹配问题解法之动态规划解法 {
	
	static class KMP{
		private int[][] dp;
		private String pat;
		
		/**
		 * 构建状态转移图
		 * @param pat
		 */
		public KMP(String pat) {
			this.pat = pat;
			int M = pat.length();
			// dp[状态][字符] = 下个状态
			// 256表示字符编码的个数
			dp = new int[M][256];
			// base case
			dp[0][pat.charAt(0)] = 1;
			// 影子状态 X 初始为 0
			// 构建状态转移图(稍改的更紧凑了)
			int X = 0;
			for(int j = 1; j < M; j ++) {
				for(int c = 0; c < 256; c ++) {
					dp[j][c] = dp[X][c];
				}
				dp[j][pat.charAt(j)] = j + 1;
				// 更新影子状态
				X = dp[X][pat.charAt(j)];
			}
		}
		
		/**
		 * 基于KMP算法实现的字符串匹配算法实现
		 * @param txt
		 * @return
		 */
		public int search(String txt) {
			int M = pat.length();
			int N = pat.length();
			// pat的初始状态为 0
			int j = 0;
			for(int i = 0; i < N; i ++) {
				// 计算pat的下一个状态
				j = dp[j][txt.charAt(i)];
				// 到达终止态，返回结果
				if(j == M) {
					return i - M + 1;
				}
			}
			// 没达到终止态，匹配失败
			return -1;
		}
	}

}
