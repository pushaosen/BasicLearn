package �����㷨ˢ��.˫ָ��ϵ��;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ���ʾ��� {
	
	/** 
	 * ��Ŀ���и��ں����ʵĳ����ı��ļ������������������ʣ��ҳ�������ļ������������ʵ���̾���(���������)��
	 *     ���Ѱ�ҹ���������ļ��л��ظ���Σ���ÿ��Ѱ�ҵĵ��ʲ�ͬ�����ܶԴ��Ż���?
	 */
	
	/** 
	 * ʾ����
	 *    ���룺words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
	 *    �����1
	 */
	
	/** 
	 * ����
	 */
	public static void main(String[] args) {
		���ʾ��� obj = new ���ʾ���();
		String[] words = {"I","am","a","student","from","a","university","in","a","city"};
		String word1 = "a";
		String word2 = "student";
		System.out.println("˫ָ��Ľⷨ�Ľ��Ϊ��" + obj.findClosest(words, word1, word2));
	}
	
	/** 
	 * �ⷨһ�����ݶ�β�ѯ�Ż���������+˫ָ��
	 * ����˼·����Ϊ������Ŀ��˵һ��words���ܻ���ж�β�ѯ������û�б�Ҫÿ�ζ����б����������Ƚ�ÿ��word���ֵ���
	 *        ���ù�ϣ���������Ȼ��ÿ�β�ѯ�������б���ʹ��˫ָ������Сֵ
	 */
	public int findClosest(String[] words, String word1, String word2) {
		HashMap<String, List<Integer>> map = new HashMap<>();
		// �����ϣ��
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
