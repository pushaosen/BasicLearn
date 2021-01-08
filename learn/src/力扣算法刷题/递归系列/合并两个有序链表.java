package �����㷨ˢ��.�ݹ�ϵ��;

public class �ϲ������������� {
	
	/** 
	 * ��Ŀ����������������ϲ�Ϊһ���µ� ���� �������ء���������ͨ��ƴ�Ӹ����������������
	 *     �нڵ���ɵ�
	 */
	
	/** 
	 * ʾ����
	 *     ���룺1->2->4, 1->3->4
	 *     �����1->1->2->3->4->4
	 */
	
	/** 
	 * �ⷨһ���ݹ�ⷨ
	 * ʱ�临�Ӷȣ�O(n+m)������n��m�ֱ�Ϊ��������ĳ���
	 * �ռ临�Ӷȣ�O(n+m)
	 */
	public TreeNode mergeTwoLists(TreeNode l1, TreeNode l2) {
		// ���ж������ڵ��Ƿ�Ϊ��
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
	 * �ⷨ����������
	 * ʱ�临�Ӷȣ�O(n+m)
	 * �ռ临�Ӷȣ�O(1)������ֻ��Ҫ�����Ŀռ������ɱ���
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
		// �ϲ���l1��l2���ֻ��һ����δ���ϲ��꣬����ֱ�ӽ�����ĩβָ��δ�ϲ����������
		prev.next = l1 == null ? l2 : l1;
		return prehead.next;
	}

}
