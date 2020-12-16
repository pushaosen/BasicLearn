package 力扣算法刷题.栈系列;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 链表中的下一个更大节点 {
	
	/** 
	 * 题目：给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
	 */

	/** 
	 * 解法一：使用单调栈 
	 */
	public static int[] nextLargerNodes(TreeNode head) {
		int index = 0;
		Deque<Integer> stack = new ArrayDeque<>();
		List<Integer> list = new ArrayList<>();
		int[] temp = new int[10000 + 1];
		TreeNode curr = head;
		while(curr != null) {
			while(!stack.isEmpty() && list.get(stack.peek()) < curr.val) {
				temp[stack.peek()] = curr.val;
				stack.poll();
			}
			list.add(curr.val);
			stack.push(index);
			curr = curr.next;
			index ++;
		}
		int[] res = new int[index];
		System.arraycopy(temp, 0, res, 0, index);
		return res;
	}
}
