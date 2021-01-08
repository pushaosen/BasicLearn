package �����㷨ˢ��.�ݹ�ϵ��;

public class ƽ������� {
	
	/** 
	 * ��Ŀ������һ�����������ж����Ƿ��Ǹ߶�ƽ��Ķ�������
	 *     �����У�һ�Ÿ߶�ƽ�����������Ϊ��
	 *          һ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������ 1 ��
	 */

	/** 
	 * �ⷨһ���Զ����µĵݹ�
	 * ����˼·�����˼���ڵ�߶ȵĺ����������ж϶������Ƿ�ƽ�⡣�������������ڶ�������ǰ������������ڵ�ǰ�������Ľڵ㣬���ȼ������������ĸ߶ȣ�������������ĸ߶Ȳ��Ƿ񲻳���1���ٷֱ�ݹ�
	 *       �ر��������ӽڵ㣬���ж����������������Ƿ�ƽ�⡣����һ���Զ����µĵݹ�Ĺ��̡�
	 * ʱ�临�Ӷȣ�O(n*n)
	 * �ռ临�Ӷȣ�O(n)
	 */
	public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}else {
			return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
		}
	}
    // ��ȡ�ڵ�ĸ߶�
	private int height(TreeNode root) {
		if(root == null) {
			return 0;
		}else {
			return Math.max(height(root.left), height(root.right));
		}
	}
	
	/** 
	 * �ⷨ�����Ե����ϵĵݹ�
	 * ����˼·������һ�������Զ����µݹ飬��˶���ͬһ���ڵ㣬����height�ᱻ�ظ����ã�����ʱ�临�ӶȽϸߡ����ʹ���Ե����ϵ������������ÿ���ڵ㣬����heightֻ�ᱻ����һ�Ρ�
	 *        �Ե����ϵݹ�����������ں�����������ڵ�ǰ�������Ľڵ㣬�ȵݹ���ж����������Ƿ�ƽ�⣬���ж��Ե�ǰ�ڵ�Ϊ���ڵ�������Ƿ�ƽ�⡣���һ��������ƽ��ģ��򷵻���߶ȣ����򷵻�-1.
	 *        �������һ��������ƽ�⣬������������һ����ƽ��
	 * ʱ�临�Ӷȣ�O(n)������n�Ƕ������еĽڵ������ʹ���Զ����ϵĵݹ飬ÿ���ڵ�ļ���߶Ⱥ��ж��Ƿ�ƽ�ⶼֻ��Ҫ����һ�Σ���������Ҫ�����������е����нڵ㣬���ʱ�临�Ӷ���O(n)��
	 * �ռ临�Ӷȣ�O(n)������n�Ƕ������еĽڵ�������ռ临�Ӷ���Ҫȡ���ڵݹ���õĲ������ݹ���õĲ������ᳬ��n��
	 */
	public boolean isBalanced1(TreeNode root) {
		return height1(root) >= 0;
	}
	// ��ȡ�ڵ�ĸ߶�
	private int height1(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = height1(root.left);
		int rightHeight = height1(root.right);
		if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
	}
}
