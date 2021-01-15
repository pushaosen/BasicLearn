package �����㷨ˢ��.˫ָ��ϵ��;

public class �ָ����� {
	
	/** 
	 * ��Ŀ����д������ x Ϊ��׼�ָ�����ʹ������С�� x �Ľڵ����ڴ��ڻ���� x �Ľڵ�֮ǰ�����
	 *     �����а��� x��x ֻ�������С�� x ��Ԫ��֮��(������ʾ)���ָ�Ԫ�� x ֻ�账�ڡ��Ұ벿�֡�
	 *     ���ɣ��䲻��Ҫ����������������֮�䡣
	 */
	
	/** 
	 * ʾ����
	 *    ���룺head = 3->5->8->5->10->2->1, x = 5
	 *    �����3->1->2->10->5->5->8
	 */
	
	/** 
	 * �ⷨһ��˫ָ��
	 * ����˼·��
	 *       ����������������
	 *       ��������������ֵС��x�Ľڵ�
	 *       ���������������ڵ�
	 *       �����������β�ڵ�ָ���������ͷ�ڵ㣬���ƴ��
	 */
	public TreeNode partition(TreeNode head, int x) {
		// �߽������ж�
		if(head == null || head.next == null) {
			return head;
		}
		// ����������ͷ�ڵ�
		TreeNode leftOne = new TreeNode(-1);
		TreeNode left = leftOne;
		// ����������ͷ�ڵ�
		TreeNode rightOne = new TreeNode(-1);
		TreeNode right = rightOne;
		// ��Ϊ�жϿ�������������Ҫ��¼��һ�������Ľڵ�
		TreeNode next;
		while(head != null) {
			next = head.next;
			
			// ֵС��x�Ľڵ㶼��������������������������
			if(head.val < x) {
				left.next = head;
				left  =left.next;
			}else {
				right.next = head;
				right = right.next;
			}
			
			// �Ͽ�����
			head.next = null;
			
			head = next;
		}
		
		// ƴ�Ӳ���   ������β�ڵ�ָ��������ͷ�ڵ�
		left.next = rightOne.next;
		return leftOne.next;
	}
	
	/** 
	 * �ⷨ����ʹ��ͷ�巨
	 * ����˼·��ʹ��ͷ�巨���ɣ����п�ʼѭ���Ľڵ�Ϊhead.next����Ϊhead�����ж�
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
