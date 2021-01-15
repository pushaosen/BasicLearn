package 力扣算法刷题.递归系列;

public class 实现strStr {
	
	/** 
	 * 题目：给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符
	 *     串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
	 */
	
	/** 
	 * 示例：
	 *    输入：haystack = "hello", needle = "ll"
	 *    输出：2
	 *    
	 *    
	 *    输入： haystack = "aaaaa", needle = "bba"
	 *    输出：-1
	 *    
	 *    
	 * 说明：
	 *    当needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
	 */
	
	/** 
	 * 解法一：子串逐一比较-线性时间复杂度
	 * 时间复杂度：O((N−L)L)，其中 N 为 haystack 字符串的长度，L 为 needle 字符串的长度。内循环中比较字符串的复杂度为 L，总共需要比较 (N - L) 次。
	 * 空间复杂度：O(1)
	 */
	public int strStr(String haystack, String needle) {
		int L = needle.length(), n = haystack.length();
		
		for(int start = 0; start < n - L + 1; ++ start) {
			if(haystack.subSequence(start, start + L).equals(needle)) {
				return start;
			}
		}
		return -1;
	}
	
	/** 
	 * 解法二：双指针 - 线性时间复杂度
	 * 时间复杂度：最坏时间复杂度为 O((N - L)L)，最优时间复杂度为 O(N)。
	 * 空间复杂度：O(1)
	 */
	public int strStr1(String haystack, String needle) {
		int L = needle.length(), n = haystack.length();
		if(L == 0) {
			return 0;
		}
		
		int pn = 0;
		while (pn < n - L + 1) {
			while(pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) {
				++ pn;
			}
			int currLen = 0, pL = 0;
			while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
				++ pn;
				++ pL;
				++ currLen;
			}
			
			if(currLen == L) {
				return pn - L;
			}
			
			pn = pn -currLen + 1;
		}
		return -1;
	}

}
