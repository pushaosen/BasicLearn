package �����㷨ˢ��.ջϵ��;

import java.util.Stack;

/** 
 * �ⷨ�����ܿصݹ�
 * @author lenovo
 *
 */
public class ����������������֮�ܿصݹ� {

	private Stack<TreeNode> stack;
	
	public ����������������֮�ܿصݹ�(TreeNode root) {
		this.stack = new Stack<TreeNode>();
		// ��ʼ���������߼���
		this._leftmostInorder(root);
	}

	/** 
	 * 
	 */
	private void _leftmostInorder(TreeNode root) {
		while(root != null) {
			this.stack.push(root);
			root = root.left;
		}
	}
	
	/** 
	 * ��ȡ��һ��Ԫ��
	 * ʱ�临�Ӷȣ�O(1)
	 * �ռ临�Ӷȣ�O(h)
	 */
	public int next() {
		 TreeNode topmostNode = this.stack.pop();
		 if(topmostNode.right != null) {
			 // ����Ѱ���ҽڵ㣬ֱ���ҽڵ�û���ӽڵ㣬�����ҵ�Ŀ��
			 this._leftmostInorder(topmostNode.right);
		 }
		 
		 return topmostNode.val;
	}
	
	/** 
	 * �Ƿ�����һ��Ԫ��
	 * ʱ�临�Ӷȣ�O(1)
	 * �ռ临�Ӷȣ�O(h)
	 */
	public boolean hasNext() {
		return this.stack.size() > 0;
	}
}
