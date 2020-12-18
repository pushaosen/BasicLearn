package 力扣算法刷题.栈系列;

import java.util.Stack;

public class 反转每对括号间的子串 {

	/** 
	 * 题目：给出一个字符串 s（仅含有小写英文字母和括号）
	 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
	 * 注意：你的结果中不应包含任何括号。
	 */
	
	/** 
	 * 示例1：
	 *      输入："(u(love)i)"
	 *      输出："iloveu"
	 */
	
	public static void main(String[] args) {
		反转每对括号间的子串 obj = new 反转每对括号间的子串();
		String str = "(u(love)i)";
		System.out.println("栈解法的结果为：" + obj.reverseParentheses(str));
		System.out.println("使用递归解法的结果为：" + obj.reverseParentheses1(str));
	}
	
	/** 
	 * 解法一：使用栈的方法 
	 */
	public String reverseParentheses(String str) {
		StringBuilder sb = new StringBuilder();
		char[] arr = str.toCharArray();
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < arr.length; i ++) {
			if(arr[i] == '(') {
				stack.push(i);
			}
			if(arr[i] == ')') {
				reverse(arr, stack.pop() + 1, i -1);
			}
		}
		
		for(int i = 0; i < arr.length; i ++) {
			if(arr[i] != ')' && arr[i] != '(') {
				sb.append(arr[i]);
			}
		}
		
		return sb.toString();
	}
	
	private void reverse(char[] arr, int left, int right) {
		while(right > left) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			right --;
			left ++;
		}
	}
	
	/** 
	 * 解法二：使用递归
	 */
	int idx = -1;
	public String reverseParentheses1(String str) {
		StringBuilder sb = new StringBuilder();
		while(++ idx < str.length()) {
			char c = str.charAt(idx);
			if(c == '(') {
				sb.append((new StringBuilder(reverseParentheses1(str))).reverse());
			}else if(c == ')') {
				break;
			}else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/** 
	 * 解法三：两遍遍历，时间复杂度o(n)空间复杂度o(n)
	 */
	private int[] parent;
	public String reverseParentheses2(String str) {
		parent = new int[str.length()];
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < str.toCharArray().length; i ++) {
			if(str.charAt(i) == '(') {
				stack.push(i);
			}else if(str.charAt(i) == ')') {
				int f = stack.pop();
				parent[f] = i;
				parent[i] = f;
			}
		}
		StringBuilder sb = new StringBuilder(str.length());
		reverse(str, 0, str.length() - 1, false, sb);
		return sb.toString();
	}
	
	private void reverse(String str, int start, int end, boolean reversed, StringBuilder sb) {
		if(reversed) {
			for(int i = end; i >= start; i --) {
				if(str.charAt(i) == ')') {
					reverse(str, parent[i] + 1, i - 1, false, sb);
					i = parent[i];
				}else {
					
				}
			}
		}
	}
	
}
