package �㷨ѧϰ.ͼ;

/**
 * �Զ������
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
	
	// ���
	public void inseart(int j) {
		if(rear == SIZE - 1) {
			rear = -1;
		}
		queArray[++ rear] = j;
	}
	
	// ����
	public int remove() {
		if(!isEmpty()) {
			return queArray[front ++];
		}
		return -1;
	}

	// �ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return (rear + 1 == front);
	}

}
