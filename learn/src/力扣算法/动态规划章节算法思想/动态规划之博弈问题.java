package �����㷨.��̬�滮�½��㷨˼��;

public class ��̬�滮֮�������� {
	
	public static void main(String[] args) {
		/*int[] piles = {1,2,3,4,5,6,7};
		System.out.println(stoneGame(piles));*/
		String str = "bgxxqkList+nBgsf";
		String[] arr = str.split("\\+");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
	}

	/** 
	 * ������Ϸ������ֺͺ��ֵĵ÷�֮��
	 * @param piles
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int stoneGame(int[] piles) {
		int n = piles.length;
		// ��ʼ��dp����
		Pair[][] dp = new Pair[n][n];
		for(int i = 0; i < n; i ++) {
			for(int j = i; j < n; j ++) {
				dp[i][j] = new Pair(0, 0);
			}
		}
		// ����base case
		for(int i = 0; i < n; i ++) {
			dp[i][i].fir = piles[i];
			dp[i][i].sec = 0;
		}
		// л׿��������
		for(int l = 2; l <= n; l ++) {
			for(int i = 0; i <= n - l; i ++) {
				int j = l + i -1;
				// ����ѡ����߻������ұߵķ���
				int left = piles[i] + dp[i+1][j].sec;
				int right = piles[j] + dp[i][j-1].sec;
				// ����״̬ת�Ʒ���
				if(left > right) {
					dp[i][j].fir = left;
					dp[i][j].sec = dp[i+1][j].fir;
				}else {
					dp[i][j].fir = right;
					dp[i][j].sec = dp[i][j-1].fir;
				}
			}
		}
		Pair res = dp[0][n-1];
		return res.fir - res.sec;
	}
	
	static class Pair{
		int fir, sec;
		Pair(int fir, int sec){
			this.fir = fir;
			this.sec = sec;
		}
	}
}
