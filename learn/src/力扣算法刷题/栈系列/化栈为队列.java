package 力扣算法刷题.栈系列;

import java.util.Stack;

public class 化栈为队列 {

	/** 
	 * 实现一个队列类，该类用两个栈来实现一个队列
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
