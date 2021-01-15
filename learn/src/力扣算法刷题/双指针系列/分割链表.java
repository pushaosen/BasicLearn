package 力扣算法刷题.双指针系列;

public class 分割链表 {
	
	/** 
	 * 题目：编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果
	 *     链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”
	 *     即可，其不需要被置于左右两部分之间。
	 */
	
	/** 
	 * 示例：
	 *    输入：head = 3->5->8->5->10->2->1, x = 5
	 *    输出：3->1->2->10->5->5->8
	 */
	
	/** 
	 * 解法一：双指针
	 * 解题思路：
	 *       划分左右两个链表
	 *       左链表用来链接值小于x的节点
	 *       右链表链接其他节点
	 *       最后把左链表的尾节点指向右链表的头节点，完成拼接
	 */
	public TreeNode partition(TreeNode head, int x) {
		// 边界条件判断
		if(head == null || head.next == null) {
			return head;
		}
		// 左链表虚拟头节点
		TreeNode leftOne = new TreeNode(-1);
		TreeNode left = leftOne;
		// 右链表虚拟头节点
		TreeNode rightOne = new TreeNode(-1);
		TreeNode right = rightOne;
		// 因为有断开操作，所以需要记录下一个遍历的节点
		TreeNode next;
		while(head != null) {
			next = head.next;
			
			// 值小于x的节点都接在左链表，其他接在右链表上
			if(head.val < x) {
				left.next = head;
				left  =left.next;
			}else {
				right.next = head;
				right = right.next;
			}
			
			// 断开操作
			head.next = null;
			
			head = next;
		}
		
		// 拼接操作   左链表尾节点指向右链表头节点
		left.next = rightOne.next;
		return leftOne.next;
	}
	
	/** 
	 * 解法二：使用头插法
	 * 解题思路：使用头插法即可，其中开始循环的节点为head.next，因为head不用判断
	 */
	public TreeNode partition1(TreeNode head, int x) {
		if(head == null) {
			return null;
		}
		TreeNode dummy = new TreeNode(-1);
		dummy.next = head;
		TreeNode prev = head;
		head = head.next;
		while(head != null) {
			if(head.val < x) {
				prev.next = head.next;
				head.next = dummy.next;
				dummy.next = head;
				head = prev.next;
			}else {
				prev = prev.next;
				head = head.next;
			}
		}
		return dummy.next;
	}
}
