package �����㷨.��̬�滮�½��㷨˼��;

/**
 * ��̬�滮֮�����������
 * @author lenovo
 *
 */
public class ��̬�滮֮��������������� {

	public static int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length(), n = text2.length();
		// ���� DP table �� base case
        // dp[i][j] ��ʾ�� �ַ��� str1[0:i] ���ַ��� str2[0:j] ����󹫹�������
		int[][] dp = new int[m+1][n+1];
		// ����״̬ת��
		for(int i = 1; i <= m; i++){         
            for(int j = 1; j <= n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){ // �������ַ���ȣ���Ȼ���Թ�������������Ž�
                    // ����ַ������� lcs ֮��
                    dp[i][j] = dp[i-1][j-1] + 1; 
                }else{
                    // ��ʱ text1[i] != text2[j] ���ʾ������һ������ lcs �У�Ҫô text1[i] ���ڣ�Ҫô text2[j]���ڣ����߶����ڣ���
                    // ���Ե�ǰ������൱��֮ǰ�������������һ��
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);  
                }
            }
        }
		return dp[m][n];
	}
}
