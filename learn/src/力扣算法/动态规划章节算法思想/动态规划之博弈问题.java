package 力扣算法.动态规划章节算法思想;

public class 动态规划之博弈问题 {
	
	public static void main(String[] args) {
		/*int[] piles = {1,2,3,4,5,6,7};
		System.out.println(stoneGame(piles));*/
		String str = "bgxxqkList+nBgsf";
		String[] arr = str.split("\\+");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
	}

	/** 
	 * 返回游戏最后先手和后手的得分之差
	 * @param piles
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int stoneGame(int[] piles) {
		int n = piles.length;
		// 初始化dp数组
		Pair[][] dp = new Pair[n][n];
		for(int i = 0; i < n; i ++) {
			for(int j = i; j < n; j ++) {
				dp[i][j] = new Pair(0, 0);
			}
		}
		// 填入base case
		for(int i = 0; i < n; i ++) {
			dp[i][i].fir = piles[i];
			dp[i][i].sec = 0;
		}
		// 谢卓遍历数组
		for(int l = 2; l <= n; l ++) {
			for(int i = 0; i <= n - l; i ++) {
				int j = l + i -1;
				// 先手选最左边或者最右边的分数
				int left = piles[i] + dp[i+1][j].sec;
				int right = piles[j] + dp[i][j-1].sec;
				// 套用状态转移方程
				if(left > right) {
					dp[i][j].fir = left;
					dp[i][j].sec = dp[i+1][j].fir;
				}else {
					dp[i][j].fir = right;
					dp[i][j].sec = dp[i][j-1].fir;
				}
			}
		}
		Pair res = dp[0][n-1];
		return res.fir - res.sec;
	}
	
	static class Pair{
		int fir, sec;
		Pair(int fir, int sec){
			this.fir = fir;
			this.sec = sec;
		}
	}
}
