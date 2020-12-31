package �����㷨ˢ��.����ϵ��;

public class ���ѭ������ {
	
	/** 
	 * ��Ŀ��������ѭ������ʵ�֡�ѭ��������һ���������ݽṹ����������ֻ���FIFO(�Ƚ��ȳ�)ԭ���Ҷ�β�������ڶ���֮�����γ�һ��ѭ������Ҳ����Ϊ"���λ�����";
	 * 
	 * ѭ�����е�һ���ô������ǿ��������������֮ǰ�ù��Ŀռ䡣��һ����ͨ�Ķ����һ��һ���������ˣ����ǾͲ��ܲ�����һ��Ԫ�أ���ʹ�ڶ���ǰ�����пռ䣬����ʹ��ѭ��
	 * ���У�������ʹ����Щ�ռ�ȥ�洢�µ�ֵ��
	 * 
	 * ���ʵ��Ӧ��֧�����²�����
	 *    MyCircularQueue(k): �����������ö��г���Ϊ k ��
	 *    Front: �Ӷ��׻�ȡԪ�ء��������Ϊ�գ����� -1 ��
	 *    Rear: ��ȡ��βԪ�ء��������Ϊ�գ����� -1 ��
	 *    enQueue(value): ��ѭ�����в���һ��Ԫ�ء�����ɹ������򷵻��档
	 *    deQueue(): ��ѭ��������ɾ��һ��Ԫ�ء�����ɹ�ɾ���򷵻��档
	 *    isEmpty(): ���ѭ�������Ƿ�Ϊ�ա�
	 *    isFull(): ���ѭ�������Ƿ�������
	 */
	
	/** 
	 * �ⷨһ������(���̰߳�ȫ�ģ�����ʹ�ü���)
	 * ʱ�临�Ӷȣ�O(1)�������ݽṹ�У����з��������к㶨��ʱ�临�Ӷ�
	 * �ռ临�Ӷȣ�O(N)������N�Ƕ���Ԥ����������ѭ�����е��������������У������и�Ԥ����Ŀռ䡣
	 * 
	 */
	private int[] queue;
	private int headIndex;
	private int count;
	private int capacity;
	
	public ���ѭ������(int k) {
		this.capacity = k;
		this.queue = new int[k];
		this.headIndex = 0;
		this.count = 0;
	}
	
	/** 
	 * ��ѭ�������в���һ��Ԫ�� 
	 */
	public boolean enQueue(int value) {
		if(this.count == this.capacity) {
			return false;
		}
		this.queue[(this.headIndex + this.count) % this.capacity] = value;
		this.count += 1;
		return true;
	}
	
	/** 
	 * ��ѭ��������ɾ��һ��Ԫ��
	 */
	public boolean deQueue() {
		if(this.count == 0) {
			return false;
		}
		this.headIndex = (this.headIndex + 1) % this.capacity;
		this.count -= 1;
		return true;
	}
	
	/** 
	 * �Ӷ����л�ȡ������ǰ���Ԫ��
	 */
	public int Front() {
		if(this.count == 0) {
			return -1;
		}
		return this.queue[this.headIndex];
	}
	
	/** 
	 * ��ȡѭ���������������Ǹ�Ԫ��
	 */
	public int Rear() {
		if(this.count == 0) {
			return -1;
		}
		int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
		return this.queue[tailIndex];
	}

	/** 
	 * ���ѭ�������Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return this.count == 0;
	}
	
	/** 
	 * ���ѭ�������Ƿ��Ѿ�����
	 */
	public boolean isFull() {
		return this.count == this.capacity;
	}
	
	/**
	 * �ⷨ����ʹ�õ�����
	 * ʱ�临�Ӷȣ�O(1)
	 * �ռ临�Ӷȣ�O(N)
	 */
	private Node head, tail;
	private int count1;  // ��ǰ���г��ȡ������������߽���
	private int capacity1;  // ѭ�������п����ɵ����Ԫ�ص�����
	
	public ���ѭ������(int k, int state) {
		this.capacity1 = k;
	}
	
	/**
	 * ��ѭ�������в���һ��Ԫ��
	 */
	public boolean enQueue1(int value) {
		if(this.count1 == this.capacity1) {
			return false;
		}
		
		Node newNode = new Node(value);
		if(this.count == 0) {
			head = tail = newNode;
		}else {
			tail.nextNode = newNode;
			tail = newNode;
		}
		this.count1 = 1;
		return true;
	}
	
	/** 
	 * �Ӷ�����ɾ��һ��Ԫ��
	 */
	public boolean deQueue1() {
		if(this.count1 == 0) {
			return false;
		}
		this.head = this.head.nextNode;
		this.count1 -= 1;
		return true;
	}
	
	/** 
	 * ��ȡ������ǰ���Ԫ��
	 */
	public int Front1() {
		if(this.count1 == 0) {
			return -1;
		}
		return this.head.value;
	}
	
	/** 
	 * ��ȡ����������Ԫ��
	 */
	public int Rear1() {
		if(this.count1 == 0) {
			return -1;
		}
		return this.tail.value;
	}
	
	/**
	 * �ж϶����Ƿ�Ϊ��
	 */
	public boolean isEmpty1() {
		return this.count1 == 0;
	}
	
	/** 
	 * �ж϶����Ƿ��Ѿ�����
	 */
	public boolean isFull1() {
		return this.capacity1 == this.count1;
	}
}
