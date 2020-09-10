package 力扣算法.动态规划章节算法思想;

/**
 * 字符匹配问题的系列解法
 * @author lenovo
 *
 */
public class 字符匹配问题解法之暴力解法 {

	/**
	 * 暴力匹配解法：时间复杂度为M*N
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
			// pat全都匹配了
			if(j == M) {
				return i;
			}
		}
		// txt中不存在pat子串
		return -1;
	}
}
