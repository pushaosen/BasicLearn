package �����㷨.��̬�滮֮����Ǯ����;

import java.util.Arrays;

public class ����Ǯ {
	
	public static void main(String[] args) {
		int result = coinChange(new int[]{1, 2, 5}, 11);
		System.out.println(result);
	}

	public static int coinChange(int[] coins, int amount) {
        if(coins.length == 0)
            return -1;
        
        //����һ��amount+1���ȵ�����dp�����������ֵ��Ǯ������0��Ǯ���������ɵ��ܼ�ֵΪ0������ȫ����ʼ��Ϊ�����
        //dp[j]����Ǯ�����ܼ�ֵΪjʱ������Ҫ������Ӳ�ҵĸ���
        int[] dp = new int[amount+1];
        Arrays.fill(dp,1,dp.length,Integer.MAX_VALUE);
        
        //i�������ʹ�õ�Ӳ��������i=2����ֻ�ڵ�0������1������2��������Ӳ����ѡ��Ӳ��
        for (int i = 0; i < coins.length; i++) {
            /**
             *     �����ѭ��ִ��һ���Ժ�˵����ֻʹ��ǰi-1��Ӳ�ҵ�����£�����Ǯ��������Ӳ�Ҹ����Ѿ��õ���
             *         ��ЩǮ����ֵ���������˵���ڽ�ʹ��ǰi-1��Ӳ�ҵ�����£����ܴճ�Ǯ���ļ�ֵ
             *     ���ڿ�ʼ�ٷ����i��Ӳ�ң�Ҫ�����w[i]��Ǯ���ļ�ֵ��������j>=w[i]�������ڿ�ʼ�����i��Ӳ��ʱ��j��w[i]��ʼ
             */
	        for (int j = coins[i]; j <= amount; j++) {
	            /**
	             *     ���Ǯ����ǰ�ļ�ֵj�����������һ��w[i]����ô��Ҫ����Ȩ�⣬�Ի�ø��ٵ�Ӳ����
	             *         �������0������ʱǮ������Ӳ�ҵĸ������ֲ��䣺 v0=dp[j]
	             *         �������1������ʱǮ������Ӳ�ҵĸ���Ϊ��        v1=dp[j-coins[i]]+1
	             *          ��ǰ����dp[j-coins[i]]������ֵ�����dp[j-coins[i]]�������˵���޷��ճ�j-coins[i]��ֵ��Ǯ����
	             *                   ��ô��w[i]�Ž�ȥ�Ժ���ȻҲ�ղ���dp[j]��Ǯ����
	             *     ���ԣ���ʱ��Ǯ����ֵΪjʱ�������Ӳ����ĿΪ dp[j]=min{v0,v1}
	             *     ���Ǯ����ǰ��ֵj�ܹ�����2��w[i]����Ҫ�ٽ���һ��Ȩ��
	             *         ��������˵�2��w[i]����ʱǮ������Ӳ����ĿΪ��v1=dp[j]=min{v0,v1}
	             *         ��������2��w[i],  ��ʱǮ������Ӳ����ĿΪ��v2=dp[j-coins[i]]+1
	             *     ���ԣ���Ǯ���ļ�ֵΪjʱ�������Ӳ����ĿΪdp[j]=min{v1,v2}=min{v0,v1,v2}
	             *     Ǯ����ֵj���������3����4��.........w[i]�����ϸ���dp[j]�����õ��ڽ�ʹ��ǰi��Ӳ�ҵ�ʱ��ÿ��Ǯ���������Ӳ����Ŀ
	             */
	            if(dp[j-coins[i]] != Integer.MAX_VALUE) {
	                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
	            }
	        }
        }
        if(dp[amount] != Integer.MAX_VALUE)
            return dp[amount];
        return -1;
    }
}
