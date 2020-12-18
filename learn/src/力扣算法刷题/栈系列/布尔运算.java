package �����㷨ˢ��.ջϵ��;

import java.util.Arrays;

public class �������� {

	/** 
	 * ��Ŀ������һ���������ʽ��һ�������Ĳ������ result���������ʽ�� 0
	 * (false)��1 (true)��& (AND)�� | (OR) �� ^ (XOR) ������ɡ�ʵ��һ����
	 * ��������м��ֿ�ʹ�ñ��ʽ�ó� result ֵ�����ŷ���
	 */
	
	private char[] arr;
	private int[][][] dp;
	
	private int getBoolAns(int val1, int val2, char operator) {
		switch(operator) {
		case '&':
			return val1 & val2;
		case '|':
			return val1 | val2;
		case '^': 
			return val1 ^ val2;
		}
		return val1 & val2;
	}
	
	/** 
	 * ���ش�����start��endֵΪresult�Ĳ�ͬ���ŷ����ĸ���
	 */
	private int rec(int start, int end, int result) {
		if(start == end) {
			return arr[start] - '0' == result ? 1 : 0; 
		}
		if(dp[start][end][result] != -1) {
			return dp[start][end][result];
		}
		
		int ansCount = 0;
		for(int k = start; k < end; k += 2) {
			char operator = arr[k + 1];
			for(int i = 0; i <= 1; i ++) {
				for(int j = 0; j <= 1; j ++) {
					if (getBoolAns(i, j, operator) == result) {
						ansCount += rec(start, k, i) * rec(k + 2, end, j);
					}
				}
			}
		}
		
		dp[start][end][result] = ansCount;
		return ansCount;
	}
	
	public int countEval(String str, int result) {
		arr = str.toCharArray();
		int len = arr.length;
		dp = new int[len][len][2];
		for(int i = 0; i < len; i ++) {
			for (int j = 0; j < len; j ++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		return rec(0, len - 1, result);
	}
}
