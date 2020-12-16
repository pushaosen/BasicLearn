package �����㷨ˢ��.ջϵ��;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class �������ĺ������ {

	/** 
	 * ��Ŀ������һ������������������ ���� ����
	 */
	
	/**
	 * �ⷨһ���ݹ�ⷨ
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 */
	public static List<Integer> fun(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		postorder(root, res);
		return res;
	}

	private static void postorder(TreeNode root, List<Integer> res) {
		if(root == null) {
			return;
		}
		// �ȱ������ӵĽڵ��ֵ
		postorder(root.left, res);
		// �ٱ����Һ��ӽڵ��ֵ
		postorder(root.right, res);
		// �ٴ�����ڵ��ֵ
		res.add(root.val);
	}
	
	/** 
	 * �ⷨ���������ⷨ
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n) 
	 */
	public static List<Integer> postorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode prev = null;
		while(root != null || !stack.isEmpty()) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if(root.right == null || root.right == prev) {
				res.add(root.val);
				prev = root;
				root = null;
			}else {
				stack.push(root);
				root = root.right;
			}
		}
		return res;
	} 
}
