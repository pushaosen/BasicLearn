package 力扣算法刷题.栈系列;

import java.util.Deque;
import java.util.LinkedList;

public class 用两个栈实现队列 {

	/** 
	 * 题目：用两个栈实现队列
	 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，分别完成
	 * 在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1)
	 */
	
	/** 
	 * 示例：
	 *     输入：
	 */
	
	private static Deque<Integer> stack1 = new LinkedList<Integer>();
	private static Deque<Integer> stack2 = new LinkedList<Integer>();
	
	
	/** 
	 * 在队列尾部插入 
	 */
	public static void appendTail(int value) {
		stack1.push(value);
	}
	
	/** 
	 * 删除头部的元素
	 */
	public static int deleteHead() {
		// 如果第二个栈为空
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if(stack2.isEmpty()) {
			return -1;
		}else {
			int deleteItem = stack2.pop();
			return deleteItem;
		}
	}
	
}
