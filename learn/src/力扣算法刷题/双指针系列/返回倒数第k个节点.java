package 力扣算法刷题.双指针系列;

import java.util.Stack;

public class 返回倒数第k个节点 {
	
	/** 
	 * 题目：实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
	 */
	
	/** 
	 * 示例：
	 *    输入：1->2->3->4->5 和 k = 2
	 *    输出：4
	 */
	
	/** 
	 * 解法一：双指针
	 * 解题思路：
	 *       第一个指针先移动k步，然后第二个指针再从头开始，这个时候两个指针同时移动，当第一个指针到链表的末尾的时候，
	 *       返回第二个指针即可。
	 */
	public int kthToLast(TreeNode head, int k) {
		TreeNode first = head;
		TreeNode second = head;
		// 第一个指针先走k步
		while(k -- > 0) {
			first = first.next;
		}
		
		// 然后两个指针再同时前进
		while(first != null) {
			first = first.next;
			second = second.next;
		}
		return second.val;
	}
	
	/** 
	 * 解法二：使用栈解决
	 */
	public int kthToLast1(TreeNode head, int k) {
		Stack<TreeNode> stack = new Stack<>();
		// 链表节点压栈
		while(head != null) {
			stack.push(head);
			head = head.next;
		}
		// 再出栈串联成新的链表
		TreeNode firstNode = stack.pop();
		while(-- k > 0) {
			TreeNode temp = stack.pop();
			temp.next = firstNode;
			firstNode  =temp;
		}
		// 最终返回遍历到的节点的值
		return firstNode.val;
	}
	
	/** 
	 * 解法三：递归求解
	 */
	// 全局变量，记录递归往回走的时候访问的节点的数量
	int size;
	public int kthToLast2(TreeNode head, int k) {
		// 边界条件判断，在这里也就是递归的终止条件
		if(head == null) {
			return 0;
		}
		int val = kthToLast2(head.next, k);
		++ size;
		// 从后面数节点数小于k，返回空
		if(size < k) {
			return 0;
		}else if(size == k) {
			// 从后面数访问节点等于k，直接返回传递的节点k即可
			return head.val;
		}else {
			// 从后面数访问的节点大于k，说明我们已经找到了，直接返回node就好了
			return val;
		}
	}

}
