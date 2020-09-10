package �����㷨.��̬�滮�½��㷨˼��;

public class ��̬�滮֮�����Ʊ�������� {
	/**
	 * ����������
	 * û�ж�������ѡ�����롢�������޲�����������buy��sell��rest��ʾ������״̬
	 * ��ɵ����������ʽΪ��
	 * dp[i][k][0 or 1]
	 * 0 <= i <= n-1, 1 <= k <= K
	 * n Ϊ�������� K Ϊ��ཻ����
	 * �����⹲ n �� K �� 2 ��״̬��ȫ����پ��ܸ㶨��
	 * 
	 * �漰���Ļ����ⷨ��·Ϊ��
	 * for 0 <= i < n:
	 * 		for 1 <= k <= K:
	 * 			for s in {0, 1}:
	 *				dp[i][k][s] = max(buy, sell, rest)
	 *
	 * һ����̬�滮֮״̬ת�ƿ�ܣ�
	 * 1��dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
	 * 	               max(   ѡ�� rest  ,             ѡ�� sell      )
	 *   ���ͣ�������û�г��й�Ʊ�������ֿ��ܣ�
	 *   Ҫô���������û�г��У�Ȼ�����ѡ�� rest�������ҽ��컹��û�г��У�
	 *   Ҫô����������й�Ʊ�����ǽ����� sell �ˣ������ҽ���û�г��й�Ʊ�ˡ�
	 *   
	 * 2��dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
	 *  			    max(   ѡ�� rest  ,           ѡ�� buy         )
	 * 	  ���ͣ������ҳ����Ź�Ʊ�������ֿ��ܣ�
	 *   Ҫô������ͳ����Ź�Ʊ��Ȼ�����ѡ�� rest�������ҽ��컹�����Ź�Ʊ��
	 *   Ҫô�����챾û�г��У���������ѡ�� buy�����Խ����Ҿͳ��й�Ʊ�ˡ�
	 *   
	 * ����base case������򵥵������
	 * 	  1��dp[-1][k][0] = 0
	 * 		���ͣ���Ϊ i �Ǵ� 0 ��ʼ�ģ����� i = -1 ��ζ�Ż�û�п�ʼ����ʱ�������Ȼ�� 0 ��
	 *    2��dp[-1][k][1] = -infinity
	 *      ���ͣ���û��ʼ��ʱ���ǲ����ܳ��й�Ʊ�ģ��ø������ʾ���ֲ����ܡ�
	 *    3��dp[i][0][0] = 0
	 *      ���ͣ���Ϊ k �Ǵ� 1 ��ʼ�ģ����� k = 0 ��ζ�Ÿ����������ף���ʱ������Ȼ�� 0 ��
	 *    4��dp[i][0][1] = -infinity
	 *      ���ͣ��������׵�����£��ǲ����ܳ��й�Ʊ�ģ��ø������ʾ���ֲ����ܡ�
	 *      
	 * ���������״̬ת�Ʒ����ܽ�Ϊ��
	 *    1��base cease��
	 *      dp[-1][k][0] = dp[i][0][0] = 0
	 *      dp[-1][k][1] = dp[i][0][1] = -infinity
	 *      
	 *    2��״̬ת�Ʒ��̣�
	 *       dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
	 *       dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
	 */
	
	/**
	 * ��һ���⣺k = 1
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
	
	//��һ����ͽ���ˣ�������������base case���鷳������ע��һ��״̬ת�Ʒ��̣���״ֻ̬�����ڵ�һ��״̬�йأ���ʵ��������dp���飬
	// ֻ��Ҫһ�������洢���ڵ��Ǹ�״̬���㹻�ˣ��������԰ѿռ临�ӶȽ���O(1)��
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
	 * �ڶ����⣺k = +infinity
	 * ���kΪ�������ô�Ϳ�����Ϊk��k-1��һ���ģ��Ϳ���������д��ܣ�
	 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
	 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
	 * 			   = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])
	 * ���Ƿ��������е� k �Ѿ�������ˣ�Ҳ����˵����Ҫ��¼ k ���״̬��
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
	 * �������⣺k = +infinity with cooldown
	 * ÿ��sell֮��Ҫ��һ����ܼ������ס�ֻҪ������ص�������һ�����״̬ת�Ʒ��̼��ɣ�
	 * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
	 * dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
	 * ���ͣ���i��ѡ��buy��ʱ��Ҫ��i-2��״̬ת�ƣ�������i-1
	 */
	@SuppressWarnings("unused")
	private static int maxProfit_with_cool(int[] prices) {
		int n = prices.length;
		int dp_i_0 = 0,dp_i_1 = Integer.MIN_VALUE;
		int dp_pre_0 = 0; // ����dp[i-2][0]
		for(int i = 0; i < n; i ++) {
			int temp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
			dp_pre_0 = temp;
		}
		return dp_i_0;
	}
	
	/**
	 * ���ĵ��⣺k = +infinity with fee
	 * ÿ�ν���Ҫ֧�������ѣ�ֻҪ�������Ѵ������м�ȥ���ɡ���д���̣�
	 * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
	 * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
	 * ���ͣ��൱�������Ʊ�ļ۸������ˡ�
	 * �ڵ�һ��ʽ�����Ҳ��һ���ģ��൱��������Ʊ�ļ۸��С��
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
	 * ������⣺k = 2
	 * k = 2 ��ǰ����Ŀ�������΢��ͬ����Ϊ������������ k �Ĺ�ϵ��̫��Ҫô k �������״̬
	 * ת�ƺ� k û��ϵ�ˣ�Ҫô k = 1���� k = 0 ��� base case ���ý������Ҳû�д��ڸС�
	 * ���������û������k��Ӱ�죬���Ա���Ҫ��k�������
	 * ����k��ȡֵ��Χ�Ƚ�С�����Կ��Բ���forѭ����ֱ�Ӱ�k=1��2�����ȫ���оٳ���Ҳ����
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
	 * �������⣺k = any integer
	 * ������һ�� k = 2 ���̵棬����Ӧ�ú���һ��ĵ�һ���ⷨûɶ���𡣵��ǳ�����һ�����ڴ�Ĵ�
	 * ��ԭ���Ǵ���� k ֵ��ǳ���dp ����̫���ˡ��������룬���״��� k ����ж���أ�
	 * 
	 * һ�ν�����������������ɣ�������Ҫ���졣����˵��Ч������ k Ӧ�ò����� n/2�������������
	 * û��Լ�������ˣ��൱�� k = +infinity�����������֮ǰ������ġ�
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
					// ����base case
				}                                                                                                                          
				dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
	            dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);    
			}
		}
		return dp[n - 1][max_k][0];
	}
	
	/**
	 * �����ܽ᣺
	 * �ؼ��������оٳ����п��ܵġ�״̬����Ȼ��������ô��ٸ�����Щ��״̬����һ����һ����άdp����洢��Щ״̬����base case
	 * ����ƽ����ƽ�������״̬������������Ҫ�Ĵ𰸡�
	 * 
	 * ���嵽��Ʊ�������⣬���Ƿ���������״̬��ʹ����һ����ά���飬�޷ǻ������+���£��������ǿ���˵�ĸߴ���һ�㣬��С���άDP��
	 */
}
