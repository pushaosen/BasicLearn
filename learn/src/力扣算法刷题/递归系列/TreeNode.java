package �����㷨ˢ��.�ݹ�ϵ��;

public class TreeNode {

	public int val;   
	public int min;  // ��Сֵ 
	public TreeNode next;
	public TreeNode left;
	public TreeNode right;
	
	// ���췽���������ֶεĳ�ʼ������
	public TreeNode(int val, int min, TreeNode next) {
		this.val = val;
		this.min = min;
		this.next = next;
	}
	
	/** 
	 * ֻ��һ������ֵ�Ĺ��췽��
	 * @param value
	 */
	public TreeNode(int value) {
		this.val = value;
	}
}
