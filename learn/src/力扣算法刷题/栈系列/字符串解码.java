package 力扣算法刷题.栈系列;

import java.util.Collections;
import java.util.LinkedList;

public class 字符串解码 {
	private static int ptr;
	private static int ptr2;
	private static String src;

	/** 
	 * 题目：给定一个经过编码的字符串，返回它解码后的字符串。
	 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string
	 * 正好重复 k 次。注意 k 保证为正整数。
	 * 
	 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入
	 * 的方括号总是符合格式要求的。
	 * 
	 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k
	 * ，例如不会出现像 3a 或 2[4] 的输入。
	 * 
	 * 示例：输入：s = "3[a]2[bc]"
	 *     输出："aaabcbc"
	 */
	
	public static void main(String [] args) {
		System.out.println("栈操作的结果为：" + decodeString("3[a]2[bc]"));
		System.out.println("递归操作的结果为：" + decodeString1("3[a]2[bc]"));
	}
	
	/** 
	 * 解法一：栈操作
	 * 时间复杂度：O(S)
	 * 空间复杂度：O(S)
	 */
	public static String decodeString(String s) {
		LinkedList<String> stk = new LinkedList<String>();
		ptr = 0;
		while(ptr < s.length()) {
			char cur = s.charAt(ptr);
			if(Character.isDigit(cur)) {
				// 获取一个数字并进栈
				String digits = getDigits(s);
				stk.addLast(digits);
			}else if(Character.isLetter(cur) || cur == '[') {
				// 获取一个字母并进栈
				stk.addLast(String.valueOf(s.charAt(ptr++)));
			}else {
				++ptr;
				LinkedList<String> sub = new LinkedList<String>();
				while(!"[".equals(stk.peekLast())) {
					sub.addLast(stk.removeLast());
				}
				Collections.reverse(sub);
				// 左括号出栈
				stk.removeLast();
				// 此时栈顶为当前sub对应的字符串应该出现的次数
				int repTime = Integer.parseInt(stk.removeLast());
				StringBuilder t = new StringBuilder();
				String o = getString(sub);
				// 构造字符串
				while(repTime -- > 0) {
					t.append(o);
				}
				// 将构造好的字符串入栈
				stk.addLast(t.toString());
			}
		}
		return getString(stk);
	}
	
	/** 
	 * 获取数字的部分 
	 */
	private static String getDigits(String s) {
		StringBuilder sdf = new StringBuilder();
		while(Character.isDigit(s.charAt(ptr))) {
			sdf.append(s.charAt(ptr ++));
		}
		return sdf.toString();
	}
	
	/** 
	 * 获取字符部分 
	 */
	private static String getString(LinkedList<String> v) {
		StringBuilder sdf = new StringBuilder();
		for(String s : v) {
			sdf.append(s);
		}
		return sdf.toString();
	}
	
	/** 
	 * 解法二：递归方法
	 * 时间复杂度：O(s)
	 * 空间复杂度：O(s)
	 */
	public static String  decodeString1(String str) {
		src = str;
		ptr2 = 0;
		return getString1();
	}

	/** 
	 * 解法二的字符串解码方法
	 * 时间复杂度：O(s)
	 * 空间复杂度：O(s)
	 */
	private static String getString1() {
		// 递归的结束条件判断
		if(ptr2 == src.length() || src.charAt(ptr2) == ']') {
			return "";
		}
		char cur = src.charAt(ptr2);
		int repTime = 1;
		String ret = "";
		if(Character.isDigit(cur)) {
			// String -> Digits [ String ] String
			// 解析 Digits
			repTime = getDigits();
			// 过滤左括号
			++ ptr2;
			// 解析String
			String str = getString1();
			// 过滤右括号
			++ ptr2;
			// 构造字符串
			while(repTime -- > 0) {
				ret += str;
			}
		}else if(Character.isLetter(cur)) {
			// String -> Char String
			// 解析 Char
			ret = String.valueOf(src.charAt(ptr2 ++));
		}
		return ret + getString1();
	}
	
	private static int getDigits() {
		int ret = 0;
		while(ptr2 < src.length() && Character.isDigit(src.charAt(ptr2))) {
			ret = ret * 10 + src.charAt(ptr2 ++) - '0';
		}
		return ret;
	}
}
