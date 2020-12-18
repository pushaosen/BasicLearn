package �����㷨ˢ��.ջϵ��;

import java.util.Stack;

public class ��תÿ�����ż���Ӵ� {

	/** 
	 * ��Ŀ������һ���ַ��� s��������СдӢ����ĸ�����ţ�
	 * ���㰴�մ������ڵ����˳����㷴תÿ��ƥ�������е��ַ��������������յĽ����
	 * ע�⣺��Ľ���в�Ӧ�����κ����š�
	 */
	
	/** 
	 * ʾ��1��
	 *      ���룺"(u(love)i)"
	 *      �����"iloveu"
	 */
	
	public static void main(String[] args) {
		��תÿ�����ż���Ӵ� obj = new ��תÿ�����ż���Ӵ�();
		String str = "(u(love)i)";
		System.out.println("ջ�ⷨ�Ľ��Ϊ��" + obj.reverseParentheses(str));
		System.out.println("ʹ�õݹ�ⷨ�Ľ��Ϊ��" + obj.reverseParentheses1(str));
	}
	
	/** 
	 * �ⷨһ��ʹ��ջ�ķ��� 
	 */
	public String reverseParentheses(String str) {
		StringBuilder sb = new StringBuilder();
		char[] arr = str.toCharArray();
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < arr.length; i ++) {
			if(arr[i] == '(') {
				stack.push(i);
			}
			if(arr[i] == ')') {
				reverse(arr, stack.pop() + 1, i -1);
			}
		}
		
		for(int i = 0; i < arr.length; i ++) {
			if(arr[i] != ')' && arr[i] != '(') {
				sb.append(arr[i]);
			}
		}
		
		return sb.toString();
	}
	
	private void reverse(char[] arr, int left, int right) {
		while(right > left) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			right --;
			left ++;
		}
	}
	
	/** 
	 * �ⷨ����ʹ�õݹ�
	 */
	int idx = -1;
	public String reverseParentheses1(String str) {
		StringBuilder sb = new StringBuilder();
		while(++ idx < str.length()) {
			char c = str.charAt(idx);
			if(c == '(') {
				sb.append((new StringBuilder(reverseParentheses1(str))).reverse());
			}else if(c == ')') {
				break;
			}else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/** 
	 * �ⷨ�������������ʱ�临�Ӷ�o(n)�ռ临�Ӷ�o(n)
	 */
	private int[] parent;
	public String reverseParentheses2(String str) {
		parent = new int[str.length()];
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < str.toCharArray().length; i ++) {
			if(str.charAt(i) == '(') {
				stack.push(i);
			}else if(str.charAt(i) == ')') {
				int f = stack.pop();
				parent[f] = i;
				parent[i] = f;
			}
		}
		StringBuilder sb = new StringBuilder(str.length());
		reverse(str, 0, str.length() - 1, false, sb);
		return sb.toString();
	}
	
	private void reverse(String str, int start, int end, boolean reversed, StringBuilder sb) {
		if(reversed) {
			for(int i = end; i >= start; i --) {
				if(str.charAt(i) == ')') {
					reverse(str, parent[i] + 1, i - 1, false, sb);
					i = parent[i];
				}else {
					
				}
			}
		}
	}
	
}
