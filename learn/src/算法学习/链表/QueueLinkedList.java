package �㷨ѧϰ.����;

/**
 * ��˫������ʵ�ֶ���
 * @author lenovo
 *
 */
public class QueueLinkedList {
	
	private DoublePointLinkedList dp;
	
	// ���췽��
	public QueueLinkedList() {
		dp = new DoublePointLinkedList();
	}
	
	public void insert(Object data) {
		dp.addTail(data);
	}
	
	public void delete() {
		dp.deleteHead();
	}
	
	public boolean isEmpty() {
		return dp.isEmpty();
	}
	
	public int getSize() {
		return dp.getSize();
	}
	
	public void display() {
		dp.display();
	}

}
