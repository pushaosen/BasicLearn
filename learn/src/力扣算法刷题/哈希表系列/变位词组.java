package �����㷨ˢ��.��ϣ��ϵ��;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ��λ���� {
	
	/** 
	 * ��Ŀ����дһ�ַ��������ַ�������������򣬽����б�λ�������һ�𡣱�λ����ָ��ĸ����ͬ�������в�ͬ���ַ�����
	 */
	
	/** 
	 * ʾ����
	 *    ���룺["eat", "tea", "tan", "ate", "nat", "bat"],
	 *    �����[
				  ["ate","eat","tea"],
				  ["nat","tan"],
				  ["bat"]
				]
				
				
		  ˵�������������ΪСд
		             �����Ǵ������˳��
	 */
	
	/** 
	 * �ⷨһ��ʹ��hashMap
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
	 * �ⷨ����ʹ�ù�ϣ
	 */
	public List<List<String>> groupAnagrams1(String[] strs) {
		List<List<String>> res = new LinkedList<List<String>>();
		Map<String, Integer> map = new HashMap<>();
		// ��ǰkey��Ӧ�����ĸ�index
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
