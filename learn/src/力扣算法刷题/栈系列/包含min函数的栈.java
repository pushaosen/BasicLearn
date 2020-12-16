package 力扣算法刷题.栈系列;

import java.util.Stack;

public class 包含min函数的栈 {
	
	/** 
	 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 
	 * 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
	 * 难点：将min函数的复杂度降为O(1),可通过建立辅助栈实现
	 */
	/**
	 * 解题思路：
	 * 数据栈A：栈A用于存储所有元素，保证入栈函数push()、出栈函数pop()、获取栈顶函数top()的正常逻辑
	 * 
	 * 辅助栈B：栈B中存储栈A中所有非严格降序的元素，则栈A中的最小元素始终对应栈B的栈顶元素，即min()函数只需要返回栈B的
	 * 的栈顶元素即可。
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
