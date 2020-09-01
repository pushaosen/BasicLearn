package 力扣算法.动态规划章节算法思想;

public class 最长回文子序列之动态规划解法 {

	// 纯递归，超时
	public static int longestPalindromeSubseq(String str) {
		char[] ss = str.toCharArray();
		return helper(ss, 0, ss.length - 1);
	}

	private static int helper(char[] ss, int begin, int end) {
		if(begin == end) {
			return 1;      // case1
		}
		if(ss[begin] == ss[end] && begin + 1 == end) {  // case2
			return 2;
		}
		if(ss[begin] != ss[end]) {   // case4
			return Math.max(helper(ss, begin, end - 1), helper(ss, begin + 1, end));
		}
		return 2 + helper(ss, begin + 1, end - 1);  // case3
	}
	
	// 测试方法
	public static void main(String[] args) {
		long start = System.nanoTime();
		int result = longestPalindromeSubseq("abbbbbssbsbsbsba");
		System.out.println(result);
		System.out.println("花费时间为：" + (System.nanoTime() - start));
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
		int size = str.length();
		if(size == 0) {     // 空字符串
			return 0;
		}
		// 初始化
		int[][] dp = new int[size][size];
		for(int i = 0; i < size; i ++) { // 主对角线，单个字符认为是长度为1的回文序列
			dp[i][i] = 1;
		}
		// 按状态转移方程填表
		for(int i = size - 2; i >= 0; i --) {
			for(int j = i + 1; j < size; j ++) {
				if(str.charAt(i) != str.charAt(j)) {
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}else if(i + 1 == j) {
					dp[i][j] = 2;
				}else {
					dp[i][j] = 2 + dp[i + 1][j - 1];
				}
			}
		}
		return dp[0][size - 1];     // 按照dp数组定义应该返回这个值
	}
	
}
