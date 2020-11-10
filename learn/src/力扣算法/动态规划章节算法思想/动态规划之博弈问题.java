package 力扣算法.动态规划章节算法思想;

import java.math.BigDecimal;

public class 动态规划之博弈问题 {
	
	public static void main(String[] args) {
		/*int[] piles = {1,2,3,4,5,6,7};
		System.out.println(stoneGame(piles));*/
		String str = "bgxxqkList+nBgsf";
		String[] arr = str.split("\\+");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		String data = "1090.40";
		int pos = data.lastIndexOf(".");
        if (pos > -1){
            String temp = data.substring(pos + 1);
            if (temp.length() > 2){
                data = data.substring(0, pos + 3);
            }
        }
        pos = data.lastIndexOf(".00");
        if (pos > -1) {
            System.out.println(data.substring(0, pos));
        }
        pos = data.lastIndexOf(".");
        if (pos > -1) {
            String temp = data.substring(pos + 1);
            int index = temp.lastIndexOf("0");
            if (index > -1 && temp.endsWith("0")) {
            	if (temp.length() == 1){
                    System.out.println(data.substring(0, pos + index));
                }
                System.out.println(data.substring(0, pos + index + 1));
            }
            
        }
		System.out.println(data);
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
