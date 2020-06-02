package 算法学习.图;

/**
 * 自定义队列
 * @author lenovo
 *
 */
public class QueueQ {
	
	private final int SIZE = 20;
	private int[] queArray;
	private int front;
	private int rear;
	
	public QueueQ() {
		queArray = new int[SIZE];
		front = 0;
		rear = -1;
	}
	
	// 入队
	public void inseart(int j) {
		if(rear == SIZE - 1) {
			rear = -1;
		}
		queArray[++ rear] = j;
	}
	
	// 出队
	public int remove() {
		if(!isEmpty()) {
			return queArray[front ++];
		}
		return -1;
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return (rear + 1 == front);
	}

}
