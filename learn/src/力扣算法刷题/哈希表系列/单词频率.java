package �����㷨ˢ��.��ϣ��ϵ��;

import java.util.HashMap;
import java.util.Map;

public class ����Ƶ�� {
	
	/** 
	 * ��Ŀ�����һ���������ҳ�����ָ��������һ�����еĳ���Ƶ�ʡ�
	 *     ���ʵ��Ӧ��֧�����²�����
	 *          WordsFrequency(book)���캯��������Ϊ�ַ������鹹�ɵ�һ����
	 *          get(word)��ѯָ�����������г��ֵ�Ƶ��
	 */
	
	public static void main(String[] args) {
		����Ƶ�� obj = new ����Ƶ��();
		String[] strs = {"i", "have", "an", "apple", "he", "have", "a", "pen"};
		System.out.println("�ⷨһ�Ľ��Ϊ��" + obj.getCount(strs, "have"));
	}
	
	/** 
	 * �ⷨһ��HashMap
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
