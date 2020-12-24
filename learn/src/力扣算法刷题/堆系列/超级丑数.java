package �����㷨ˢ��.��ϵ��;

public class �������� {
	
	/** 
	 * ��Ŀ��
	 *     ��дһ�γ��������ҵ� n ������������
	 *     ����������ָ���������������ǳ���Ϊ k �������б� primes �е���������
	 */
	
	/** 
	 * ʾ����
	 *     ���룺n = 12, primes = [2,7,13,19]
	 *     �����32
	 *     ���ͣ���������Ϊ 4 �������б� primes = [2,7,13,19]��ǰ 12��
	 *         ������������Ϊ��[1,2,4,7,8,13,14,16,19,26,28,32] ��
	 */
	
	/**
	 * �ⷨ����̬�滮
	 */
	public int nthSuperUglyNumber(int n, int[] primes) {
		int len = primes.length;
		int[] dp = new int[n];
		dp[0] = 1;
		/*
		 ����һ��˼·��dp[i]������ǵ�i����������
		 index[i]��ʾ����primes����ĵ�i������һ����Ҫ��˵�����dp�е�λ�ã�
		 �������룬����ÿ��primes��˵�����Ƕ���Ҫ��dp���Ѿ�������Ľ������㣬
		 Ȼ��ȡ��С���Ǹ���Ϊ�µ�dpԪ��
		 ����indexʵ���ϱ�ʾ������������Ѿ���dp�е��Ǹ�λ�ý������һ��λ�õ������Ƕ���
		 */
		int[] index = new int[len];
		// ���ܴ����ظ��ĳ����������أ���Ҫ��forѭ�������break�������е������+1
		for(int i = 1; i < n; i ++) {
			int min = Integer.MAX_VALUE;
			// �����Ա�һ��ֵ���ҳ���С��
			for(int j = 0; j < len; j ++) {
				if(min > primes[j] * dp[index[j]]) {
					min = primes[j] * dp[index[j]];  // ����ط����ǵ�ǰ����������Ҫ��ϵ�dp
				}
			}
			dp[i] = min;
			/** 
			 * �Ǹ�����Ҫ����dp������indexҪ��1�������һ��λ
			 * ��������ظ���ֵ��Ҳ����˵��ͬ����������ˣ��ó�����ͬ�Ľ���ˣ�
			 * ���ǾͰ��⼸��λ�ö�+1�������Ϳ��Ա�������ظ���ֵ�ˡ�
			 * �����룬�������ҵ��˶�Ӧ��������index��������1֮���break������ô�������Ҳ���������������
			 * �´�ѭ����ʱ���Ʊػ������ظ�����������һ��dp����Ϊ������϶�Ҫ����һ������С
			 * ����������forѭ���в�Ҫ��break��
			 */
			for(int j = 0; j < len; j ++) {
				if(min == primes[j] * dp[index[j]]) {
					index[j] ++;
				}
			}
		}
		return dp[n - 1];
	}
	
	/** 
	 * �ⷨ����ʹ�ö�
	 */
	public int nthSuperUglyNumber1(int n, int[] primes) {
		int[] dp = new int[n];
		dp[0] = 1;
		
		int k = primes.length;
		int[] index = new int[k];
		
		for(int i = 1; i < n; i ++) {
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < k; j ++) {
				if(min > dp[index[j]]*primes[j]) {
					min = dp[index[j]] * primes[j];
				}
			}
			dp[i] = min;
			// ����index
			for(int j = 0; j < k; j ++) {
				if(min == dp[index[j]] * primes[j]) {
					index[j]++;
				}
			}
		}
		return dp[n-1];
	}

}
