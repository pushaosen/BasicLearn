package �����㷨ˢ��.�ݹ�ϵ��;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class �����������ڵ���С���� {
	
	/**
	 * ��Ŀ������һ�������������ĸ��ڵ� root�����������������ڵ�Ĳ����Сֵ��
	 */
	
	/** 
	 * ʾ����
	 *    ���룺root = [4,2,6,1,3,null,null]
	 *    �����1
	 */
	
	/** 
	 * �ⷨһ������
	 * ����˼·�����������нڵ��ֵд�����飬֮�������������μ���������֮��Ĳ�ֵ���ҳ����е���Сֵ
	 * ʱ�临�Ӷȣ�O(NlogN)������ NN �����нڵ�ĸ�������Ϊ���������ĵ�ʱ�䡣
	 * �ռ临�Ӷȣ�O(N)����Ϊ vals �Ĵ�С��
	 */
	List<Integer> vals;
	public int minDiffInBST(TreeNode root) {
		vals = new ArrayList<>();
		dfs(root);
		Collections.sort(vals);
		
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < vals.size(); ++ i) {
			ans = Math.max(ans, vals.get(i + 1) - vals.get(i));
		}
		return ans;
	}
	private void dfs(TreeNode root) {
		if(root == null) {
			return;
		}
		vals.add(root.val);
		dfs(root.left);
		dfs(root.right);
	}
	
	/** 
	 * �ⷨ�����������
	 * ����˼·���ڶ����������У���������Ὣ���нڵ㰴��ֵ��С˳�������ֻ��Ҫ���������������Ĳ�ֵ��ȡ������С�ľͿ�����
	 * ʱ�临�Ӷȣ�O(N)������ N Ϊ���нڵ�ĸ���
	 * �ռ临�Ӷȣ�O(H)������ H Ϊ���ĸ߶ȣ���Ϊ�ݹ���� dfs ��������ջ�Ĵ�С
	 */
	Integer prev, ans;
	public int minDiffInBST1(TreeNode root) {
		prev = null;
		ans = Integer.MAX_VALUE;
		dfs1(root);
		return ans;
	}
	private void dfs1(TreeNode root) {
		if(root == null) {
			return;
		}
		dfs1(root.left);
		if(prev != null) {
			ans = Math.min(ans, root.val - prev);
		}
		prev = root.val;
		dfs1(root.right);
	}
}
