package �����㷨ˢ��.��ϵ��;

import java.util.Stack;

public class ��ջΪ�� {

	/**
	 * ��Ŀ��ʵ��һ��MyQueue�࣬����������ջ��ʵ��һ�����С�
	 */
	/** 
	 * �ⷨ��ʹ������ջʵ��һ������
	 */
	private Stack<Integer> numStack = new Stack<>();
	private Stack<Integer> helpStack = new Stack<>();
	
	// ��ջ
	public void push(int value) {
		numStack.push(value);
	}
	
	// ��ջ
	public int pop() {
		peek();
		return helpStack.pop();
	}
	
	// ��ȡջ��Ԫ��
	public int peek() {
		if(helpStack.isEmpty()) {
			while(!numStack.isEmpty()) {
				helpStack.push(numStack.pop());
			}
		}
		return helpStack.peek();
	}
	
	// �ж�ջ�Ƿ�Ϊ�գ�Ҫ����ջ��Ϊ�գ���Ϊ��
	public boolean empty() {
		return helpStack.isEmpty() && numStack.isEmpty();
	}
}
