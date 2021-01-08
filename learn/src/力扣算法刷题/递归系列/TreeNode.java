package 力扣算法刷题.递归系列;

public class TreeNode {

	public int val;   
	public int min;  // 最小值 
	public TreeNode next;
	public TreeNode left;
	public TreeNode right;
	
	// 构造方法：进行字段的初始化工作
	public TreeNode(int val, int min, TreeNode next) {
		this.val = val;
		this.min = min;
		this.next = next;
	}
	
	/** 
	 * 只传一个具体值的构造方法
	 * @param value
	 */
	public TreeNode(int value) {
		this.val = value;
	}
}
