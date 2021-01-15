package �����㷨ˢ��.˫ָ��ϵ��;

import java.util.Stack;

public class ���ص�����k���ڵ� {
	
	/** 
	 * ��Ŀ��ʵ��һ���㷨���ҳ����������е����� k ���ڵ㡣���ظýڵ��ֵ��
	 */
	
	/** 
	 * ʾ����
	 *    ���룺1->2->3->4->5 �� k = 2
	 *    �����4
	 */
	
	/** 
	 * �ⷨһ��˫ָ��
	 * ����˼·��
	 *       ��һ��ָ�����ƶ�k����Ȼ��ڶ���ָ���ٴ�ͷ��ʼ�����ʱ������ָ��ͬʱ�ƶ�������һ��ָ�뵽�����ĩβ��ʱ��
	 *       ���صڶ���ָ�뼴�ɡ�
	 */
	public int kthToLast(TreeNode head, int k) {
		TreeNode first = head;
		TreeNode second = head;
		// ��һ��ָ������k��
		while(k -- > 0) {
			first = first.next;
		}
		
		// Ȼ������ָ����ͬʱǰ��
		while(first != null) {
			first = first.next;
			second = second.next;
		}
		return second.val;
	}
	
	/** 
	 * �ⷨ����ʹ��ջ���
	 */
	public int kthToLast1(TreeNode head, int k) {
		Stack<TreeNode> stack = new Stack<>();
		// ����ڵ�ѹջ
		while(head != null) {
			stack.push(head);
			head = head.next;
		}
		// �ٳ�ջ�������µ�����
		TreeNode firstNode = stack.pop();
		while(-- k > 0) {
			TreeNode temp = stack.pop();
			temp.next = firstNode;
			firstNode  =temp;
		}
		// ���շ��ر������Ľڵ��ֵ
		return firstNode.val;
	}
	
	/** 
	 * �ⷨ�����ݹ����
	 */
	// ȫ�ֱ�������¼�ݹ������ߵ�ʱ����ʵĽڵ������
	int size;
	public int kthToLast2(TreeNode head, int k) {
		// �߽������жϣ�������Ҳ���ǵݹ����ֹ����
		if(head == null) {
			return 0;
		}
		int val = kthToLast2(head.next, k);
		++ size;
		// �Ӻ������ڵ���С��k�����ؿ�
		if(size < k) {
			return 0;
		}else if(size == k) {
			// �Ӻ��������ʽڵ����k��ֱ�ӷ��ش��ݵĽڵ�k����
			return head.val;
		}else {
			// �Ӻ��������ʵĽڵ����k��˵�������Ѿ��ҵ��ˣ�ֱ�ӷ���node�ͺ���
			return val;
		}
	}

}
