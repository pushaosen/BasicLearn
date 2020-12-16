package �����㷨ˢ��.ջϵ��;

import java.util.Stack;

public class ���ŵķ��� {

	/** 
	 * ��Ŀ������һ��ƽ�������ַ��� S�����������������ַ����ķ�����
	 * () �� 1 ��
	 * AB �� A + B �֣����� A �� B ��ƽ�������ַ�����
	 * (A) �� 2 * A �֣����� A ��ƽ�������ַ�����
	 */
	
	public static void main(String[] args) {
		String s = "(()(()))";
		System.out.println("���ε�˼��ó��Ľ��Ϊ��" + scoreOfParentheses(s));
		System.out.println("ջ�ⷨ�ó��Ľ��Ϊ��" + scoreOfParentheses1(s));
		System.out.println("ͳ�ƺ��ĵ���Ŀ�ó��Ľ��Ϊ��" + scoreOfParentheses2(s));
	}
	
	/** 
	 * �ⷨһ�� ���ε�˼��
	 * ʱ�临�Ӷȣ�O(N*N)
	 * �ռ临�Ӷȣ�O(N)
	 */
	public static int scoreOfParentheses(String s) {
		return fun(s, 0, s.length());
	}
	
	private static int fun(String s, int i, int j) {
		int ans = 0, bal  =0;
		for(int k = i; k < j; ++ k) {
			bal += s.charAt(k) == '(' ? 1 : -1;
			if(bal == 0) {
				if(k - i == 1) {
					ans ++;
				}else {
					ans += 2 * fun(s, i + 1, k);
				}
				i = k + 1;
			}
		}
		return ans;
	}
	
	/** 
	 * �ⷨ����ջ
	 * ʱ�临�Ӷȣ�O(N)������N���ַ���S�ĳ���
	 * �ռ临�Ӷȣ�O(N)��Ϊջ�Ĵ�С
	 */
	public static int scoreOfParentheses1(String s) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		
		for(char c : s.toCharArray()) {
			if(c == '(') {
				stack.push(0);
			}else {
				int v = stack.pop();
				int w = stack.pop();
				stack.push(w + Math.max(2 * v, 1));
			}
		}
		return stack.pop();
	} 
	
	/** 
	 * ͳ�ƺ��ĵ���Ŀ
	 * ʱ�临�Ӷȣ�O(N)
	 * �ռ临�Ӷȣ�O(1) 
	 */
	public static int scoreOfParentheses2(String s) {
		int ans = 0, bal = 0;
		for(int i = 0; i < s.length(); ++ i) {
			if(s.charAt(i) == '(') {
				bal ++;
			}else {
				bal --;
				if(s.charAt(i - 1) == '(') {
					ans += 1 << bal; 
				}
			}
		}
		return ans;
	}
}
