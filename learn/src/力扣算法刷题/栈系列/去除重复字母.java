package 力扣算法刷题.栈系列;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class 去除重复字母 {

	/** 
	 * 题目：给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
	 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
	 */
	
	public static void main(String[] args) {
		String str = "bca";
		System.out.println("一个一个字符处理结果为：" + fun(str));
		System.out.println("贪心--用栈处理结果为：" + removeDuplicateLetters(str));
	}
	
	/** 
	 * 解法一：贪心：一个一个字符处理
	 * 时间复杂度：O(N)
	 * 空间复杂度：O(N)
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
	 * 解法二：贪心--用栈
	 * 时间复杂度：O(N)
	 * 空间复杂度：O(1)
	 */
	public static String removeDuplicateLetters(String s) {
		Stack<Character> stack = new Stack<>();
		// hashSet进行去重
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
