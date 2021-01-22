package 力扣算法刷题.哈希表系列;

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
	 *    解释： 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
	 *    注意：请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		最长不含重复字符的子字符串 obj = new 最长不含重复字符的子字符串();
		String s = "abcabcbb";
		System.out.println("动态规划+哈希表的解法的结果为：" + obj.lengthOfLongestSubstring(s));
		s = "bbbbb";
		System.out.println("动态规划+哈希表的解法的结果为：" + obj.lengthOfLongestSubstring(s));
		s = "pwwkew";
		System.out.println("动态规划+哈希表的解法的结果为：" + obj.lengthOfLongestSubstring(s));
	}

	/** 
	 * 解法一：动态规划+哈希表
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 */
	public int lengthOfLongestSubstring(String s) {
		// 动态规划
		// 1、状态-状态为当前位置(会变化)
		// 2、dp函数定义-dp[n]，n代表当前位置，dp[n]代表当前位置的最大值
		// 3、选择-如果前面的字符包含n位置的字符，设这个相同的字符位置为m，则最大值为n-m，否则为dp[n-1]+1
		// 4、base case-dp[0] = 1;
		// 边界值检查
		if(s.length() == 0) {   // 字符为空时返回0
			return 0;
		}
		if(s.length() == 1) {   // 字符只有一个时返回1
			return 1;
		}
		int[] dp = new int[s.length()];
		dp[0] = 1;    // base case，当一个字符时为1
		int m = 0;    // m记录存在的字符的位置
	    int max = Integer.MIN_VALUE;
	    Map<Character, Integer> map = new HashMap<Character, Integer>();
	    map.put(s.charAt(0), 0);
	    for(int n = 1; n < s.length(); n ++) {
	    	if(map.containsKey(s.charAt(n))) {
	    		int temp = map.get(s.charAt(n));
	    		if(temp > m) {   // 当已经存在的字符位置在m后面时才更新m的值
	    			m = temp;
	    		}
	    		dp[n] = n - m;
	    	}else {
	    		dp[n] = dp[n - 1] + 1;
	    	}
	    	map.put(s.charAt(n), n);    // 更新重复的值
	    	max = Math.max(max, dp[n]);    // 取遍历过程中最大的值作为结果
	    }
	    return max;
	}
	
	/** 
	 * 解法二：动态规划+哈希表
	 * 时间复杂度：O(N)
	 * 空间复杂度：O(1)
	 */
	public int lengthOfLongestSubstring1(String s) {
		Map<Character, Integer> dic = new HashMap<>();
		int res = 0, tmp = 0;
		for(int j = 0; j < s.length(); j ++) {
			int i = dic.getOrDefault(s.charAt(j), -1);   // 获取索引i
			dic.put(s.charAt(j), j);    // 更新哈希表
			tmp = tmp < j - i ? tmp + 1 : j - i;   // dp[j-1] -> dp[j]
			res = Math.max(res, tmp);    // max(dp[j-1], dp[j])
		}
		return res;
	}
	
	/** 
	 * 解法三：动态规划+线性遍历
	 * 时间复杂度：O(n*n)
	 * 空间复杂度：O(1)
	 */
	public int lengthOfLongestSubstring2(String s) {
		int res = 0, tmp = 0;
		for(int j = 0; j < s.length(); j ++) {
			int i = j - 1;
			while(i >= 0 && s.charAt(i) != s.charAt(j)) {
				i --;    // 线性查找i
			}
			tmp = tmp < j - i ? tmp + 1: j - i;  // dp[j-1] -> dp[j]
			res = Math.max(res, tmp);
		}
		return res;
	}
	
	/** 
	 * 解法四：双指针+哈希表
	 * 时间复杂度：O(N)
	 * 空间复杂度：O(1)
	 */
	public int lengthOfLongestSubstring3(String s) {
		Map<Character, Integer> dic = new HashMap<>();
		int i = -1, res = 0;
		for(int j = 0; j < s.length(); j ++) {
			if(dic.containsKey(s.charAt(j))) {
				i = Math.max(i, dic.get(s.charAt(j)));    // 更新左指针 i
			}
			dic.put(s.charAt(j), j);       // 哈希表记录
			res = Math.max(res, j - i);     // 更新记录
		}
		return res;
	}
}
