package �����㷨ˢ��.ջϵ��;

import java.util.ArrayList;

/** 
 * �ⷨһ����ƽ������������
 */
public class ���������������� {

	/** 
	 * ��Ŀ��ʵ��һ���������������������㽫ʹ�ö����������ĸ��ڵ��ʼ�������������� next() �����ض����������е���һ����С������
	 */
	
	/** 
	 * ������������һ����Ҫ�������Ƕ����������������������������У�
	 */
	
	private ArrayList<Integer> nodesSorted;
	private int index;
	
	public ����������������(TreeNode root) {
		this.nodesSorted = new ArrayList<Integer>();
		this.index = -1;
		this._inorder(root);
	}

	private void _inorder(TreeNode root) {
		if(root == null) {
			return;
		}
		// �ȱ�����ڵ��ֵ
		this._inorder(root.left);
		// �ٱ������ڵ��ֵ
		this.nodesSorted.add(root.val);
		// �ٱ����ҽڵ��ֵ
		this._inorder(root.right);
	}
	
	/** 
	 * ��ȡ��һ����ֵ
	 * ʱ�临�Ӷȣ�O(1)
	 * �ռ临�Ӷȣ�O(N)
	 */
	public int next() {
		return this.nodesSorted.get(++this.index);
	}
	
	/** 
	 * �ж��Ƿ���Ԫ�صķ���
	 * ʱ�临�Ӷȣ�O(1)
	 * �ռ临�Ӷȣ�O(N)
	 */
	public boolean hasNext() {
		return this.index + 1 < this.nodesSorted.size();
	}
}
