package 力扣算法刷题.堆系列;

public class TreeNode {

	public int val;   
	public int min;  // 最小值 
	public TreeNode next;
	
	// 构造方法：进行字段的初始化工作
	public TreeNode(int val, int min, TreeNode next) {
		this.val = val;
		this.min = min;
		this.next = next;
	}
}
