package 力扣算法刷题.栈系列;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的中序遍历 {

	/** 
	 * 题目：给定一个二叉树的根节点 root ，返回它的 中序 遍历
	 */
	
	/** 
	 * 方法一、递归解法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
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
		// 先遍历左孩子节点的值
		inorder(root.left, res);
		// 再遍历根节点的值
        res.add(root.val);
        // 再遍历右孩子节点的值
        inorder(root.right, res);
	}
	
	/** 
	 * 方法二： 栈解法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
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
	 * 解法三：Morris 中序遍历
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 */
	public static List<Integer> inorderTraversal1(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                // 一直循环遍历拿到最后一个右孩子
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                
                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
	}
}

