package 力扣算法刷题.堆系列;

import java.util.Deque;
import java.util.LinkedList;

public class 用两个栈实现队列 {

	/* 
	 * 题目： 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别
	 *     完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
	 */
	
	/** 
	 * 示例：
	 *     输入：["CQueue","appendTail","deleteHead","deleteHead"]
	 *         [[],[3],[],[]]
	 *     输出：[null,null,3,-1]
	 */
	
	/** 
	 * 解法一：使用双栈
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(n)
	 */
	Deque<Integer> stack1 = new LinkedList<Integer>();
	Deque<Integer> stack2 = new LinkedList<Integer>();
	public void appendTail(int value) {
		stack1.push(value);
	}
	public int deleteHead() {
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
	
	/** 
	 * 解法二：使用双栈
	 */
	LinkedList<Integer> A = new LinkedList<Integer>();
	LinkedList<Integer> B = new LinkedList<Integer>();
	public void appendTail1(int value) {
		A.addLast(value);
	}
	public int deleteHead1() {
		if(!B.isEmpty()) {
			return B.removeLast();
		}
		if(A.isEmpty()) {
			return -1;
		}
        while(!A.isEmpty()) {
        	B.addLast(A.removeLast());
        }
        return B.removeLast();
	}
	
}
