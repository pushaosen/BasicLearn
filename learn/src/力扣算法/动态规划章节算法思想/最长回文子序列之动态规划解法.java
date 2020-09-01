package �����㷨.��̬�滮�½��㷨˼��;

public class �����������֮��̬�滮�ⷨ {

	// ���ݹ飬��ʱ
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
	
	// ���Է���
	public static void main(String[] args) {
		long start = System.nanoTime();
		int result = longestPalindromeSubseq("abbbbbssbsbsbsba");
		System.out.println(result);
		System.out.println("����ʱ��Ϊ��" + (System.nanoTime() - start));
		long start1 = System.nanoTime();
		int result2 = longestPalindromeSubseq2("abbbbbssbsbsbsba");
		System.out.println(result2);
		System.out.println("����ʱ��Ϊ��" + (System.nanoTime() - start1));
	}
	
	/**
	 * �㷨������
	 * ��nΪ�ַ���str�ĳ���
	 * 1��ֻ��Ҫ��dp table�����Ͻǣ���n(n-1)/2��״̬��Ҫ�ʱ�临�Ӷ�ΪO(n*n)
	 * 2����������O(1)��dp table�Ĵ�СO(n*n)���ռ临�Ӷ�ΪO(n*n)
	 * @param str
	 * @return
	 */
	public static int longestPalindromeSubseq2(String str) {
		int size = str.length();
		if(size == 0) {     // ���ַ���
			return 0;
		}
		// ��ʼ��
		int[][] dp = new int[size][size];
		for(int i = 0; i < size; i ++) { // ���Խ��ߣ������ַ���Ϊ�ǳ���Ϊ1�Ļ�������
			dp[i][i] = 1;
		}
		// ��״̬ת�Ʒ������
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
		return dp[0][size - 1];     // ����dp���鶨��Ӧ�÷������ֵ
	}
	
}
