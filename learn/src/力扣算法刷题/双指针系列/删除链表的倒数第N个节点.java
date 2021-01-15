package 力扣算法刷题.双指针系列;

import java.util.Deque;
import java.util.LinkedList;

public class 删除链表的倒数第N个节点 {
	
	/** 
	 * 题目：给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
	 */
	
	/** 
	 * 示例：给定一个链表: 1->2->3->4->5, 和 n = 2.
	 *     当删除了倒数第二个节点后，链表变为 1->2->3->5.
	 */
	
	/** 
	 * 解法一：计算链表长度
	 * 时间复杂度：O(L)，其中L是链表的长度
	 * 空间复杂度：O(1)
	 */
	public TreeNode removeNthFromEnd(TreeNode head, int n) {
		TreeNode dumny = new TreeNode(0, head);
		int length = getLength(head);
		TreeNode cur = dumny;
		for(int i = 1; i < length - n + 1; ++ i) {
			cur = cur.next;
		}
		cur.next = cur.next.next;
		TreeNode ans = dumny.next;
		return ans;
	}
	private int getLength(TreeNode head) {
		int length = 0;
		while(head != null) {
			++ length;
			head = head.next;
		}
		return length;
	}
	
	/** 
	 * 解法二：栈
	 * 时间复杂度：O(L)，其中L是链表的长度
	 * 空间复杂度：O(L)，其中L是链表的长度。主要为栈的开销。
	 */
	public TreeNode removeNthFromEnd1(TreeNode head, int n) {
		TreeNode dummy = new TreeNode(0, head);
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode cur = dummy;
		while(cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		for(int i = 0; i < n; ++ i) {
			stack.pop();
		}
		TreeNode prev = stack.peek();
		prev.next = prev.next.next;
		TreeNode ans = dummy.next;
		return ans;
	}
	
	/** 
	 * 解法三：一次遍历
	 * 时间复杂度：O(L)，其中L是链表的长度
	 * 空间复杂度：O(1)
	 */
	public TreeNode removeNthFromEnd2(TreeNode head, int n) {
		TreeNode dummy = new TreeNode(0, head);
		TreeNode first = head;
		TreeNode second = dummy;
		for(int i = 0;i < n; i ++) {
			first = first.next;
		}
		while(first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		TreeNode ans = dummy.next;
		return ans;
	}

}
