package 力扣算法刷题.堆系列;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 字符串中的第一个唯一字符 {

	/** 
	 * 题目：给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回-1.
	 */
	
	/**
	 * 示例：
	 *     输入：s = "leetcode"
	 *     输出：返回0
	 *     
	 * 示例：
	 *     输入：s = "loveleetcode"
	 *     输出：返回2
	 */
	
	/** 
	 * 解法一：使用哈希表存储频数
	 * 思路与解法：可以对字符串进行两次遍历
	 * 时间复杂度：O(n)，其中n是字符串的长度
	 * 空间复杂度：就是字母的个数
	 */
	public int firstUniqChar(String str) {
		Map<Character, Integer> frequency = new HashMap<Character, Integer>();
		for(int i = 0; i < str.length(); ++ i) {
			char ch = str.charAt(i);
			frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
		}
		for(int i = 0; i < str.length(); ++ i) {
			if(frequency.get(str.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}
	
	/** 
	 * 解法二：使用哈希表存储索引
	 * 思路与算法：我们可以对方法一进行修改，使得第二次遍历的对象从字符串变为哈希映射
	 * 时间复杂度：O(n)，其中n是字符串的长度
	 * 空间复杂度：就是字符的个数
	 */
	public int firstUniqChar1(String str) {
		Map<Character, Integer> frequency = new HashMap<Character, Integer>();
		int n = str.length();
		for(int i = 0; i < n; ++ i) {
			char ch = str.charAt(i);
			if(frequency.containsKey(ch)) {
				frequency.put(ch, -1);
			}else {
				frequency.put(ch, i);
			}
		}
		int first = n;
		for(Map.Entry<Character, Integer> entry : frequency.entrySet()) {
			int pos = entry.getValue();
			if(pos != -1 && pos < first) {
				first = pos;
			}
		}
		if(first == n) {
			return -1;
		}
		return first;
	}
	
	/** 
	 * 解法三：队列
	 */
	public int firstUniqChar2(String str) {
		Map<Character, Integer> position = new HashMap<>();
		Queue<Pair> queue = new LinkedList<Pair>();
		int n = str.length();
		for(int i = 0; i < n; ++ i) {
			char ch = str.charAt(i);
			if(!position.containsKey(ch)) {
				position.put(ch, i);
				queue.offer(new Pair(ch, i));
			}else {
				position.put(ch, -1);
				while(!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
					queue.poll();
				}
			}
		}
		return queue.isEmpty() ? -1 : queue.poll().pos;
	}
}

class Pair{
	char ch;
	int pos;
	
	Pair(char ch, int pos){
		this.ch = ch;
		this.pos = pos;
	}
}
