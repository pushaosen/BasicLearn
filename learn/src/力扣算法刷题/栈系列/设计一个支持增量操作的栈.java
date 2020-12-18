package 力扣算法刷题.栈系列;

public class 设计一个支持增量操作的栈 {
	
	/** 
	 * 题目：请你设计一个支持下述操作的栈。
	 * CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize
	 *        是栈中最多能容纳的元素数量，栈在增长到 maxSize 之后则不支持push 操作。    
	 * void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
	 * int pop()：弹出栈顶元素，并返回栈顶的值，或栈为空时返回 -1
	 * void inc(int k, int val)：栈底的 k 个元素的值都增加 val。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val
	 */
	
	/** 
	 * 解法一：模拟
	 */
	int [] stack;
	int top;
	
	public 设计一个支持增量操作的栈(int maxSize) {
		stack = new int[maxSize];
		top = -1;
	}
	
	public void push(int x) {
		if(top != stack.length - 1) {
			++ top;
			stack[top] = x;
		}
	}
	
	public int pop() {
		if(top == -1) {
			return -1;
		}
		-- top;
		return stack[top + 1];
	}
	
	public void increament(int k, int val) {
		int limit = Math.min(k, top + 1);
		for(int i = 0; i < limit; ++ i) {
			stack[i] += val;
		}
	}
	
	/** 
	 * 解法二：模拟优化
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(maxSize)
	 */
	int[] stack1;
	int[] add;
	int top1;
	public 设计一个支持增量操作的栈(int maxSize, int x) {
		stack1 = new int[maxSize];
		add = new int[maxSize];
		top1 = -1;
	}
	
	public void push1(int x) {
		if(top != stack1.length - 1) {
			++ top;
			stack[top] = x;
		}
	}
	
	public int pop1() {
		if(top1 == -1) {
			return -1;
		}
		int ret = stack1[top1] + add[top1];
		if(top != 0) {
			add[top1 - 1] += add[top1];
		}
		add[top1] = 0;
		-- top1;
		return ret;
	}
	
	public void increment1(int k, int val) {
		int limit = Math.min(k - 1, top1);
		if(limit >= 0) {
			add[limit] += val;
		}
	}

}
