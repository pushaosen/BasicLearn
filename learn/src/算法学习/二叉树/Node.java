package �㷨ѧϰ.������;

/**
 * �������Ľڵ���
 * @author lenovo
 *
 */
public class Node {

	public int data;   // �ڵ�����
	public Node leftChild;  // ���ӽڵ������
	public Node rightChild; // ���ӽڵ������
	
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
