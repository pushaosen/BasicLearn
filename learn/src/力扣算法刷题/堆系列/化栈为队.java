package 力扣算法刷题.堆系列;

import java.util.Stack;

public class 化栈为队 {

	/**
	 * 题目：实现一个MyQueue类，该类用两个栈来实现一个队列。
	 */
	/** 
	 * 解法：使用两个栈实现一个队列
	 */
	private Stack<Integer> numStack = new Stack<>();
	private Stack<Integer> helpStack = new Stack<>();
	
	// 入栈
	public void push(int value) {
		numStack.push(value);
	}
	
	// 出栈
	public int pop() {
		peek();
		return helpStack.pop();
	}
	
	// 获取栈顶元素
	public int peek() {
		if(helpStack.isEmpty()) {
			while(!numStack.isEmpty()) {
				helpStack.push(numStack.pop());
			}
		}
		return helpStack.peek();
	}
	
	// 判断栈是否为空：要两个栈均为空，才为空
	public boolean empty() {
		return helpStack.isEmpty() && numStack.isEmpty();
	}
}
