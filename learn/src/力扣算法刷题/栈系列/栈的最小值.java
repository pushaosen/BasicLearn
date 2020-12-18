package 力扣算法刷题.栈系列;

import java.util.Stack;

public class 栈的最小值 {

	/* 
	 * 题目：请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
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
