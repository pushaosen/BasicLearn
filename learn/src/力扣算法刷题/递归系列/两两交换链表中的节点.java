package �����㷨ˢ��.�ݹ�ϵ��;

public class �������������еĽڵ� {
	
	/** 
	 * ��Ŀ������һ���������������������ڵĽڵ㣬�����ؽ����������
	 *     �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
	 */
	
	/** 
	 * ʾ����
	 *    ���룺head = [1,2,3,4]
	 *    �����[2,1,4,3]
	 *    
	 *    ���룺head = []
	 *    �����[]
	 *    
	 *    ���룺head = [1]
	 *    �����[1]
	 */
	
	/** 
	 * �ⷨһ���ݹ�
	 * ʱ�临�Ӷȣ�O(n)������n������Ľڵ���������Ҫ��ÿ���ڵ���и���ָ��Ĳ�����
	 * �ռ临�Ӷȣ�O(n)������n������Ľڵ��������ռ临�Ӷ���Ҫȡ���ڵݹ���õ�ջ�ռ䡣
	 */
	public TreeNode swapPairs(TreeNode head) {
		// �ݹ���õĽ����ݹ������
		if(head == null || head.next == null) {
			return head;
		}
		TreeNode newHead = head.next;
		// ���еݹ����
		head.next = swapPairs(newHead.next);
		newHead.next = head;
		return newHead;
	}
	
	/** 
	 * �ⷨ���������ⷨ
	 * ʱ�临�Ӷȣ�O(n)������n������Ľڵ���������Ҫ��ÿ���ڵ���и���ָ��Ĳ�����
	 * �ռ临�Ӷȣ�O(1)
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
