package 力扣算法刷题.递归系列;

import java.util.HashMap;
import java.util.Map;

public class 至少有K个重复字符的最长子串 {

	/** 
	 * 题目：找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
	 */
	
	/** 
	 * 示例：
	 *     输入：s = "aaabb", k = 3
	 *     输出：3
	 *     
	 *     最长子串为"aaa"，其中'a'重复了3次
	 *     
	 *     输入：s = "ababbc", k = 2
	 *     输出：5
	 *     
	 *     最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		至少有K个重复字符的最长子串 obj = new 至少有K个重复字符的最长子串();
		String str = "aaabb";
		int k = 3;
		System.out.println("单纯的递归解法的结果为：" + obj.longestSubstring(str, k));
		System.out.println("递归+哈希解法的结果为：" + obj.longestSubstring1(str, k));
		System.out.println("递归+数组解法的结果为：" + obj.longestSubstring2(str, k));
		str = "ababbc";
		k = 2;
		System.out.println("单纯的递归解法的结果为：" + obj.longestSubstring(str, k));
		System.out.println("递归+哈希解法的结果为：" + obj.longestSubstring1(str, k));
		System.out.println("递归+数组解法的结果为：" + obj.longestSubstring2(str, k));
	}
	
	/** 
	 * 解法一：递归
	 * 解题思路：关键在于，如果一个子串包含整个串中不满K个的字符，那这个子串就一定不满足条件
	 *       如果一个串中没有这样的字符，那就直接返回它的长度即可，
	 *       如果有，那就以这个字符划分子串，递归判断子串是否满足。
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 */
	public int longestSubstring(String str, int k) {
		int res = 0;
		boolean[] m = new boolean[26];
		int[] mid = new int[26];
		for(int i = 0; i < str.length(); i ++) {
			mid[str.charAt(i) - 'a'] ++;
		}
		for(int i = 0; i < mid.length; i ++) {
			if(mid[i] < k) {
				m[i] = true;
			}
		}
		int start = 0;
		boolean f = true;
		for(int i = 0; i < str.length(); i ++) {
			if(m[str.charAt(i) - 'a']) {
				f = false;
				if(start < i) {
					res = Integer.max(res, longestSubstring(str.substring(start, i), k));
				}
				start = i + 1;
			}
		}
		if(f) {
			res = str.length();
		}else {
			if(start < str.length()) {
				res = Integer.max(res, longestSubstring(str.substring(start, str.length()), k));
			}
		}
		return res;
	}
	
	/** 
	 * 解法二：哈希+递归
	 */
	public int longestSubstring1(String str, int k) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		// 使用哈希表,先拿出每个元素出现的次数
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(char chs : str.toCharArray()) {
			map.put(chs, map.getOrDefault(chs, 0) + 1);
		}
		// 这里是先把str传进sb中来找出不满足k个的元素及其位置
		StringBuilder sb = new StringBuilder(str);
		for(int i = 0; i < str.length(); i ++) {
			if(map.get(str.charAt(i)) < k) {
				sb.setCharAt(i, ',');
			}
		}
		
		// 然后以不符合要求的元素位置进行分割存储到字符串数组中
		String[] string = sb.toString().split(",");
		// 如果仅有一组，则说明只有一个字母，返回首字母即可
		if(string.length == 1) {
			return string[0].length();
		}
		int max = 0;
		// 如果有多组，就进行最大值比较
		// 例如aaabccc，通过上面的操作后  化为 aaa，ccc
		for(String s : string) {
			max = Math.max(max, longestSubstring1(s, k));
		}
		return max;
	}
	
	/** 
	 * 解法三：使用数组+递归
	 */
	public int longestSubstring2(String str, int k) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		
		// 使用数组，效率高
		// 若包含大写字母，可以用128，如果包含其他ASCII码，可用256
		int[] hash = new int[26];
		for(int i = 0; i < str.length(); i ++) {
			hash[str.charAt(i) - 'a'] ++;
		}
		
		// 是否整个字符串都符合要求
		boolean fullString = true;
		for(int i = 0; i < str.length(); i ++) {
			// 若有字母小于k个，则说明整个字符串都不符合，需要拆开来判断
			if(hash[str.charAt(i) - 'a'] > 0 && hash[str.charAt(i) - 'a'] < k) {
				fullString = false;
			}
		}
		if(fullString == true) {
			return str.length();
		}
		
		// 滑动窗口
		int left = 0;
		int right = 0;
		int max = 0;
		while(right < str.length()) {
			// 如果遇到right所指元素个数小于k，则需要由此拆开来比较其它位置
			if(hash[str.charAt(right) - 'a'] < k) {
				// aaabcccc
				// l  r   左闭右开，所以取到的是 aaa
				max = Math.max(max, longestSubstring2(str.substring(left, right), k));
				left = right + 1;
			}
			right ++;
		}
		// aaabccc
		// l r   即取到的是 cccc
		max = Math.max(max, longestSubstring2(str.substring(left), k));
		return max;
	}
}
