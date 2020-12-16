package 力扣算法刷题.栈系列;

import java.util.Stack;

public class 检查替换后的词是否有效 {

	/** 
	 * 题目：给定有效字符串 "abc"。
	 * 对于任何有效的字符串 V，我们可以将 V 分成两个部分 X 和 Y，使得 
	 * X + Y（X 与 Y 连接）等于 V。（X 或 Y 可以为空。）那么，X + 
	 * "abc" + Y 也同样是有效的。
	 */
	
	/** 
	 * 解法一：使用栈来解此题 
	 * 消耗时间：大致148ms
	 */
	public boolean isValid(String str) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str.length(); i ++) {
			if(str.charAt(i) == 'c') {
				if(stack.empty() || stack.pop() != 'b') {
					return false;
				}
				if(stack.empty() || stack.pop() != 'a') {
					return false;
				}
			}else {
				stack.push(str.charAt(i));
			}
		}
		return stack.isEmpty();
	}
	
	/** 
	 * 解法二：适合刚入门的小伙伴 
	 * 递归：大约是64ms
	 */
	public static boolean isValid1(String str) {
		while(str.contains("abc")) {
			str.replace("abc", "");
		}
		return str.equals("");
	}
}
