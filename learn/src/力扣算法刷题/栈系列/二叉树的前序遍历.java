package �����㷨ˢ��.ջϵ��;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ��������ǰ����� {
	/* 
	 * ��Ŀ������������ĸ��ڵ� root ���������ڵ�ֵ�� ǰ�� ����
	 */

	/**
 	 * �ⷨһ���ݹ�ⷨ 
 	 * ʱ�临�Ӷȣ�O(n)
 	 * �ռ临�Ӷȣ�O(n)
	 */
	public static List<Integer> fun(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		preorder(root, res);
        return res;
	}

	private static void preorder(TreeNode root, List<Integer> res) {
		// �ݹ�Ľ�������
		if(root == null) {
			return;
		}
		// �Ȼ�ȡ���ڵ��ֵ
		res.add(root.val);
		// �ٻ�ȡ���ӵ�ֵ
		preorder(root.left, res);
		// �ٻ�ȡ�Һ��ӵ�ֵ
		preorder(root.right, res);
	}
	
	/** 
	 * �ⷨ��������
	 *  ʱ�临�Ӷȣ�O(n)
	 *  �ռ临�Ӷȣ�O(n)
	 */
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode node = root;
		while(!stack.isEmpty() || node != null) {
			while(node != null) {
				res.add(node.val);
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			node = node.right;
		}
		return res;
	}
}
