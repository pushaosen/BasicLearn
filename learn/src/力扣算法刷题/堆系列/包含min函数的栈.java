package 力扣算法刷题.堆系列;

import java.util.Stack;

public class 包含min函数的栈 {

	/** 
	 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函
	 *     数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
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
