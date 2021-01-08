package �����㷨ˢ��.�ݹ�ϵ��;

import java.util.LinkedList;
import java.util.Queue;

public class �������������� {
	
	/** 
	 * ��Ŀ������һ�����������ҳ��������ȡ�
	 *     �����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����
	 */
	
	/** 
	 * ʾ����
	 *    ���룺���������� [3,9,20,null,null,15,7]
	 *    �����3
	 */
	
	/** 
	 * �ⷨһ���ݹ�
	 * ����˼·������֪��������������������������l��r����ô�ö�������������Ϊ��max(l,r) + 1
	 * ʱ�临�Ӷȣ�O(n)������nΪ�������ڵ�ĸ�����ÿ���ڵ��ڵݹ���ֻ����һ�Ρ�
	 * �ռ临�Ӷȣ�O(height)������heightΪ�������ĸ߶ȡ�
	 */
	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}else {
			int leftHeight = maxDepth(root.left);
			int rightHeight = maxDepth(root.right);
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	/** 
	 * �ⷨ���������������
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ��˷����ռ������ȡ���ڶ��д洢��Ԫ�����������������»�ﵽO(n)��
	 */
	public int maxDepth1(TreeNode root) {
		if(root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int ans = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size > 0) {
				TreeNode node = queue.poll();
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
				size --;
			}
			ans ++;
		}
		return ans;
	}

}
