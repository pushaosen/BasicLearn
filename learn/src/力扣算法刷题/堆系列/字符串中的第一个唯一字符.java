package �����㷨ˢ��.��ϵ��;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class �ַ����еĵ�һ��Ψһ�ַ� {

	/** 
	 * ��Ŀ������һ���ַ������ҵ����ĵ�һ�����ظ����ַ���������������������������ڣ��򷵻�-1.
	 */
	
	/**
	 * ʾ����
	 *     ���룺s = "leetcode"
	 *     ���������0
	 *     
	 * ʾ����
	 *     ���룺s = "loveleetcode"
	 *     ���������2
	 */
	
	/** 
	 * �ⷨһ��ʹ�ù�ϣ��洢Ƶ��
	 * ˼·��ⷨ�����Զ��ַ����������α���
	 * ʱ�临�Ӷȣ�O(n)������n���ַ����ĳ���
	 * �ռ临�Ӷȣ�������ĸ�ĸ���
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
	 * �ⷨ����ʹ�ù�ϣ��洢����
	 * ˼·���㷨�����ǿ��ԶԷ���һ�����޸ģ�ʹ�õڶ��α����Ķ�����ַ�����Ϊ��ϣӳ��
	 * ʱ�临�Ӷȣ�O(n)������n���ַ����ĳ���
	 * �ռ临�Ӷȣ������ַ��ĸ���
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
	 * �ⷨ��������
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
