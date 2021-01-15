package �����㷨ˢ��.˫ָ��ϵ��;

import java.util.Stack;

public class ��β��ͷ��ӡ���� {
	
	/** 
	 * ��Ŀ������һ�������ͷ�ڵ㣬��β��ͷ����������ÿ���ڵ��ֵ�������鷵�أ���
	 */
	
	/** 
	 * ʾ����
	 *    ���룺head = [1,3,2]
	 *    �����[2,3,1]
	 */
	
	/** 
	 * �ⷨһ��ʹ��ջ���
	 */
	public int[] reversePrint(TreeNode head) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = head;
		// ѹջ
		while(temp != null) {
			stack.push(temp);
			temp = temp.next;
		}
		int size = stack.size();
		int[] res = new int[size];
		// ѹ��ջ����һ��һ����ջ
		for(int i = 0; i < size; i ++) {
			res[i] = stack.pop().val;
		}
		return res;
	}
	
	/** 
	 * �ⷨ�����ݹ鷽ʽ���
	 */
	public void reversePrint1(TreeNode head) {
		if(head == null) {
			return;
		}
		reversePrint1(head.next);
		System.out.println(head.val);
	}
	
	/** 
	 * �ⷨ�����Ż�����
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
	 * �ⷨ�����ݹ�ķ�ʽ
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
	 * �ⷨ�ģ��ǵݹ�ķ�ʽ
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
