package �����㷨ˢ��.ջϵ��;

import java.util.Stack;

public class ����滻��Ĵ��Ƿ���Ч {

	/** 
	 * ��Ŀ��������Ч�ַ��� "abc"��
	 * �����κ���Ч���ַ��� V�����ǿ��Խ� V �ֳ��������� X �� Y��ʹ�� 
	 * X + Y��X �� Y ���ӣ����� V����X �� Y ����Ϊ�ա�����ô��X + 
	 * "abc" + Y Ҳͬ������Ч�ġ�
	 */
	
	/** 
	 * �ⷨһ��ʹ��ջ������� 
	 * ����ʱ�䣺����148ms
	 */
	public boolean isValid(String str) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str.length(); i ++) {
			if(str.charAt(i) == 'c') {
				if(stack.empty() || stack.pop() != 'b') {
					return false;
				}
				if(stack.empty() || stack.pop() != 'a') {
					return false;
				}
			}else {
				stack.push(str.charAt(i));
			}
		}
		return stack.isEmpty();
	}
	
	/** 
	 * �ⷨ�����ʺϸ����ŵ�С��� 
	 * �ݹ飺��Լ��64ms
	 */
	public static boolean isValid1(String str) {
		while(str.contains("abc")) {
			str.replace("abc", "");
		}
		return str.equals("");
	}
}
