package 力扣算法刷题.双指针系列;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串 {
	
	/** 
	 * 题目：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
	 */
	
	/** 
	 * 示例：
	 *    输入： 
	 *        s = "abcabcbb"
	 *    输出：3
	 *    解释：因为无重复字符的最长子串是"abc"，所以其长度为3。
	 *    
	 *    输入：s="bbbbb"
	 *    输出：1
	 *    解释：因为无重复字符的最长子串是"b"，所以其长度为1。
	 *    
	 *    输入：s = "pwwkew"
	 *    输出：3
	 *    解释：因为无重复字符的最长子串是 "wke"，所以其长度为 3。
	 *        请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
	 *        
	 *    输入：s = ""
	 *    输出：0
	 */
	
	/** 
	 * 测试：
	 */
	public static void main(String[] args) {
		String str = "abcabcbb";
		无重复字符的最长子串 obj = new 无重复字符的最长子串();
		System.out.println("滑动窗口的解法的结果为：" + obj.lengthOfLongestSubstring(str));
		str = "bbbbb";
		System.out.println("滑动窗口的解法的结果为：" + obj.lengthOfLongestSubstring(str));
		str = "pwwkew";
		System.out.println("滑动窗口的解法的结果为：" + obj.lengthOfLongestSubstring(str));
		str = "";
		System.out.println("滑动窗口的解法的结果为：" + obj.lengthOfLongestSubstring(str));
	}
	
	/** 
	 * 解法一：滑动窗口
	 * 时间复杂度：O(N)，其中N是字符串的长度。左指针和右指针分别会遍历整个字符串一次。
	 * 空间复杂度：O(∣Σ∣)，其中Σ 表示字符集（即字符串中可以出现的字符），∣Σ∣ 表示字符集的大小。在
	 *         本题中没有明确说明字符集，因此可以默认为所有 ASCII 码在 [0,128) 内的字符，即 ∣Σ∣=128。我们
	 *         需要用到哈希集合来存储出现过的字符，而字符最多有∣Σ∣ 个，因此空间复杂度为 O(∣Σ∣)。
	 */
	public int lengthOfLongestSubstring(String str) {
		// 哈希集合，记录每个字符是否出现过
		Set<Character> occ = new HashSet<>();
		int n = str.length();
		// 右指针，初始值为-1，相当于我们在字符串的左边界的左侧，还没有开始移动
		int rk = -1, ans = 0;
		for(int i = 0; i < n; ++ i) {
			if(i != 0) {
				// 左指针向右移动一格，移除一格字符
				occ.remove(str.charAt(i - 1));
			}
			while(rk + 1 < n && !occ.contains(str.charAt(rk + 1))) {
				// 不断的移动右指针
				occ.add(str.charAt(rk + 1));
				++ rk;
			}
			// 第i 到rk个字符是一个极长的无重复字符子串
			ans = Math.max(ans, rk - i + 1);
		}
		return ans;
	}

}
