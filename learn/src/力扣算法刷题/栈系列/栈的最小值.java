package �����㷨ˢ��.ջϵ��;

import java.util.Stack;

public class ջ����Сֵ {

	/* 
	 * ��Ŀ�������һ��ջ�����˳���ջ֧�ֵ�pop��push�������⣬��֧��min�������ú�������ջԪ���е���Сֵ��ִ��push��pop��min������ʱ�临�Ӷȱ���ΪO(1)��
	 */
	
	private Stack<Integer> data_stack = new Stack<>();
	private Stack<Integer> min_stack = new Stack<>();
	
	public void push(int x) {
		data_stack.push(x);
		if(min_stack.isEmpty() || x < min_stack.peek()) {
			min_stack.push(x);
		}else {
			min_stack.push(min_stack.peek());
		}
	}
	
	public void pop() {
		data_stack.pop();
		min_stack.pop();
	}
	
	public int top() {
		return data_stack.peek();
	}
	
	public int getMin() {
		return min_stack.peek();
	}
	
}
