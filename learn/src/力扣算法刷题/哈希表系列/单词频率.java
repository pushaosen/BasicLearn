package 力扣算法刷题.哈希表系列;

import java.util.HashMap;
import java.util.Map;

public class 单词频率 {
	
	/** 
	 * 题目：设计一个方法，找出任意指定单词在一本书中的出现频率。
	 *     你的实现应该支持如下操作：
	 *          WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
	 *          get(word)查询指定单词在书中出现的频率
	 */
	
	public static void main(String[] args) {
		单词频率 obj = new 单词频率();
		String[] strs = {"i", "have", "an", "apple", "he", "have", "a", "pen"};
		System.out.println("解法一的结果为：" + obj.getCount(strs, "have"));
	}
	
	/** 
	 * 解法一：HashMap
	 */
	@SuppressWarnings("unused")
	private int getCount(String[] book, String targetWord) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String word : book) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		return map.get(targetWord);
	}

}
