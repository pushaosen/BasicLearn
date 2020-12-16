package 力扣算法刷题.栈系列;

import java.util.Stack;

public class 括号的分数 {

	/** 
	 * 题目：给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
	 * () 得 1 分
	 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
	 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
	 */
	
	public static void main(String[] args) {
		String s = "(()(()))";
		System.out.println("分治的思想得出的结果为：" + scoreOfParentheses(s));
		System.out.println("栈解法得出的结果为：" + scoreOfParentheses1(s));
		System.out.println("统计核心的数目得出的结果为：" + scoreOfParentheses2(s));
	}
	
	/** 
	 * 解法一： 分治的思想
	 * 时间复杂度：O(N*N)
	 * 空间复杂度：O(N)
	 */
	public static int scoreOfParentheses(String s) {
		return fun(s, 0, s.length());
	}
	
	private static int fun(String s, int i, int j) {
		int ans = 0, bal  =0;
		for(int k = i; k < j; ++ k) {
			bal += s.charAt(k) == '(' ? 1 : -1;
			if(bal == 0) {
				if(k - i == 1) {
					ans ++;
				}else {
					ans += 2 * fun(s, i + 1, k);
				}
				i = k + 1;
			}
		}
		return ans;
	}
	
	/** 
	 * 解法二：栈
	 * 时间复杂度：O(N)，其中N是字符串S的长度
	 * 空间复杂度：O(N)，为栈的大小
	 */
	public static int scoreOfParentheses1(String s) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		
		for(char c : s.toCharArray()) {
			if(c == '(') {
				stack.push(0);
			}else {
				int v = stack.pop();
				int w = stack.pop();
				stack.push(w + Math.max(2 * v, 1));
			}
		}
		return stack.pop();
	} 
	
	/** 
	 * 统计核心的数目
	 * 时间复杂度：O(N)
	 * 空间复杂度：O(1) 
	 */
	public static int scoreOfParentheses2(String s) {
		int ans = 0, bal = 0;
		for(int i = 0; i < s.length(); ++ i) {
			if(s.charAt(i) == '(') {
				bal ++;
			}else {
				bal --;
				if(s.charAt(i - 1) == '(') {
					ans += 1 << bal; 
				}
			}
		}
		return ans;
	}
}
