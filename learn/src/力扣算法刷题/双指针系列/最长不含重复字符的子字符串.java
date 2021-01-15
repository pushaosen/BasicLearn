package 力扣算法刷题.双指针系列;

import java.util.HashMap;
import java.util.Map;

public class 最长不含重复字符的子字符串 {
	
	/** 
	 * 题目：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
	 */
	
	/** 
	 * 示例：
	 *    输入："abcabcbb"
	 *    输出：3
	 *    解释：因为无重复字符的最长子串是 "abc"，所以其长度为 3。
	 *    
	 *    输入："bbbbb"
	 *    输出：1
	 *    解释：因为无重复字符的最长子串是 "b"，所以其长度为 1。
	 *    
	 *    输入："pwwkew"
	 *    输出：3
	 *    解释：因为无重复字符的最长子串是 "wke"，所以其长度为 3。
	 *        请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		
	}
	
	/** 
	 * 解法一：动态规划+哈希表
	 * 时间复杂度：O(N)，其中N为字符串长度，动态规划需遍历计算dp列表
	 * 空间复杂度：O(1)，字符的ASCII码范围为0-127，哈希表dic最多使用O(128) = O(1)大小的额外空间。
	 */
	public int lengthOfLongestSubstring(String str) {
		Map<Character, Integer> dic = new HashMap<Character, Integer>();
		int res = 0, tmp = 0;
		for(int j = 0; j < str.length(); j ++) {
			int i = dic.getOrDefault(str.charAt(j), -1);  // 获取索引i
			dic.put(str.charAt(j), j);   // 更新哈希表
			tmp = tmp < j - i ? tmp + 1 : j - i;    // dp[j - 1] -> dp[j]
			res = Math.max(res, tmp);    // max(dp[j - 1], dp[j])
		}
		return res;
	}
	
	/** 
	 * 解法二：动态规划+线性遍历
	 * 时间复杂度：O(N*N)，其中N为字符串长度，动态规划需遍历计算dp列表，占用O(N)，每轮计算dp[j]时搜索i需要遍历j个字符，占用O(N)
	 * 空间复杂度：O(1)，几个变量使用常数大小的空间
	 */
	public int lengthOfLongestSubstring1(String str) {
		int res = 0, tmp = 0;
		for(int j = 0; j < str.length(); j ++) {
			int i = j  -1;
			while(i >= 0 && str.charAt(i) != str.charAt(j)) {
				i --;    // 线性查找
			}
			tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
			res = Math.max(res, tmp);
		}
		return res;
	}
	
	/** 
	 * 解法三：双指针+哈希表
	 * 时间复杂度：O(N)，其中N为字符串长度，动态规划需遍历计算dp列表。
	 * 空间复杂度：O(1)，几个变量使用常数大小的空间。
	 */
	public int lengthOfLongestSubstring2(String str) {
		Map<Character, Integer> dic = new HashMap<>();
		int i = -1, res = 0;
		for(int j = 0; j < str.length(); j ++) {
			if(dic.containsKey(str.charAt(j))) {
				i = Math.max(i, dic.get(str.charAt(j)));    // 更新左指针 i
			}
			dic.put(str.charAt(j), j);     // 哈希表记录
			res = Math.max(res, j - i);   // 更新结果
		}
		return res;
	}
}
