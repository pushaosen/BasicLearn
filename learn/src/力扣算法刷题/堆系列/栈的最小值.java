package 力扣算法刷题.堆系列;

import java.util.Stack;

public class 栈的最小值 {

	/** 
	 * 题目：请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该
	 *     函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)
	 */
	
	/**
	 * 解法一：使用辅助类解决
	 *      自己定义一个辅助类
	 */
	// 链表头，相当于栈顶
	private TreeNode head;
	// 压栈，需要判断栈是否为空
	public void push(int value) {
		if(empty()) {
			head = new TreeNode(value, value, null);
		}else {
			head = new TreeNode(value, Math.min(value, head.min), head);
		}
	}
	
	// 出栈，相当于把链表头删除
	public void pop() {
		if(empty()) {
			throw new IllegalStateException("栈为空……");
		}
		head = head.next;
	}
	
	// 栈顶的值也就是链表头的值
	public int top() {
		if(empty()) {
			throw new IllegalStateException("栈为空……");
		}
		return head.val;
	}
	
	// 链表中头结点保存的是整个链表最小的值，所以返回head.min也就是相当于返回栈中最小值
	public int getMin() {
		if(empty()) {
			throw new IllegalStateException("栈为空……");
		}
		return head.min;
	}
	
	private boolean empty() {
		return head == null;
	}
	
	/** 
	 * 解法二：使用辅助类解决
	 *      使用官方提供的栈
	 */
	private Stack<StackNode> stack = new Stack<>();
	// 压栈
	public void push1(int value) {
		if(empty1()) {
			stack.push(new StackNode(value, value));
		}else {
			stack.push(new StackNode(value, Math.min(value, getMin1())));
		}
	}
	
	// 出栈
	public void pop1() {
		if(empty1()) {
			throw new IllegalStateException("栈为空……");
		}
		stack.pop();
	}
	
	// 获取栈顶元素
	public int top1() {
		if(empty1()) {
			throw new IllegalStateException("栈为空……");
		}
		return stack.peek().val;
	}

	private int getMin1() {
		if(empty1()) {
			throw new IllegalStateException("栈为空……");
		}
		return stack.peek().min;
	}

	private boolean empty1() {
		return stack.isEmpty();
	}
	
	/** 
	 * 解法三：使用单个栈
	 */
	private long min;
	private Stack<Long> stack1 = new Stack<>();
	// 压栈
	public void push2(int value) {
		if(stack1.isEmpty()) {
			stack1.push(0L);
		}else {
			// 这里入栈的是入栈的值和最小值的差值，有可能为负，也可能为正
			stack1.push(value - min);
			if(value < min) {
				min = Long.valueOf(value);
			}
		}
	}
	
	// 出栈
	public void pop2() {
		if(stack1.isEmpty()) {
			return;
		}
		Long pop = stack1.pop();
		// 因为入栈的是差值，当出栈的为负数的时候，说明栈中最小值已经出栈了
		// 这里要重新更新最小值
		if(pop < 0) {
			min -= pop;
		}
	}
	
	// 获取栈顶元素
	public int top2() {
		Long top = stack1.peek();
		if(top > 0) {
			// 栈顶元素如果是正的，说明栈顶元素压栈的时候是比栈中最小值大的，根据
			// top=x - min，可以计算x=top+min
			return (int)(top + min);
		}else {
			//当栈顶元素是负数的时候，说明栈顶元素压栈的时候是比栈中最小值小的，
			//而压栈完之后他会更新最小值min，所以如果在使用上面公式肯定是不行
			//的。如果栈顶元素压栈的时候比最小值小，他会更新最小值，这个最小值
			//就是我们要压栈的值，所以这里直接返回min就行了。
			return (int)min;
		}
	}
	
	// 获取栈中最小的元素
	public int getMin2() {
		return (int)min;
	}
}


// 节点类
class StackNode{
	public int val;
	public int min;
	
	public StackNode(int val, int min) {
		this.val = val;
		this.min = min;
	}
}
