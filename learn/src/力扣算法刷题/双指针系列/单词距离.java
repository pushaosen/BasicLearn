package 力扣算法刷题.双指针系列;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 单词距离 {
	
	/** 
	 * 题目：有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
	 *     如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
	 */
	
	/** 
	 * 示例：
	 *    输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
	 *    输出：1
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		单词距离 obj = new 单词距离();
		String[] words = {"I","am","a","student","from","a","university","in","a","city"};
		String word1 = "a";
		String word2 = "student";
		System.out.println("双指针的解法的结果为：" + obj.findClosest(words, word1, word2));
	}
	
	/** 
	 * 解法一：根据多次查询优化：即遍历+双指针
	 * 解题思路：因为按照题目所说一个words可能会进行多次查询，所以没有必要每次都进行遍历，可以先将每个word出现的索
	 *        引用哈希表存起来，然后每次查询从索引列表当中使用双指针求最小值
	 */
	public int findClosest(String[] words, String word1, String word2) {
		HashMap<String, List<Integer>> map = new HashMap<>();
		// 构造哈希表
		for(int i = 0; i < words.length; i ++) {
			List<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
			list.add(i);
			map.put(words[i], list);
		}
		List<Integer> l1 = map.get(word1);
		List<Integer> l2 = map.get(word2);
		int i = 0;
		int j = 0;
		int min = Integer.MAX_VALUE;
		while(i < l1.size() && j < l2.size()) {
			int curr1 = l1.get(i);
			int curr2 = l2.get(j);
			min = Math.min(min, Math.abs(curr1 - curr2));
			if(curr1 < curr2) {
				i ++;
			}else {
				j ++;
			}
		}
		return min;
	}

}
