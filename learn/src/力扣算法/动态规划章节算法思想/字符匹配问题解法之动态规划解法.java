package �����㷨.��̬�滮�½��㷨˼��;

/**
 * �ַ�ƥ������֮��̬�滮�ⷨ
 * @author lenovo
 *
 */
public class �ַ�ƥ������֮ⷨ��̬�滮�ⷨ {
	
	static class KMP{
		private int[][] dp;
		private String pat;
		
		/**
		 * ����״̬ת��ͼ
		 * @param pat
		 */
		public KMP(String pat) {
			this.pat = pat;
			int M = pat.length();
			// dp[״̬][�ַ�] = �¸�״̬
			// 256��ʾ�ַ�����ĸ���
			dp = new int[M][256];
			// base case
			dp[0][pat.charAt(0)] = 1;
			// Ӱ��״̬ X ��ʼΪ 0
			// ����״̬ת��ͼ(�Ըĵĸ�������)
			int X = 0;
			for(int j = 1; j < M; j ++) {
				for(int c = 0; c < 256; c ++) {
					dp[j][c] = dp[X][c];
				}
				dp[j][pat.charAt(j)] = j + 1;
				// ����Ӱ��״̬
				X = dp[X][pat.charAt(j)];
			}
		}
		
		/**
		 * ����KMP�㷨ʵ�ֵ��ַ���ƥ���㷨ʵ��
		 * @param txt
		 * @return
		 */
		public int search(String txt) {
			int M = pat.length();
			int N = pat.length();
			// pat�ĳ�ʼ״̬Ϊ 0
			int j = 0;
			for(int i = 0; i < N; i ++) {
				// ����pat����һ��״̬
				j = dp[j][txt.charAt(i)];
				// ������ֹ̬�����ؽ��
				if(j == M) {
					return i - M + 1;
				}
			}
			// û�ﵽ��ֹ̬��ƥ��ʧ��
			return -1;
		}
	}

}
