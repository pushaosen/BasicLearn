package �����㷨.��̬�滮�½��㷨˼��;

/**
 * �ַ�ƥ�������ϵ�нⷨ
 * @author lenovo
 *
 */
public class �ַ�ƥ������֮ⷨ�����ⷨ {

	/**
	 * ����ƥ��ⷨ��ʱ�临�Ӷ�ΪM*N
	 * @param pat
	 * @param txt
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int search(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();
		char[] patChar = pat.toCharArray();
		char[] txtChar = txt.toCharArray();
		for(int i = 0; i <= N - M; i ++) {
			int j;
			for(j = 0; j < M; j ++) {
				if(patChar[j] != txtChar[i + j]) {
					break;
				}
			}
			// patȫ��ƥ����
			if(j == M) {
				return i;
			}
		}
		// txt�в�����pat�Ӵ�
		return -1;
	}
}
