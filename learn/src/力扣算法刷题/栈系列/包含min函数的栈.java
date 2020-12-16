package �����㷨ˢ��.ջϵ��;

import java.util.Stack;

public class ����min������ջ {
	
	/** 
	 * ��Ŀ������ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص� min 
	 * �����ڸ�ջ�У����� min��push �� pop ��ʱ�临�Ӷȶ��� O(1)��
	 * �ѵ㣺��min�����ĸ��ӶȽ�ΪO(1),��ͨ����������ջʵ��
	 */
	/**
	 * ����˼·��
	 * ����ջA��ջA���ڴ洢����Ԫ�أ���֤��ջ����push()����ջ����pop()����ȡջ������top()�������߼�
	 * 
	 * ����ջB��ջB�д洢ջA�����з��ϸ����Ԫ�أ���ջA�е���СԪ��ʼ�ն�ӦջB��ջ��Ԫ�أ���min()����ֻ��Ҫ����ջB��
	 * ��ջ��Ԫ�ؼ��ɡ�
	 */
	
	private Stack<Integer> A = new Stack<Integer>();
	private Stack<Integer> B = new Stack<Integer>();
	
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
