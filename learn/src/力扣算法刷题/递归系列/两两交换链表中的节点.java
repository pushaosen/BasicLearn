package 力扣算法刷题.递归系列;

public class 两两交换链表中的节点 {
	
	/** 
	 * 题目：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
	 *     你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
	 */
	
	/** 
	 * 示例：
	 *    输入：head = [1,2,3,4]
	 *    输出：[2,1,4,3]
	 *    
	 *    输入：head = []
	 *    输出：[]
	 *    
	 *    输入：head = [1]
	 *    输出：[1]
	 */
	
	/** 
	 * 解法一：递归
	 * 时间复杂度：O(n)，其中n是链表的节点数量。需要对每个节点进行更新指针的操作。
	 * 空间复杂度：O(n)，其中n是链表的节点数量。空间复杂度主要取决于递归调用的栈空间。
	 */
	public TreeNode swapPairs(TreeNode head) {
		// 递归调用的结束递归的条件
		if(head == null || head.next == null) {
			return head;
		}
		TreeNode newHead = head.next;
		// 进行递归调用
		head.next = swapPairs(newHead.next);
		newHead.next = head;
		return newHead;
	}
	
	/** 
	 * 解法二：迭代解法
	 * 时间复杂度：O(n)，其中n是链表的节点数量。需要对每个节点进行更新指针的操作。
	 * 空间复杂度：O(1)
	 */
	public TreeNode swapPairs1(TreeNode head) {
		TreeNode dummyHead = new TreeNode(0);
		dummyHead.next = head;
		TreeNode temp = dummyHead;
		while(temp.next != null && temp.next.next != null) {
			TreeNode node1 = temp.next;
			TreeNode node2 = temp.next.next;
			temp.next = node2;
			node1.next = node2.next;
			node2.next = node1;
			temp = node1;
		}
		return dummyHead.next;
	}
	
}
