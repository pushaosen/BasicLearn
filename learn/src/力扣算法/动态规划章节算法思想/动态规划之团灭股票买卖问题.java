package 力扣算法.动态规划章节算法思想;

public class 动态规划之团灭股票买卖问题 {
	/**
	 * 案例分析：
	 * 没有都有三种选择：买入、卖出、无操作，我们用buy、sell、rest表示这三种状态
	 * 组成的数组大致形式为：
	 * dp[i][k][0 or 1]
	 * 0 <= i <= n-1, 1 <= k <= K
	 * n 为天数，大 K 为最多交易数
	 * 此问题共 n × K × 2 种状态，全部穷举就能搞定。
	 * 
	 * 涉及到的基本解法套路为：
	 * for 0 <= i < n:
	 * 		for 1 <= k <= K:
	 * 			for s in {0, 1}:
	 *				dp[i][k][s] = max(buy, sell, rest)
	 *
	 * 一、动态规划之状态转移框架：
	 * 1、dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
	 * 	               max(   选择 rest  ,             选择 sell      )
	 *   解释：今天我没有持有股票，有两种可能：
	 *   要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
	 *   要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
	 *   
	 * 2、dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
	 *  			    max(   选择 rest  ,           选择 buy         )
	 * 	  解释：今天我持有着股票，有两种可能：
	 *   要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
	 *   要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
	 *   
	 * 二、base case，即最简单的情况：
	 * 	  1、dp[-1][k][0] = 0
	 * 		解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
	 *    2、dp[-1][k][1] = -infinity
	 *      解释：还没开始的时候，是不可能持有股票的，用负无穷表示这种不可能。
	 *    3、dp[i][0][0] = 0
	 *      解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0 。
	 *    4、dp[i][0][1] = -infinity
	 *      解释：不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。
	 *      
	 * 三、上面的状态转移方程总结为：
	 *    1、base cease：
	 *      dp[-1][k][0] = dp[i][0][0] = 0
	 *      dp[-1][k][1] = dp[i][0][1] = -infinity
	 *      
	 *    2、状态转移方程：
	 *       dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
	 *       dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
	 */
	
	/**
	 * 第一道题：k = 1
	 */
	@SuppressWarnings("unused")
	private static int fun1(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n][2];
		for(int i = 0; i < n; i ++) {
			if(i-1==-1) {
				dp[i][0] = 0;
				dp[i][1] = -prices[i];
				continue;
			}
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i-1][1], - prices[i]);
		}
		return dp[n - 1][0];
	}
	
	//第一道题就解决了，但是这样处理base case很麻烦，而且注意一下状态转移方程，新状态只和相邻的一个状态有关，其实不用整个dp数组，
	// 只需要一个变量存储相邻的那个状态就足够了，这样可以把空间复杂度降到O(1)：
	@SuppressWarnings("unused")
	private static int maxProfit_k_1(int[] prices) {
		int n = prices.length;
		int dp_i_0 = 0,dp_i_1 = Integer.MIN_VALUE;
		for(int i = 0; i < n; i ++) {
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, -prices[i]);
		}
		return dp_i_0;
	}
	
	/**
	 * 第二道题：k = +infinity
	 * 如果k为正无穷，那么就可以认为k和k-1是一样的，就可以这样改写框架：
	 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
	 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
	 * 			   = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])
	 * 我们发现数组中的 k 已经不会变了，也就是说不需要记录 k 这个状态了
	 * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
	 * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
	 */
	@SuppressWarnings("unused")
	private static int maxProfit_k_inf(int[] prices) {
		int n = prices.length;
		int dp_i_0 = 0,dp_i_1 = Integer.MIN_VALUE;
		for(int i = 0; i < n; i ++) {
			int temp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
		}
		return dp_i_0;
	}
	
	/**
	 * 第三道题：k = +infinity with cooldown
	 * 每次sell之后要等一天才能继续交易。只要把这个特点融入上一道题的状态转移方程即可：
	 * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
	 * dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
	 * 解释：第i天选择buy的时候，要从i-2的状态转移，而不是i-1
	 */
	@SuppressWarnings("unused")
	private static int maxProfit_with_cool(int[] prices) {
		int n = prices.length;
		int dp_i_0 = 0,dp_i_1 = Integer.MIN_VALUE;
		int dp_pre_0 = 0; // 代表dp[i-2][0]
		for(int i = 0; i < n; i ++) {
			int temp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
			dp_pre_0 = temp;
		}
		return dp_i_0;
	}
	
	/**
	 * 第四道题：k = +infinity with fee
	 * 每次交易要支付手续费，只要把手续费从利润中减去即可。改写方程：
	 * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
	 * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
	 * 解释：相当于买入股票的价格升高了。
	 * 在第一个式子里减也是一样的，相当于卖出股票的价格减小了
	 */
	@SuppressWarnings("unused")
	private static int maxProfit_with_fee(int[] prices, int fee) {
		int n = prices.length;
		int dp_i_0 = 0,dp_i_1 = Integer.MIN_VALUE;
		for(int i = 0; i < n; i ++) {
			int temp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
	        dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
		}
		return dp_i_0;
	}
	
	/**
	 * 第五道题：k = 2
	 * k = 2 和前面题目的情况稍微不同，因为上面的情况都和 k 的关系不太大。要么 k 是正无穷，状态
	 * 转移和 k 没关系了；要么 k = 1，跟 k = 0 这个 base case 挨得近，最后也没有存在感。
	 * 这道题由于没有消掉k的影响，所以必须要对k进行穷举
	 * 这里k的取值范围比较小，所以可以不用for循环，直接把k=1和2的情况全部列举出来也可以
	 */
	@SuppressWarnings("unused")
	private static int maxProfit_k_2(int[] prices) {
		int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
	    int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
	    for (int price : prices) {
	        dp_i20 = Math.max(dp_i20, dp_i21 + price);
	        dp_i21 = Math.max(dp_i21, dp_i10 - price);
	        dp_i10 = Math.max(dp_i10, dp_i11 + price);
	        dp_i11 = Math.max(dp_i11, -price);
	    }
	    return dp_i20;
	}
	
	/**
	 * 第六道题：k = any integer
	 * 有了上一题 k = 2 的铺垫，这题应该和上一题的第一个解法没啥区别。但是出现了一个超内存的错
	 * 误，原来是传入的 k 值会非常大，dp 数组太大了。现在想想，交易次数 k 最多有多大呢？
	 * 
	 * 一次交易由买入和卖出构成，至少需要两天。所以说有效的限制 k 应该不超过 n/2，如果超过，就
	 * 没有约束作用了，相当于 k = +infinity。这种情况是之前解决过的。
	 */
	@SuppressWarnings("unused")
	private static int maxProfit_k_any(int max_k, int[] prices) {
		int n = prices.length;
		if(max_k > n / 2) {
			return maxProfit_k_inf(prices);
		}
		
		int[][][] dp = new int[n][max_k + 1][2];
		for(int i = 0; i < n; i ++) {
			for(int k = max_k; k >= 1; k --) {
				if(i - 1 == -1) {
					// 处理base case
				}                                                                                                                          
				dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
	            dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);    
			}
		}
		return dp[n - 1][max_k][0];
	}
	
	/**
	 * 最后的总结：
	 * 关键就在于列举出所有可能的【状态】，然后想想怎么穷举更新这些【状态】。一般用一个多维dp数组存储这些状态，从base case
	 * 向后推进，推进到最后的状态，就是我们想要的答案。
	 * 
	 * 具体到股票买卖问题，我们发现了三个状态，使用了一个三维数组，无非还是穷举+更新，不过我们可以说的高大上一点，这叫【三维DP】
	 */
}
