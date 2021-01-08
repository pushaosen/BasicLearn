package 力扣算法刷题.递归系列;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 重建二叉树 {
	
	/** 
	 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
	 * 
	 * 限制：0 <= 节点个数 <= 5000
	 */
	
	/** 
	 * 示例：
	 *    给出：
	 *        前序遍历 preorder = [3,9,20,15,7]
	 *        中序遍历 inorder = [9,3,15,20,7]
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		重建二叉树 obj = new 重建二叉树();
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		TreeNode result = obj.buildTree(preorder, inorder);
		System.out.println("递归解法的结果为：" + result);
		result = obj.buildTree1(preorder, inorder);
		System.out.println("迭代解法的结果为：" + result);
	}
	
	/** 
	 * 解法一：递归
	 * 时间复杂度：O(n)，对于每个节点都有创建过程以及根据左右子树重建过程。
	 * 空间复杂度：O(n)，存储整棵树的开销。
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
	 * 解法二：迭代
	 * 时间复杂度：O(n)，前序遍历和后序遍历都被遍历。
	 * 空间复杂度：O(n)，额外使用栈存储已经遍历过的节点。
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
