package �����㷨ˢ��.ջϵ��;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ��Ч������ {
	/**
	 * ��Ŀ������һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��
	 * ��Ч�ַ��������㣺
	 *      1�������ű�������ͬ���͵������űպϡ�
	 *      2�������ű�������ȷ��˳��պ�
	 * ע����ַ����ɱ���Ϊ����Ч�ַ���
	 */
	
	/**
	 * ջ�Ľⷨ��
	 * ʱ�临�Ӷȣ�n��n���ַ���str�ĳ���
	 * �ռ临�Ӷȣ� O(n+�O���O)������ �� ��ʾ�ַ������������ַ���ֻ���� 66�����ţ�|��| = 6
	 */
	public static boolean fun(String str) {
		int n = str.length();
		if(n % 2 == 1) {
			return false;
		}
		Map<Character, Character> pairs = new HashMap<Character, Character>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				put(')', '(');
				put(']', '[');
				put('}', '{');
			}
		};
		// ����һ��ջ�ṹ
		Deque<Character> stack = new LinkedList<Character>();
		for(int i = 0; i < n; i ++) {
			char ch = str.charAt(i);
			if(pairs.containsKey(ch)) {
				if(stack.isEmpty() || stack.peek() != pairs.get(ch)) {
					return false;
				}
				stack.pop();
			}else {
				stack.push(ch);
			}
		}
		return stack.isEmpty();
	}
}
