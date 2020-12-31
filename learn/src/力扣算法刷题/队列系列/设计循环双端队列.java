package �����㷨ˢ��.����ϵ��;

public class ���ѭ��˫�˶��� {

	/** 
	 * ��Ŀ�����ʵ��˫�˶���
	 * ���ʵ��Ҫ֧�����²�����
	 * MyCircularDeque(k)�����캯��,˫�˶��еĴ�СΪk��
	 * insertFront()����һ��Ԫ����ӵ�˫�˶���ͷ���� ��������ɹ����� true��
	 * insertLast()����һ��Ԫ����ӵ�˫�˶���β������������ɹ����� true��
	 * deleteFront()����˫�˶���ͷ��ɾ��һ��Ԫ�ء� ��������ɹ����� true��
	 * deleteLast()����˫�˶���β��ɾ��һ��Ԫ�ء���������ɹ����� true��
	 * getFront()����˫�˶���ͷ�����һ��Ԫ�ء����˫�˶���Ϊ�գ����� -1��
	 * getRear()�����˫�˶��е����һ��Ԫ�ء� ���˫�˶���Ϊ�գ����� -1��
	 * isEmpty()�����˫�˶����Ƿ�Ϊ�ա�
	 * isFull()�����˫�˶����Ƿ����ˡ�
	 */
	
	/** 
	 * �ⷨһ������ʵ��
	 */
	private int capacity;
	private int[] arr;
	private int front;
	private int rear;
	
	public ���ѭ��˫�˶���(int k) {
		capacity = k + 1;
		arr = new int[capacity];
		// ͷ��ָ���1�����Ԫ�ص�λ��
		// ����ʱ���ȼ����ٸ�ֵ
		// ɾ��ʱ������ +1(ע��ȡģ)
		front = 0;
		// β��ָ����һ������Ԫ�ص�λ��
		// ����ʱ���ȸ�ֵ���ټ�
		// ɾ��ʱ������ -1(ע��ȡģ)
		rear = 0;
	}
	
	/** 
	 * ������ǰ�����һ��Ԫ��
	 */
	public boolean insertFront(int value) {
		if(isFull()) {
			return false;
		}
		front = (front - 1 + capacity) % capacity;
		arr[front] = value;
		return true;
	}

	/** 
	 * �ڶ���β������һ��Ԫ��
	 */
	public boolean insertLast(int value) {
		if(isFull()) {
			return false;
		}
		arr[rear] = value;
		rear = (rear + 1) % capacity;
		return true;
	}
	
	/** 
	 * ɾ��������ǰ���Ԫ��
	 * @return
	 */
	public boolean deleteFront() {
		if(isEmpty()) {
			return false;
		}
		// front�����������Ŀ�ͷ�������� +1
		front = (front + 1) % capacity;
		return true;
	}
	
	/** 
	 * ɾ������������Ԫ��
	 */
	public boolean deleteLast() {
		if(isEmpty()) {
			return false;
		}
		// rear������������ĩβ�������� -1
		rear = (rear - 1 + capacity) % capacity;
		return true;
	}
	
	/** 
	 * ��ȡ������ǰ���Ԫ��
	 */
	public int getFront() {
		if(isEmpty()) {
			return -1;
		}
		return arr[front];
	}
	
	/** 
	 * ��ȡ������β����Ԫ��
	 */
	public int getRear() {
		if(isEmpty()) {
			return -1;
		}
		return arr[(rear - 1 + capacity) % capacity];
	}
	
	/** 
	 * �ж϶����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return front == rear;
	}

	/** 
	 * �ж϶����Ƿ�����
	 */
	public boolean isFull() {
		// ע�⣺�������Ƿǳ����������
		return (rear + 1) % capacity == front;
	}
	
}
