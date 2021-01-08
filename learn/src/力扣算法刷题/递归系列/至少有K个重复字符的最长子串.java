package �����㷨ˢ��.�ݹ�ϵ��;

import java.util.HashMap;
import java.util.Map;

public class ������K���ظ��ַ�����Ӵ� {

	/** 
	 * ��Ŀ���ҵ������ַ�������Сд�ַ���ɣ��е���Ӵ� T �� Ҫ�� T �е�ÿһ�ַ����ִ����������� k ����� T �ĳ��ȡ�
	 */
	
	/** 
	 * ʾ����
	 *     ���룺s = "aaabb", k = 3
	 *     �����3
	 *     
	 *     ��Ӵ�Ϊ"aaa"������'a'�ظ���3��
	 *     
	 *     ���룺s = "ababbc", k = 2
	 *     �����5
	 *     
	 *     ��Ӵ�Ϊ "ababb" ������ 'a' �ظ��� 2 �Σ� 'b' �ظ��� 3 �Ρ�
	 */
	
	/** 
	 * ����
	 */
	public static void main(String[] args) {
		������K���ظ��ַ�����Ӵ� obj = new ������K���ظ��ַ�����Ӵ�();
		String str = "aaabb";
		int k = 3;
		System.out.println("�����ĵݹ�ⷨ�Ľ��Ϊ��" + obj.longestSubstring(str, k));
		System.out.println("�ݹ�+��ϣ�ⷨ�Ľ��Ϊ��" + obj.longestSubstring1(str, k));
		System.out.println("�ݹ�+����ⷨ�Ľ��Ϊ��" + obj.longestSubstring2(str, k));
		str = "ababbc";
		k = 2;
		System.out.println("�����ĵݹ�ⷨ�Ľ��Ϊ��" + obj.longestSubstring(str, k));
		System.out.println("�ݹ�+��ϣ�ⷨ�Ľ��Ϊ��" + obj.longestSubstring1(str, k));
		System.out.println("�ݹ�+����ⷨ�Ľ��Ϊ��" + obj.longestSubstring2(str, k));
	}
	
	/** 
	 * �ⷨһ���ݹ�
	 * ����˼·���ؼ����ڣ����һ���Ӵ������������в���K�����ַ���������Ӵ���һ������������
	 *       ���һ������û���������ַ����Ǿ�ֱ�ӷ������ĳ��ȼ��ɣ�
	 *       ����У��Ǿ�������ַ������Ӵ����ݹ��ж��Ӵ��Ƿ����㡣
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 */
	public int longestSubstring(String str, int k) {
		int res = 0;
		boolean[] m = new boolean[26];
		int[] mid = new int[26];
		for(int i = 0; i < str.length(); i ++) {
			mid[str.charAt(i) - 'a'] ++;
		}
		for(int i = 0; i < mid.length; i ++) {
			if(mid[i] < k) {
				m[i] = true;
			}
		}
		int start = 0;
		boolean f = true;
		for(int i = 0; i < str.length(); i ++) {
			if(m[str.charAt(i) - 'a']) {
				f = false;
				if(start < i) {
					res = Integer.max(res, longestSubstring(str.substring(start, i), k));
				}
				start = i + 1;
			}
		}
		if(f) {
			res = str.length();
		}else {
			if(start < str.length()) {
				res = Integer.max(res, longestSubstring(str.substring(start, str.length()), k));
			}
		}
		return res;
	}
	
	/** 
	 * �ⷨ������ϣ+�ݹ�
	 */
	public int longestSubstring1(String str, int k) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		// ʹ�ù�ϣ��,���ó�ÿ��Ԫ�س��ֵĴ���
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(char chs : str.toCharArray()) {
			map.put(chs, map.getOrDefault(chs, 0) + 1);
		}
		// �������Ȱ�str����sb�����ҳ�������k����Ԫ�ؼ���λ��
		StringBuilder sb = new StringBuilder(str);
		for(int i = 0; i < str.length(); i ++) {
			if(map.get(str.charAt(i)) < k) {
				sb.setCharAt(i, ',');
			}
		}
		
		// Ȼ���Բ�����Ҫ���Ԫ��λ�ý��зָ�洢���ַ���������
		String[] string = sb.toString().split(",");
		// �������һ�飬��˵��ֻ��һ����ĸ����������ĸ����
		if(string.length == 1) {
			return string[0].length();
		}
		int max = 0;
		// ����ж��飬�ͽ������ֵ�Ƚ�
		// ����aaabccc��ͨ������Ĳ�����  ��Ϊ aaa��ccc
		for(String s : string) {
			max = Math.max(max, longestSubstring1(s, k));
		}
		return max;
	}
	
	/** 
	 * �ⷨ����ʹ������+�ݹ�
	 */
	public int longestSubstring2(String str, int k) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		
		// ʹ�����飬Ч�ʸ�
		// ��������д��ĸ��������128�������������ASCII�룬����256
		int[] hash = new int[26];
		for(int i = 0; i < str.length(); i ++) {
			hash[str.charAt(i) - 'a'] ++;
		}
		
		// �Ƿ������ַ���������Ҫ��
		boolean fullString = true;
		for(int i = 0; i < str.length(); i ++) {
			// ������ĸС��k������˵�������ַ����������ϣ���Ҫ�����ж�
			if(hash[str.charAt(i) - 'a'] > 0 && hash[str.charAt(i) - 'a'] < k) {
				fullString = false;
			}
		}
		if(fullString == true) {
			return str.length();
		}
		
		// ��������
		int left = 0;
		int right = 0;
		int max = 0;
		while(right < str.length()) {
			// �������right��ָԪ�ظ���С��k������Ҫ�ɴ˲����Ƚ�����λ��
			if(hash[str.charAt(right) - 'a'] < k) {
				// aaabcccc
				// l  r   ����ҿ�������ȡ������ aaa
				max = Math.max(max, longestSubstring2(str.substring(left, right), k));
				left = right + 1;
			}
			right ++;
		}
		// aaabccc
		// l r   ��ȡ������ cccc
		max = Math.max(max, longestSubstring2(str.substring(left), k));
		return max;
	}
}
