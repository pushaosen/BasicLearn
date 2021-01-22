package 力扣算法刷题.哈希表系列;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class 第一个只出现一次的字符 {
	
	/** 
	 * 题目：在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
	 */
	
	/** 
	 * 示例：
	 *    输入：s = "abaccdeff"
	 *    输出："b"
	 *    
	 *    输入：s = ""
	 *    输出：" "
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		第一个只出现一次的字符 obj = new 第一个只出现一次的字符();
		String str = "abaccdeff";
		System.out.println("哈希表解法的结果为：" + obj.firstUniqChar(str));
		str = "";
		System.out.println("哈希表解法的结果为：" + obj.firstUniqChar(str));
	}
	
	/** 
	 * 解法一：哈希表
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 */
	public char firstUniqChar(String s) {
		HashMap<Character, Boolean> dic = new HashMap<>();
		char[] sc = s.toCharArray();
		for(char c : sc) {
			dic.put(c, !dic.containsKey(c));
		}
		for(char c : sc) {
			if(dic.get(c)) {
				return c;
			}
		}
		return ' ';
	}
	
	/** 
	 * 解法二：有序哈希表
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 */
	public char firstUniqChar2(String s) {
		Map<Character, Boolean> dic = new LinkedHashMap<>();
		char[] sc = s.toCharArray();
		for(char c : sc) {
			dic.put(c, !dic.containsKey(c));
		}
		for(Map.Entry<Character, Boolean> d : dic.entrySet()) {
			if(d.getValue()) {
				return d.getKey();
			}
		}
		return ' ';
	}

}
