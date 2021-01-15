package �����㷨ˢ��.˫ָ��ϵ��;

import java.util.Deque;
import java.util.LinkedList;

public class ɾ������ĵ�����N���ڵ� {
	
	/** 
	 * ��Ŀ������һ������ɾ������ĵ����� n ���ڵ㣬���ҷ��������ͷ��㡣
	 */
	
	/** 
	 * ʾ��������һ������: 1->2->3->4->5, �� n = 2.
	 *     ��ɾ���˵����ڶ����ڵ�������Ϊ 1->2->3->5.
	 */
	
	/** 
	 * �ⷨһ������������
	 * ʱ�临�Ӷȣ�O(L)������L������ĳ���
	 * �ռ临�Ӷȣ�O(1)
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
	 * �ⷨ����ջ
	 * ʱ�临�Ӷȣ�O(L)������L������ĳ���
	 * �ռ临�Ӷȣ�O(L)������L������ĳ��ȡ���ҪΪջ�Ŀ�����
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
	 * �ⷨ����һ�α���
	 * ʱ�临�Ӷȣ�O(L)������L������ĳ���
	 * �ռ临�Ӷȣ�O(1)
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
