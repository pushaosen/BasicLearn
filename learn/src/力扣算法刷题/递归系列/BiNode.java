package �����㷨ˢ��.�ݹ�ϵ��;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BiNode {
	
	/** 
	 * ��Ŀ��
	 *    ���������ݽṹTreeNode��������ʾ������������left�ÿգ�rightΪ��һ������ڵ㣩��ʵ��һ��������
	 *    �Ѷ���������ת��Ϊ��������Ҫ����Ȼ���϶��������������ʣ�ת������Ӧ��ԭַ�ģ�Ҳ������ԭʼ�Ķ�����������ֱ���޸ġ�
	 *    ����ת����ĵ��������ͷ��㡣
	 */
	
	/** 
	 * ʾ����
	 *    ���룺[4,2,5,1,3,null,6,0]
	 *    �����[0,null,1,null,2,null,3,null,4,null,5,null,6]
	 */
	
	/** 
	 * �ⷨһ���ݹ�ʵ��
	 * ����˼·��
	 *       ʹ�������������ȡ�������Ľڵ�ֵ������Щ�����Ľ��ֵ������Ŀ��Ҫ�Ķ���������
	 * ȱ�ݣ�ʱ�临�ӶȽϸ�
	 */
	public TreeNode convertBiNode(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		convertBiNode(root, list);
		return listToTreeNode(list);
	}
	private void convertBiNode(TreeNode root, List<Integer> list) {
		if(root == null) {
			return;
		}
		convertBiNode(root.left, list);
		list.add(root.val);
		convertBiNode(root.right, list);
	}
	private TreeNode listToTreeNode(List<Integer> list) {
		if(list.size() == 0) {
			return null;
		}
		TreeNode root = new TreeNode(list.get(0));
		TreeNode cur = root;
		for(int i = 1; i < list.size(); i ++) {
			cur.left = null;
			cur.right = new TreeNode(list.get(i));
			cur = cur.right;
		}
		return root;
	}
	
	/** 
	 * �ⷨ������ʱ�Ƚ��ٵĵݹ�
	 * �õݹ鷽����Ч��Ҫ�Ƚⷨ���ķǵݹ鷽����Ч��Ҫ��
	 */
	public TreeNode convertBiNode1(TreeNode root) {
		TreeNode head = new TreeNode(0);   // �������ͷָ���ڱ�
		// ��ʼ�������
		inorder(root, head);
		return head.right;
	}
	private TreeNode inorder(TreeNode root, TreeNode prev) {
		if(root != null) {
			prev = inorder(root.left, prev);
			root.left = null;
			prev.right = root;
			prev = root;
			prev = inorder(root.right, prev);
		}
		return prev;
	}
	
	/** 
	 * �ⷨ�����ǵݹ�
	 */
	public TreeNode convertBiNode2(TreeNode root) {
		TreeNode head = new TreeNode(0);   // �������ͷָ���ڱ�
		TreeNode prev = head;   // �ƶ�������ǰ��ָ��
		// ��ʼ�������
		TreeNode node = root;
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		while(node != null || !stack.isEmpty()) {
			if(node != null) {
				stack.push(node);
				node = node.left;
			}else {
				node = stack.pop();
				// ---- ������
				node.left = null;   // ��ǰ�ڵ�ָ���ÿ�
				prev.right = node;  // ǰ��ָ����ָ��ָ��ǰ�ڵ㣬��Ϊ�����nextָ�룬��������Ԫ��
				prev = node;   // ָ�����
				// ----������
				// �����������������
				node = node.right;
			}
		}
		return head.right;
	}

}
