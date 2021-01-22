package �����㷨ˢ��.��ϣ��ϵ��;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ��һ��ֻ����һ�ε��ַ� {
	
	/** 
	 * ��Ŀ�����ַ��� s ���ҳ���һ��ֻ����һ�ε��ַ������û�У�����һ�����ո� s ֻ����Сд��ĸ��
	 */
	
	/** 
	 * ʾ����
	 *    ���룺s = "abaccdeff"
	 *    �����"b"
	 *    
	 *    ���룺s = ""
	 *    �����" "
	 */
	
	/** 
	 * ����
	 */
	public static void main(String[] args) {
		��һ��ֻ����һ�ε��ַ� obj = new ��һ��ֻ����һ�ε��ַ�();
		String str = "abaccdeff";
		System.out.println("��ϣ��ⷨ�Ľ��Ϊ��" + obj.firstUniqChar(str));
		str = "";
		System.out.println("��ϣ��ⷨ�Ľ��Ϊ��" + obj.firstUniqChar(str));
	}
	
	/** 
	 * �ⷨһ����ϣ��
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 */
	public char firstUniqChar(String s) {
		HashMap<Character, Boolean> dic = new HashMap<>();
		char[] sc = s.toCharArray();
		for(char c : sc) {
			dic.put(c, !dic.containsKey(c));
		}
		for(char c : sc) {
			if(dic.get(c)) {
				return c;
			}
		}
		return ' ';
	}
	
	/** 
	 * �ⷨ���������ϣ��
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 */
	public char firstUniqChar2(String s) {
		Map<Character, Boolean> dic = new LinkedHashMap<>();
		char[] sc = s.toCharArray();
		for(char c : sc) {
			dic.put(c, !dic.containsKey(c));
		}
		for(Map.Entry<Character, Boolean> d : dic.entrySet()) {
			if(d.getValue()) {
				return d.getKey();
			}
		}
		return ' ';
	}

}
