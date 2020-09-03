package �����㷨.��̬�滮�½��㷨˼��;

public class �����������֮��̬�滮�ⷨ���� {

	// ���Է���
	public static void main(String[] args) {
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
		if(str == null) {
			return 0;
		}
		int[][] dp = new int[str.length()][str.length()];
		int n = str.length();
		for(int i = 0; i < n; i ++) {
			dp[i][i] = 1;
		}
		// �������ϱ���
		for(int i = n - 1; i >= 0; i --) {
			for(int j = i + 1; j < n; j ++) {
				// ��ô��˵����ԭ�ȵĻ������������˻��������еĳ���
				if(str.charAt(i) == str.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				}
				// ������ʱdp[i][j]ֻ��ȡ����֮������ֵ����
				else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][n - 1];
	}
	
}
