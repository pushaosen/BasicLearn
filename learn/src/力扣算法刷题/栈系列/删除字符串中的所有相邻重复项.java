package 力扣算法刷题.栈系列;

import java.util.Stack;

public class 删除字符串中的所有相邻重复项 {

	/** 
	 * 题目：给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的
	 * 字符串的左侧和右侧连在一起。
	 * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
	 * 在执行完所有删除操作后，返回最终得到的字符串。
	 */
	
	/** 
	 * 示例：
	 *     输入：s = "deeedbbcccbdaa", k = 3
	 *     输出："aa"
	 *     解释：
	 *         先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
	 *         再删除 "bbb"，得到 "dddaa"
	 *         最后删除 "ddd"，得到 "aa"
	 */
	
	public static void main(String[] args) {
		String str = "deeedbbcccbdaa";
		int k = 3;
		删除字符串中的所有相邻重复项 obj = new 删除字符串中的所有相邻重复项();
		System.out.println("暴力解法的结果为：" + obj.removeDuplicates(str, k));
		System.out.println("记忆计数解法的结果为：" + obj.removeDuplicates1(str, k));
		System.out.println("栈解法的结果为：" + obj.removeDuplicates2(str, k));
		System.out.println("双指针解法的结果为：" + obj.removeDuplicates3(str, k));
	}
	
	/* 
	 * 解法一：暴力解法
	 * 时间复杂度：O(n*n/k),其中n是字符串的长度
	 * 空间复杂度：O(1)
	 */
	public String removeDuplicates(String str, int k) {
		StringBuilder sb = new StringBuilder(str);
		int length = -1;
		while(length != sb.length()) {
			length = sb.length();
			for(int i = 0, count = 1; i < sb.length(); ++ i) {
				if(i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
					count = 1;
				}else if(++count == k) {
					sb.delete(i - k + 1, i + 1);
					break;
				}
			}
		}
		return sb.toString();
	}
	
	/** 
	 * 解法二：记忆计数
	 * 时间复杂度：O(n)，其中n是字符串长度。每个字符仅被处理一次。
	 * 空间复杂度：O(n)，存储每个字符的计数器
	 */
	public String removeDuplicates1(String str, int k) {
		StringBuilder sb = new StringBuilder(str);
		int[] count = new int[sb.length()];
		for(int i = 0; i < sb.length(); ++ i) {
			if(i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
				count[i] = 1;
			}else {
				count[i] = count[i - 1] + 1;
				if(count[i] == k) {
					sb.delete(i - k + 1, i + 1);
					i = i - k;
				}
			}
		}
		return sb.toString();
	}
	
	/** 
	 * 解法三：栈解法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 */
	public String removeDuplicates2(String str, int k) {
		StringBuilder sb = new StringBuilder(str);
		Stack<Integer> counts = new Stack<>();
		for(int i = 0; i < sb.length(); ++ i) {
			if(i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
				counts.push(1);
			}else {
				int incremented = counts.pop() + 1;
				if(incremented == k) {
					sb.delete(i - k + 1, i + 1);
					i = i - k;
				}else {
					counts.push(incremented);
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * 解法四：双指针
	 * 与方法三相同
	 */
	public String removeDuplicates3(String str, int k) {
		Stack<Integer> counts = new Stack<>();
		char[] sa = str.toCharArray();
		int j = 0;
		for(int i = 0; i < str.length(); ++i, ++j ) {
			sa[j] = sa[i];
			if(j == 0 || sa[j] != sa[j - 1]) {
				counts.push(1);
			}else {
				int incremented = counts.pop() + 1;
				if(incremented == k) {
					j = j - k;
				}else {
					counts.push(incremented);
				}
			}
		}
		return new String(sa, 0, j);
	}
}
