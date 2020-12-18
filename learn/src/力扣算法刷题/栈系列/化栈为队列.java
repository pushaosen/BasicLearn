package �����㷨ˢ��.ջϵ��;

import java.util.Stack;

public class ��ջΪ���� {

	/** 
	 * ʵ��һ�������࣬����������ջ��ʵ��һ������
	 */
	private Stack<Integer> numStack = new Stack<>();
	private Stack<Integer> helpStack = new Stack<>();
	
	public void push(int x) {
		numStack.push(x);
	}
	
	public int pop() {
		peek();
		return helpStack.pop();
	}
	
	public int peek() {
		if(helpStack.isEmpty()) {
			while(!numStack.isEmpty()) {
				helpStack.push(numStack.pop());
			}
		}
		
		return helpStack.peek();
	}
	
	public boolean empty() {
		return helpStack.isEmpty() && numStack.isEmpty();
	}
}
