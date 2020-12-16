package �����㷨ˢ��.ջϵ��;

import java.util.Collections;
import java.util.LinkedList;

public class �ַ������� {
	private static int ptr;
	private static int ptr2;
	private static String src;

	/** 
	 * ��Ŀ������һ������������ַ������������������ַ�����
	 * �������Ϊ: k[encoded_string]����ʾ���з������ڲ��� encoded_string
	 * �����ظ� k �Ρ�ע�� k ��֤Ϊ��������
	 * 
	 * �������Ϊ�����ַ���������Ч�ģ������ַ�����û�ж���Ŀո�������
	 * �ķ��������Ƿ��ϸ�ʽҪ��ġ�
	 * 
	 * ���⣬�������Ϊԭʼ���ݲ��������֣����е�����ֻ��ʾ�ظ��Ĵ��� k
	 * �����粻������� 3a �� 2[4] �����롣
	 * 
	 * ʾ�������룺s = "3[a]2[bc]"
	 *     �����"aaabcbc"
	 */
	
	public static void main(String [] args) {
		System.out.println("ջ�����Ľ��Ϊ��" + decodeString("3[a]2[bc]"));
		System.out.println("�ݹ�����Ľ��Ϊ��" + decodeString1("3[a]2[bc]"));
	}
	
	/** 
	 * �ⷨһ��ջ����
	 * ʱ�临�Ӷȣ�O(S)
	 * �ռ临�Ӷȣ�O(S)
	 */
	public static String decodeString(String s) {
		LinkedList<String> stk = new LinkedList<String>();
		ptr = 0;
		while(ptr < s.length()) {
			char cur = s.charAt(ptr);
			if(Character.isDigit(cur)) {
				// ��ȡһ�����ֲ���ջ
				String digits = getDigits(s);
				stk.addLast(digits);
			}else if(Character.isLetter(cur) || cur == '[') {
				// ��ȡһ����ĸ����ջ
				stk.addLast(String.valueOf(s.charAt(ptr++)));
			}else {
				++ptr;
				LinkedList<String> sub = new LinkedList<String>();
				while(!"[".equals(stk.peekLast())) {
					sub.addLast(stk.removeLast());
				}
				Collections.reverse(sub);
				// �����ų�ջ
				stk.removeLast();
				// ��ʱջ��Ϊ��ǰsub��Ӧ���ַ���Ӧ�ó��ֵĴ���
				int repTime = Integer.parseInt(stk.removeLast());
				StringBuilder t = new StringBuilder();
				String o = getString(sub);
				// �����ַ���
				while(repTime -- > 0) {
					t.append(o);
				}
				// ������õ��ַ�����ջ
				stk.addLast(t.toString());
			}
		}
		return getString(stk);
	}
	
	/** 
	 * ��ȡ���ֵĲ��� 
	 */
	private static String getDigits(String s) {
		StringBuilder sdf = new StringBuilder();
		while(Character.isDigit(s.charAt(ptr))) {
			sdf.append(s.charAt(ptr ++));
		}
		return sdf.toString();
	}
	
	/** 
	 * ��ȡ�ַ����� 
	 */
	private static String getString(LinkedList<String> v) {
		StringBuilder sdf = new StringBuilder();
		for(String s : v) {
			sdf.append(s);
		}
		return sdf.toString();
	}
	
	/** 
	 * �ⷨ�����ݹ鷽��
	 * ʱ�临�Ӷȣ�O(s)
	 * �ռ临�Ӷȣ�O(s)
	 */
	public static String  decodeString1(String str) {
		src = str;
		ptr2 = 0;
		return getString1();
	}

	/** 
	 * �ⷨ�����ַ������뷽��
	 * ʱ�临�Ӷȣ�O(s)
	 * �ռ临�Ӷȣ�O(s)
	 */
	private static String getString1() {
		// �ݹ�Ľ��������ж�
		if(ptr2 == src.length() || src.charAt(ptr2) == ']') {
			return "";
		}
		char cur = src.charAt(ptr2);
		int repTime = 1;
		String ret = "";
		if(Character.isDigit(cur)) {
			// String -> Digits [ String ] String
			// ���� Digits
			repTime = getDigits();
			// ����������
			++ ptr2;
			// ����String
			String str = getString1();
			// ����������
			++ ptr2;
			// �����ַ���
			while(repTime -- > 0) {
				ret += str;
			}
		}else if(Character.isLetter(cur)) {
			// String -> Char String
			// ���� Char
			ret = String.valueOf(src.charAt(ptr2 ++));
		}
		return ret + getString1();
	}
	
	private static int getDigits() {
		int ret = 0;
		while(ptr2 < src.length() && Character.isDigit(src.charAt(ptr2))) {
			ret = ret * 10 + src.charAt(ptr2 ++) - '0';
		}
		return ret;
	}
}
