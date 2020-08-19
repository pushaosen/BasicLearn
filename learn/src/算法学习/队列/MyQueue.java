package �㷨ѧϰ.����;

/**
 * ����
 * @author lenovo
 *
 */
public class MyQueue {
	
	private Object[] queArray;
	// �����ܴ�С
	private int maxSize;
	// ǰ��
	private int front;
	// ���
	private int rear;
	// ������Ԫ�ص�ʵ����Ŀ
	private int nItems;
	
	public MyQueue(int s) {
		maxSize = s;
		queArray = new Object[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	// ��������������
	public void insert(int value) {
		if(isFull()) {
			System.out.println("��������!!!");
		}else {
			// �������β��ָ���ˣ���ôѭ��������ִ�ж��еĵ�һ��Ԫ��
			if(rear == maxSize - 1) {
				rear = -1;
			}
			// ��βָ���1��Ȼ���ڶ�βָ�봦�����µ�����
			queArray[++rear] = value;
			nItems ++;
		}
	}
	
	// �Ƴ�����
	public Object remove() {
		Object removeValue = null;
		if(!isFull()) {
			removeValue = queArray[front];
			queArray[front] = null;
			front ++;
			if(front == maxSize) {
				front = 0;
			}
			nItems --;
			return removeValue;
		}
		return removeValue;
	}
	
	// �鿴��ͷ����
	public Object peekFront() {
		return queArray[front];
	}
	
	// �ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return (nItems  == 0);
	}
	
	// ���ض��еĴ�С
	public int getSize() {
		return nItems;
	}
	
	// �ж϶����Ƿ�����
	public boolean isFull() {
		return (nItems == maxSize);
	}
	
	// ����
	public static void main(String[] args) {
		MyQueue queue = new MyQueue(3);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);//queArray��������Ϊ[1,2,3]
         
        System.out.println(queue.peekFront()); //1
        queue.remove();//queArray��������Ϊ[null,2,3]
        System.out.println(queue.peekFront()); //2
         
        queue.insert(4);//queArray��������Ϊ[4,2,3]
        queue.insert(5);//��������,queArray��������Ϊ[4,2,3]
	}

}
