package �����㷨ˢ��.��ϵ��;

import java.util.Stack;

public class ����min������ջ {

	/** 
	 * ��Ŀ������ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص� min ��
	 *     ���ڸ�ջ�У����� min��push �� pop ��ʱ�临�Ӷȶ��� O(1)��
	 */
	Stack<Integer> A = new Stack<>();
	Stack<Integer> B = new Stack<>();
	
	public void push(int x) {
		A.add(x);
		if(B.empty() || B.peek() >= x) {
			B.add(x);
		}
	}
	
	public void pop() {
		if(A.pop().equals(B.peek())) {
			B.pop();
		}
	}
	
	public int top() {
		return A.peek();
	}
	
	public int min() {
		return B.peek();
	}
}
