package 力扣算法刷题.哈希表系列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 变位词组 {
	
	/** 
	 * 题目：编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相相同，但排列不同的字符串。
	 */
	
	/** 
	 * 示例：
	 *    输入：["eat", "tea", "tan", "ate", "nat", "bat"],
	 *    输出：[
				  ["ate","eat","tea"],
				  ["nat","tan"],
				  ["bat"]
				]
				
				
		  说明：所有输入均为小写
		             不考虑答案输出的顺序
	 */
	
	/** 
	 * 解法一：使用hashMap
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		for(String str : strs) {
			int[] count = new int[26];
			int str_len = str.length();
			for(int i = 0; i < str_len; ++ i) {
				++count[str.charAt(i) - 'a'];
			}
			StringBuilder sdf = new StringBuilder();
			for(int num : count) {
				sdf.append(num + ' ');
			}
			 map.computeIfAbsent(sdf.toString(), unused -> new LinkedList<>()).add(str);
		}
		return new ArrayList<List<String>>(map.values());
	}
	
	/** 
	 * 解法二：使用哈希
	 */
	public List<List<String>> groupAnagrams1(String[] strs) {
		List<List<String>> res = new LinkedList<List<String>>();
		Map<String, Integer> map = new HashMap<>();
		// 当前key对应类表的哪个index
		int index = 0;
		for(String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);
			if(!map.containsKey(key)) {
				map.put(key, index++);
				List<String> list = new LinkedList<>();
				list.add(str);
				res.add(list);
			}else {
				res.get(map.get(key)).add(str);
			}
		}
		return res;
	}
}
