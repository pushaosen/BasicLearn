package �����㷨ˢ��.ջϵ��;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ��������������� {

	/** 
	 * ��Ŀ������һ���������ĸ��ڵ� root ���������� ���� ����
	 */
	
	/** 
	 * ����һ���ݹ�ⷨ
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 */
	public static List<Integer> fun(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		inorder(root, res);
		return res;
	}

	private static void inorder(TreeNode root, List<Integer> res) {
		if(root == null) {
			return;
		}
		// �ȱ������ӽڵ��ֵ
		inorder(root.left, res);
		// �ٱ������ڵ��ֵ
        res.add(root.val);
        // �ٱ����Һ��ӽڵ��ֵ
        inorder(root.right, res);
	}
	
	/** 
	 * �������� ջ�ⷨ
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 */
	public static List<Integer> inorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		Deque<TreeNode> stk = new LinkedList<TreeNode>();
		while(root != null || !stk.isEmpty()) {
			while(root != null) {
				stk.push(root);
				root = root.left;
			}
			root = stk.pop();
			res.add(root.val);
			root = root.right;
		}
		return res;
	}
	
	/** 
	 * �ⷨ����Morris �������
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 */
	public static List<Integer> inorderTraversal1(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor �ڵ���ǵ�ǰ root �ڵ�������һ����Ȼ��һֱ���������޷���Ϊֹ
                predecessor = root.left;
                // һֱѭ�������õ����һ���Һ���
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                
                // �� predecessor ����ָ��ָ�� root����������������
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // ˵���������Ѿ��������ˣ�������Ҫ�Ͽ�����
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // ���û�����ӣ���ֱ�ӷ����Һ���
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
	}
}

