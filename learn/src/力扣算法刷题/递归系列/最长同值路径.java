package �����㷨ˢ��.�ݹ�ϵ��;

public class �ֵͬ·�� {
	
	/** 
	 * ��Ŀ������һ�����������ҵ����·�������·���е�ÿ���ڵ������ֵͬ�� ����·�����Ծ���
	 *     ��Ҳ���Բ��������ڵ㡣
	 *     
	 * ע�⣺�����ڵ�֮���·������������֮��ı�����ʾ��
	 */

	/**
	 * �ⷨһ���ݹ�
	 * ʱ�临�Ӷȣ�O(N)������N�����нڵ��������Ǵ���ÿ���ڵ�һ�Ρ�
	 * �ռ临�Ӷȣ�O(H)������H�����ĸ߶ȡ����ǵݹ����ջ���ԴﵽH�����ȡ�
	 */
	int ans;
	public int longestUnivaluePath(TreeNode root) {
		ans = 0;
		arrowLength(root);
		return ans;
	}
	private int arrowLength(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = arrowLength(root.left);
		int right = arrowLength(root.right);
		int arrowLeft = 0, arrowRight = 0;
		if(root.left != null && root.left.val == root.val) {
			arrowLeft += left + 1;
		}
		if(root.right != null && root.right.val == root.val) {
			arrowRight += right + 1;
		}
		ans = Math.max(ans, arrowLeft + arrowRight);
		return Math.max(arrowLeft, arrowRight);
	}
}
