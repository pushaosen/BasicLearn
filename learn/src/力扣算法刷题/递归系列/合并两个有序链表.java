package 力扣算法刷题.递归系列;

public class 合并两个有序链表 {
	
	/** 
	 * 题目：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所
	 *     有节点组成的
	 */
	
	/** 
	 * 示例：
	 *     输入：1->2->4, 1->3->4
	 *     输出：1->1->2->3->4->4
	 */
	
	/** 
	 * 解法一：递归解法
	 * 时间复杂度：O(n+m)，其中n和m分别为两个链表的长度
	 * 空间复杂度：O(n+m)
	 */
	public TreeNode mergeTwoLists(TreeNode l1, TreeNode l2) {
		// 先判断两个节点是否为空
		if(l1 == null) {
			return l2;
		}else if(l2 == null) {
			return l1;
		}else if(l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
	
	/** 
	 * 解法二：迭代法
	 * 时间复杂度：O(n+m)
	 * 空间复杂度：O(1)，我们只需要常数的空间存放若干变量
	 */
	public TreeNode mergeTwoLists2(TreeNode l1, TreeNode l2) {
		TreeNode prehead = new TreeNode(-1);
		
		TreeNode prev = prehead;
		while(l1 != null && l2 != null) {
			if(l1.val <= l2.val) {
				prev.next = l1;
				l1 = l1.next;
			}else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}
		// 合并后l1和l2最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
		prev.next = l1 == null ? l2 : l1;
		return prehead.next;
	}

}
