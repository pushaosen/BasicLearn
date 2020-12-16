package �����㷨ˢ��.ջϵ��;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class ȥ���ظ���ĸ {

	/** 
	 * ��Ŀ������һ���ַ��� s ������ȥ���ַ������ظ�����ĸ��ʹ��ÿ����ĸֻ����һ�Ρ�
	 * �豣֤ ���ؽ�����ֵ�����С��Ҫ���ܴ��������ַ������λ�ã���
	 */
	
	public static void main(String[] args) {
		String str = "bca";
		System.out.println("һ��һ���ַ�������Ϊ��" + fun(str));
		System.out.println("̰��--��ջ������Ϊ��" + removeDuplicateLetters(str));
	}
	
	/** 
	 * �ⷨһ��̰�ģ�һ��һ���ַ�����
	 * ʱ�临�Ӷȣ�O(N)
	 * �ռ临�Ӷȣ�O(N)
	 */
	public static String fun(String s) {
		int[] cnt = new int[26];
		int pos = 0;
		for(int i = 0; i < s.length(); i ++) {
			cnt[s.charAt(i) - 'a']++;
		}
		for(int i = 0; i < s.length(); i ++) {
			if(s.charAt(i) < s.charAt(pos)) {
				pos = i;
			}
			if (--cnt[s.charAt(i) - 'a'] == 0) {
				break;
			}
		}
		return s.length() == 0 ? "" : 
			s.charAt(pos) + fun(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
	}
	
	/** 
	 * �ⷨ����̰��--��ջ
	 * ʱ�临�Ӷȣ�O(N)
	 * �ռ临�Ӷȣ�O(1)
	 */
	public static String removeDuplicateLetters(String s) {
		Stack<Character> stack = new Stack<>();
		// hashSet����ȥ��
		HashSet<Character> seen = new HashSet<>();
		HashMap<Character, Integer> last_occurrence = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			last_occurrence.put(s.charAt(i), i);
		}
		for(int i = 0; i < s.length(); i ++) {
			char c = s.charAt(i);
			if(!seen.contains(c)) {
				while(!stack.isEmpty() && c < stack.peek() && last_occurrence.get(stack.peek()) > i) {
					seen.remove(stack.pop());
				}
				seen.add(c);
				stack.push(c);
			}
		}
		StringBuilder sb = new StringBuilder(stack.size());
		for(Character c : stack) {
			sb.append(c.charValue());
		}
		return sb.toString();
	}
}
