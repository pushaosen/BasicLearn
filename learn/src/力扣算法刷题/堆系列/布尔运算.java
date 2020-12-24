package �����㷨ˢ��.��ϵ��;

public class �������� {
	
	/** 
	 * ��Ŀ������һ���������ʽ��һ�������Ĳ������ result���������ʽ�� 0(false)��1 (true)��& (AND)�� 
	 * | (OR) �� ^ (XOR) ������ɡ�ʵ��һ������������м��ֿ�ʹ�ñ��ʽ�ó� result ֵ�����ŷ�����
	 */
	
	/** 
	 * ʾ����
	 *     ���룺s = "1^0|0|1", result = 0
	 *     �����2
	 *     ���ͣ����ֿ��ܵ����ŷ����ǣ�
	 *         1^(0|(0|1))
	 *         1^((0|0)|1)
	 *         
	 *     ���룺s = "0&0&0&1^1|0", result = 1
	 *     �����10
	 */
	
	public static void main(String[] args) {
		�������� obj = new ��������();
		String str = "0&0&0&1^1|0";
		int result = 1;
		System.out.println("����DP�ⷨ�Ľ��Ϊ��" + obj.countEval(str, result));
		System.out.println("���νⷨ�Ľ��Ϊ��" + obj.countEval1(str, result));
	}
	
	/** 
	 * �ⷨһ������DP
	 * 1��״̬����
	 * 2��״̬ת��
	 * 3��base case������λ��ʼ��Ϊ1����dp[i][i][0/1] = 1
	 */
	public int countEval(String s, int result) {
	    //����
	    if (s.length() == 0) {
	        return 0;
	    }
	    if (s.length() == 1) {
	        return (s.charAt(0) - '0') == result ? 1 : 0;
	    }
	    char[] ch = s.toCharArray();
	    //����״̬
	    int[][][] dp = new int[ch.length][ch.length][2];
	    //base case
	    for (int i = 0; i < ch.length; i++) {
	        if (ch[i] == '0' || ch[i] == '1') {
	            dp[i][i][ch[i] - '0'] = 1;
	        }
	    }
	    //������dpģ��
	    //ö�����䳤��len������Ϊ2��һ������һ������
	    for (int len = 2; len <= ch.length; len += 2) {
	        //ö��������㣬����λ������Ϊ2
	        for (int i = 0; i <= ch.length - len; i += 2) {
	            //�����յ㣬����λ
	            int j = i + len;
	            //ö�ٷָ�㣬���� '&','|', '^'������Ϊ2
	            for (int k = i + 1; k <= j - 1; k += 2) {
	                if (ch[k] == '&') {
	                    //���Ϊ0 ����������� 0 0, 0 1, 1 0
	                    //���Ϊ1 ��һ������� 1 1
	                    dp[i][j][0] += dp[i][k-1][0] * dp[k+1][j][0] + 
	                    		       dp[i][k-1][0] * dp[k+1][j][1] + 
	                    		       dp[i][k-1][1] * dp[k+1][j][0];
	                    dp[i][j][1] += dp[i][k-1][1] * dp[k+1][j][1];
	                }
	                if (ch[k] == '|') {
	                    //���Ϊ0 ��һ������� 0 0
	                    //���Ϊ1 ����������� 0 1, 1 0, 1 1
	                    dp[i][j][0] += dp[i][k-1][0] * dp[k+1][j][0];
	                    dp[i][j][1] += dp[i][k-1][0] * dp[k+1][j][1] + 
	                    		       dp[i][k-1][1] * dp[k+1][j][0] + 
	                    		       dp[i][k-1][1] * dp[k+1][j][1];
	                }
	                if (ch[k] == '^') {
	                    //���Ϊ0 ����������� 0 0, 1 1
	                    //���Ϊ1 ����������� 0 1, 1 0
	                    dp[i][j][0] += dp[i][k-1][0] * dp[k+1][j][0] + 
	                    		       dp[i][k-1][1] * dp[k+1][j][1];
	                    dp[i][j][1] += dp[i][k-1][1] * dp[k+1][j][0] + 
	                    		       dp[i][k-1][0] * dp[k+1][j][1];
	                }
	            }
	        }
	    }
	    return dp[0][ch.length - 1][result];
	}
	
	/** 
	 * �ⷨ���������㷨
	 */
	public int countEval1(String str, int result) {
		// ����
		if(str.length() == 0) {
			return 0;
		}
		if(str.length() == 1) {
			return (str.charAt(0) - '0') == result ? 1 : 0;
		}
		int len = str.length();
		char[] ch = str.toCharArray();
		// ���ڼ��仯������������
		int[][][] cache = new int[len][len][];
		// 0Ϊ��߽磬ch.length - 1Ϊ�ұ߽�
		int[] res = backtrack(ch, 0, ch.length - 1, cache);
		return result == 0 ? res[0] : res[1];
	}
	private int[] backtrack(char[] ch, int left, int right, int[][][] cache) {
		int[] res = new int[2];
		if(left >= right) {
			res[ch[left]-'0'] = 1;
			return res;
		}
		// �����д��ھ�ֱ�ӷ���
		if(cache[left][right] != null) {
			return cache[left][right];
		}
		for(int i = left; i <= right; i ++) {
			// �������־�����
			if(ch[i] == '0' || ch[i] == '1') {
				continue;
			}
			// �������������ţ����Σ��ֱ�����������ߺ��ұߵĽ��
			int[] leftRes = backtrack(ch, left, i - 1, cache);
			int[] rightRes = backtrack(ch, i + 1, right, cache);
			switch(ch[i]) {
			case '&':
                //���Ϊ0 ����������� 0 0, 0 1, 1 0
                //���Ϊ1 ��һ������� 1 1
                res[0] += leftRes[0] * rightRes[0] + 
                          leftRes[0] * rightRes[1] + 
                          leftRes[1] * rightRes[0];
                res[1] += leftRes[1] * rightRes[1];
                break;
            case '|':
                //���Ϊ0 ��һ������� 0 0
                //���Ϊ1 ����������� 0 1, 1 0, 1 1
                res[0] += leftRes[0] * rightRes[0];
                res[1] += leftRes[0] * rightRes[1] + 
                		  leftRes[1] * rightRes[0] + 
                		  leftRes[1] * rightRes[1];
                break;
            case '^':
                //���Ϊ0 ����������� 0 0, 1 1
                //���Ϊ1 ����������� 0 1, 1 0
                res[0] += leftRes[0] * rightRes[0] + 
                          leftRes[1] * rightRes[1];
                res[1] += leftRes[0] * rightRes[1] + 
                		  leftRes[1] * rightRes[0];
                break;
            default:
                break;
			}
		}
		// ��������
		cache[left][right] = res;
		return res;
	}
}
