package 算法学习.二叉树;

/**
 * 二叉树的节点类
 * @author lenovo
 *
 */
public class Node {

	public int data;   // 节点数据
	public Node leftChild;  // 左子节点的引用
	public Node rightChild; // 右子节点的引用
	
	 public Node(int data){
        this.data = data;
    }
	
	public void display() {
		System.out.println(data);
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}
	
	
}
