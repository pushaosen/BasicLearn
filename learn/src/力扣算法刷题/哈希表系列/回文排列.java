package 力扣算法刷题.哈希表系列;

import java.util.HashSet;
import java.util.Set;

public class 回文排列 {
	
	/** 
	 * 题目：给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
	 *     回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
	 *     回文串不一定是字典当中的单词。
	 */
	
	/** 
	 * 示例：
	 *    输入："tactcoa"
	 *    输出：true（排列有"tacocat"、"atcocta"，等等）
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		String s = "tactcoa";
		回文排列 obj = new 回文排列();
		System.out.println("哈希表的解法的结果为：" + obj.canPermutePalindrome(s));
	}
	
	/** 
	 * 解法一：哈希表
	 */
	public boolean canPermutePalindrome(String s) {
		Set<Character> set = new HashSet<>();
		for(char c : s.toCharArray()) {
			if(!set.add(c)) {
				set.remove(c);
			}
		}
		return set.size() <= 1;
	}
	
	/** 
	 * 解法二：用数组实现
	 */
	public boolean canPermutePalindrome2(String s) {
		int[] map = new int[256];
		int count = 0;
		for(char c : s.toCharArray()) {
			if((map[c]++ & 1) == 1) {
				count --;
			}else {
				count ++;
			}
		}
		return count <= 1;
	}

}
