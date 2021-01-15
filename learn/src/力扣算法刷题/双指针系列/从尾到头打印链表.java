package 力扣算法刷题.双指针系列;

import java.util.Stack;

public class 从尾到头打印链表 {
	
	/** 
	 * 题目：输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
	 */
	
	/** 
	 * 示例：
	 *    输入：head = [1,3,2]
	 *    输出：[2,3,1]
	 */
	
	/** 
	 * 解法一：使用栈解决
	 */
	public int[] reversePrint(TreeNode head) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = head;
		// 压栈
		while(temp != null) {
			stack.push(temp);
			temp = temp.next;
		}
		int size = stack.size();
		int[] res = new int[size];
		// 压完栈，在一个一个出栈
		for(int i = 0; i < size; i ++) {
			res[i] = stack.pop().val;
		}
		return res;
	}
	
	/** 
	 * 解法二：递归方式解决
	 */
	public void reversePrint1(TreeNode head) {
		if(head == null) {
			return;
		}
		reversePrint1(head.next);
		System.out.println(head.val);
	}
	
	/** 
	 * 解法二的优化升级
	 */
	public int[] reversePrint2(TreeNode head) {
		int count = length(head);
		int[] res = new int[count];
		reversePrintHelper(head, res, count - 1);
		return res;
	}
	private int length(TreeNode head) {
		int count = 0;
		TreeNode dummy = head;
		while(dummy != null) {
			count ++;
			dummy  =dummy.next;
		}
		return count;
	}
	private void reversePrintHelper(TreeNode head, int[] res, int index) {
		if(head == null) {
			return;
		}
		reversePrintHelper(head.next, res, index  -1);
		res[index] = head.val;
	}
	
	/** 
	 * 解法三：递归的方式
	 */
	public TreeNode reverseList3(TreeNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		TreeNode tempList = reverseList3(head.next);
		head.next.next = head;
		head.next = null;
		return tempList;
	}
	
	/** 
	 * 解法四：非递归的方式
	 */
	public TreeNode reverseList4(TreeNode head) {
		TreeNode pre = null;
		while(head != null) {
			TreeNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

}
