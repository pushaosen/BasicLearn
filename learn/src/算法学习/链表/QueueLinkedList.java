package 算法学习.链表;

/**
 * 用双端链表实现队列
 * @author lenovo
 *
 */
public class QueueLinkedList {
	
	private DoublePointLinkedList dp;
	
	// 构造方法
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
