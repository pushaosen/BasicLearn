package 力扣算法刷题.堆系列;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 重构字符串 {

	/* 
	 * 题目： 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
	 *     若同行，输出任意可行的结果。若不可行，返回空字符串。
	 */
	
	/** 
	 * 示例：
	 *     输入：S = "aab"
	 *     输出："aba"
	 *     
	 *     输入：S = "aaab"
	 *     输出：""
	 */
	
	public static void main(String[] args) {
		重构字符串 obj = new 重构字符串();
		String str = "aab";
		String str1 = "aaab";
		System.out.println("基于最大堆的贪心算法的结果为：" + obj.reorganizeString(str));
		System.out.println("基于最大堆的贪心算法的结果为：" + obj.reorganizeString(str1));
		System.out.println("基于计数的贪心算法的结果为：" + obj.reorganizeString1(str));
		System.out.println("基于计数的贪心算法的结果为：" + obj.reorganizeString1(str1));
	}
	
	/** 
	 * 解法一：基于最大堆的贪心算法
	 * 
	 */
	public String reorganizeString(String str) {
		if(str.length() < 2) {
			return str;
		}
		int[] counts = new int[26];
		int maxCount = 0;
		int length = str.length();
		for(int i = 0; i < length; i ++) {
			char c = str.charAt(i);
			counts[c - 'a'] ++;
			maxCount = Math.max(maxCount, counts[c - 'a']);
		}
		if(maxCount > (length + 1) / 2) {
			return "";
		}
		// 申明一个排序的优先队列（降序）
		PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
			public int compare(Character c1, Character c2) {
				return counts[c2 - 'a'] - counts[c1 - 'a'];
			}
		});
		for(char c = 'a'; c <= 'z'; c ++) {
			if(counts[c - 'a'] > 0) {
				queue.offer(c);
			}
		}
		StringBuilder sdf = new StringBuilder();
		while(queue.size() > 1) {
			char c1 = queue.poll();
			char c2 = queue.poll();
			sdf.append(c1);
			sdf.append(c2);
			int index1 = c1 - 'a', index2 = c2 - 'a';
			counts[index1] --;
			counts[index2] --;
			if(counts[index1] > 0) {
				queue.offer(c1);
			}
			if(counts[index2] > 0) {
				queue.offer(c2);
			}
		}
		if(queue.size() > 0) {
			sdf.append(queue.poll());
		}
		return sdf.toString();
	}
	
	/** 
	 * 解法二：基于计数的贪心算法
	 */
	public String reorganizeString1(String str) {
		if(str.length() < 2) {
			return str;
		}
		int[] counts = new int[26];
		int maxCount = 0;
		int length = str.length();
		for(int i = 0; i < length; i ++) {
			char c = str.charAt(i);
			counts[c - 'a'] ++;
			maxCount = Math.max(maxCount, counts[c-'a']);
		}
		if(maxCount > (length + 1) / 2) {
			return "";
		}
		char[] reorganizeArray = new char[length];
		int evenIndex = 0, oddIndex = 1;
		int halfLength = length / 2;
		for(int i = 0; i < 26; i ++) {
			char c = (char)('a' + i);
			while(counts[i] > 0 && counts[i] <= halfLength && oddIndex < length) {
				reorganizeArray[oddIndex] = c;
				counts[i] --;
				oddIndex += 2;
			}
			while(counts[i] > 0) {
				reorganizeArray[evenIndex] = c;
				counts[i] -- ;
				evenIndex += 2;
			}
		}
		return new String(reorganizeArray);
	}
}
