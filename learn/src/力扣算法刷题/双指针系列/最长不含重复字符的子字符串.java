package �����㷨ˢ��.˫ָ��ϵ��;

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
	 *    ���ͣ���Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3��
	 *        ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke" ��һ�������У������Ӵ���
	 */
	
	/** 
	 * ����
	 */
	public static void main(String[] args) {
		
	}
	
	/** 
	 * �ⷨһ����̬�滮+��ϣ��
	 * ʱ�临�Ӷȣ�O(N)������NΪ�ַ������ȣ���̬�滮���������dp�б�
	 * �ռ临�Ӷȣ�O(1)���ַ���ASCII�뷶ΧΪ0-127����ϣ��dic���ʹ��O(128) = O(1)��С�Ķ���ռ䡣
	 */
	public int lengthOfLongestSubstring(String str) {
		Map<Character, Integer> dic = new HashMap<Character, Integer>();
		int res = 0, tmp = 0;
		for(int j = 0; j < str.length(); j ++) {
			int i = dic.getOrDefault(str.charAt(j), -1);  // ��ȡ����i
			dic.put(str.charAt(j), j);   // ���¹�ϣ��
			tmp = tmp < j - i ? tmp + 1 : j - i;    // dp[j - 1] -> dp[j]
			res = Math.max(res, tmp);    // max(dp[j - 1], dp[j])
		}
		return res;
	}
	
	/** 
	 * �ⷨ������̬�滮+���Ա���
	 * ʱ�临�Ӷȣ�O(N*N)������NΪ�ַ������ȣ���̬�滮���������dp�б�ռ��O(N)��ÿ�ּ���dp[j]ʱ����i��Ҫ����j���ַ���ռ��O(N)
	 * �ռ临�Ӷȣ�O(1)����������ʹ�ó�����С�Ŀռ�
	 */
	public int lengthOfLongestSubstring1(String str) {
		int res = 0, tmp = 0;
		for(int j = 0; j < str.length(); j ++) {
			int i = j  -1;
			while(i >= 0 && str.charAt(i) != str.charAt(j)) {
				i --;    // ���Բ���
			}
			tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
			res = Math.max(res, tmp);
		}
		return res;
	}
	
	/** 
	 * �ⷨ����˫ָ��+��ϣ��
	 * ʱ�临�Ӷȣ�O(N)������NΪ�ַ������ȣ���̬�滮���������dp�б�
	 * �ռ临�Ӷȣ�O(1)����������ʹ�ó�����С�Ŀռ䡣
	 */
	public int lengthOfLongestSubstring2(String str) {
		Map<Character, Integer> dic = new HashMap<>();
		int i = -1, res = 0;
		for(int j = 0; j < str.length(); j ++) {
			if(dic.containsKey(str.charAt(j))) {
				i = Math.max(i, dic.get(str.charAt(j)));    // ������ָ�� i
			}
			dic.put(str.charAt(j), j);     // ��ϣ���¼
			res = Math.max(res, j - i);   // ���½��
		}
		return res;
	}
}
