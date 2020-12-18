package 力扣算法刷题.栈系列;

import java.util.Arrays;

public class 布尔运算 {

	/** 
	 * 题目：给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0
	 * (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成。实现一个函
	 * 数，算出有几种可使该表达式得出 result 值的括号方法
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
	 * 返回从索引start到end值为result的不同括号方案的个数
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
