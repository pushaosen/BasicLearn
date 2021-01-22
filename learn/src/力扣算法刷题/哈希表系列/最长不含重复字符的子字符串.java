package �����㷨ˢ��.��ϣ��ϵ��;

import java.util.HashMap;
import java.util.Map;

public class ������ظ��ַ������ַ��� {
	
	/** 
	 * ��Ŀ������ַ������ҳ�һ����Ĳ������ظ��ַ������ַ��������������ַ����ĳ��ȡ�
	 */
	
	/** 
	 * ʾ����
	 *    ���룺"abcabcbb"
	 *    �����3
	 *    ���ͣ���Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
	 *    
	 *    ���룺"bbbbb"
	 *    �����1
	 *    ���ͣ���Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
	 *    
	 *    ���룺"pwwkew"
	 *    �����3
	 *    ���ͣ� ��Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3��
	 *    ע�⣺��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke" ��һ�������У������Ӵ���
	 */
	
	/** 
	 * ����
	 */
	public static void main(String[] args) {
		������ظ��ַ������ַ��� obj = new ������ظ��ַ������ַ���();
		String s = "abcabcbb";
		System.out.println("��̬�滮+��ϣ��Ľⷨ�Ľ��Ϊ��" + obj.lengthOfLongestSubstring(s));
		s = "bbbbb";
		System.out.println("��̬�滮+��ϣ��Ľⷨ�Ľ��Ϊ��" + obj.lengthOfLongestSubstring(s));
		s = "pwwkew";
		System.out.println("��̬�滮+��ϣ��Ľⷨ�Ľ��Ϊ��" + obj.lengthOfLongestSubstring(s));
	}

	/** 
	 * �ⷨһ����̬�滮+��ϣ��
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 */
	public int lengthOfLongestSubstring(String s) {
		// ��̬�滮
		// 1��״̬-״̬Ϊ��ǰλ��(��仯)
		// 2��dp��������-dp[n]��n����ǰλ�ã�dp[n]����ǰλ�õ����ֵ
		// 3��ѡ��-���ǰ����ַ�����nλ�õ��ַ����������ͬ���ַ�λ��Ϊm�������ֵΪn-m������Ϊdp[n-1]+1
		// 4��base case-dp[0] = 1;
		// �߽�ֵ���
		if(s.length() == 0) {   // �ַ�Ϊ��ʱ����0
			return 0;
		}
		if(s.length() == 1) {   // �ַ�ֻ��һ��ʱ����1
			return 1;
		}
		int[] dp = new int[s.length()];
		dp[0] = 1;    // base case����һ���ַ�ʱΪ1
		int m = 0;    // m��¼���ڵ��ַ���λ��
	    int max = Integer.MIN_VALUE;
	    Map<Character, Integer> map = new HashMap<Character, Integer>();
	    map.put(s.charAt(0), 0);
	    for(int n = 1; n < s.length(); n ++) {
	    	if(map.containsKey(s.charAt(n))) {
	    		int temp = map.get(s.charAt(n));
	    		if(temp > m) {   // ���Ѿ����ڵ��ַ�λ����m����ʱ�Ÿ���m��ֵ
	    			m = temp;
	    		}
	    		dp[n] = n - m;
	    	}else {
	    		dp[n] = dp[n - 1] + 1;
	    	}
	    	map.put(s.charAt(n), n);    // �����ظ���ֵ
	    	max = Math.max(max, dp[n]);    // ȡ��������������ֵ��Ϊ���
	    }
	    return max;
	}
	
	/** 
	 * �ⷨ������̬�滮+��ϣ��
	 * ʱ�临�Ӷȣ�O(N)
	 * �ռ临�Ӷȣ�O(1)
	 */
	public int lengthOfLongestSubstring1(String s) {
		Map<Character, Integer> dic = new HashMap<>();
		int res = 0, tmp = 0;
		for(int j = 0; j < s.length(); j ++) {
			int i = dic.getOrDefault(s.charAt(j), -1);   // ��ȡ����i
			dic.put(s.charAt(j), j);    // ���¹�ϣ��
			tmp = tmp < j - i ? tmp + 1 : j - i;   // dp[j-1] -> dp[j]
			res = Math.max(res, tmp);    // max(dp[j-1], dp[j])
		}
		return res;
	}
	
	/** 
	 * �ⷨ������̬�滮+���Ա���
	 * ʱ�临�Ӷȣ�O(n*n)
	 * �ռ临�Ӷȣ�O(1)
	 */
	public int lengthOfLongestSubstring2(String s) {
		int res = 0, tmp = 0;
		for(int j = 0; j < s.length(); j ++) {
			int i = j - 1;
			while(i >= 0 && s.charAt(i) != s.charAt(j)) {
				i --;    // ���Բ���i
			}
			tmp = tmp < j - i ? tmp + 1: j - i;  // dp[j-1] -> dp[j]
			res = Math.max(res, tmp);
		}
		return res;
	}
	
	/** 
	 * �ⷨ�ģ�˫ָ��+��ϣ��
	 * ʱ�临�Ӷȣ�O(N)
	 * �ռ临�Ӷȣ�O(1)
	 */
	public int lengthOfLongestSubstring3(String s) {
		Map<Character, Integer> dic = new HashMap<>();
		int i = -1, res = 0;
		for(int j = 0; j < s.length(); j ++) {
			if(dic.containsKey(s.charAt(j))) {
				i = Math.max(i, dic.get(s.charAt(j)));    // ������ָ�� i
			}
			dic.put(s.charAt(j), j);       // ��ϣ���¼
			res = Math.max(res, j - i);     // ���¼�¼
		}
		return res;
	}
}
