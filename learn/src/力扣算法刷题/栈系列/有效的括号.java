package 力扣算法刷题.栈系列;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class 有效的括号 {
	/**
	 * 题目：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
	 * 有效字符串需满足：
	 *      1、左括号必须用相同类型的右括号闭合。
	 *      2、左括号必须以正确的顺序闭合
	 * 注意空字符串可被认为是有效字符串
	 */
	
	/**
	 * 栈的解法：
	 * 时间复杂度：n，n是字符串str的长度
	 * 空间复杂度： O(n+∣Σ∣)，其中 Σ 表示字符集，本题中字符串只包含 66种括号，|Σ| = 6
	 */
	public static boolean fun(String str) {
		int n = str.length();
		if(n % 2 == 1) {
			return false;
		}
		Map<Character, Character> pairs = new HashMap<Character, Character>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				put(')', '(');
				put(']', '[');
				put('}', '{');
			}
		};
		// 申明一个栈结构
		Deque<Character> stack = new LinkedList<Character>();
		for(int i = 0; i < n; i ++) {
			char ch = str.charAt(i);
			if(pairs.containsKey(ch)) {
				if(stack.isEmpty() || stack.peek() != pairs.get(ch)) {
					return false;
				}
				stack.pop();
			}else {
				stack.push(ch);
			}
		}
		return stack.isEmpty();
	}
}
