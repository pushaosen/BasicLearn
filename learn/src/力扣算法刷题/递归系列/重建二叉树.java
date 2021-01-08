package �����㷨ˢ��.�ݹ�ϵ��;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class �ؽ������� {
	
	/** 
	 * ��Ŀ������ĳ��������ǰ���������������Ľ�������ؽ��ö����������������ǰ���������������Ľ���ж������ظ������֡�
	 * 
	 * ���ƣ�0 <= �ڵ���� <= 5000
	 */
	
	/** 
	 * ʾ����
	 *    ������
	 *        ǰ����� preorder = [3,9,20,15,7]
	 *        ������� inorder = [9,3,15,20,7]
	 */
	
	/** 
	 * ����
	 */
	public static void main(String[] args) {
		�ؽ������� obj = new �ؽ�������();
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		TreeNode result = obj.buildTree(preorder, inorder);
		System.out.println("�ݹ�ⷨ�Ľ��Ϊ��" + result);
		result = obj.buildTree1(preorder, inorder);
		System.out.println("�����ⷨ�Ľ��Ϊ��" + result);
	}
	
	/** 
	 * �ⷨһ���ݹ�
	 * ʱ�临�Ӷȣ�O(n)������ÿ���ڵ㶼�д��������Լ��������������ؽ����̡�
	 * �ռ临�Ӷȣ�O(n)���洢�������Ŀ�����
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || preorder.length == 0) {
			return null;
		}
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		int length = preorder.length;
		for(int i = 0; i < length; i ++) {
			indexMap.put(inorder[i], i);
		}
		TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
        return root;
	}
	private TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
		if(preorderStart > preorderEnd) {
			return null;
		}
		int rootVal = preorder[preorderStart];
		TreeNode root = new TreeNode(rootVal);
		if(preorderStart == preorderEnd) {
			return root;
		}else {
			int rootIndex = indexMap.get(rootVal);
			int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
			TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
			return root;
		}
	}
	
	/** 
	 * �ⷨ��������
	 * ʱ�临�Ӷȣ�O(n)��ǰ������ͺ����������������
	 * �ռ临�Ӷȣ�O(n)������ʹ��ջ�洢�Ѿ��������Ľڵ㡣
	 */
	public TreeNode buildTree1(int[] preorder, int[] inorder) {
		if(preorder == null || preorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		int length = preorder.length;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		int inorderIndex = 0;
		for(int i = 0; i < length; i ++) {
			int preorderVal = preorder[i];
			TreeNode node = stack.peek();
			if(node.val != inorder[i]) {
				node.left = new TreeNode(preorderVal);
				stack.push(node.left);
			}else {
				while(!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
					node = stack.pop();
					inorderIndex ++;
				}
				node.right = new TreeNode(preorderVal);
				stack.push(node.right);
			}
		}
		return root;
	}

}
