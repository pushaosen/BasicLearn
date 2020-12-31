package 力扣算法刷题.队列系列;

public class 设计循环队列 {
	
	/** 
	 * 题目：设计你的循环队列实现。循环队列是一种线性数据结构，其操作表现基于FIFO(先进先出)原则并且队尾被连接在队首之后以形成一个循环。他也被成为"环形缓冲器";
	 * 
	 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通的队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面扔有空间，但是使用循环
	 * 队列，我们能使用这些空间去存储新的值。
	 * 
	 * 你的实现应该支持如下操作：
	 *    MyCircularQueue(k): 构造器，设置队列长度为 k 。
	 *    Front: 从队首获取元素。如果队列为空，返回 -1 。
	 *    Rear: 获取队尾元素。如果队列为空，返回 -1 。
	 *    enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
	 *    deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
	 *    isEmpty(): 检查循环队列是否为空。
	 *    isFull(): 检查循环队列是否已满。
	 */
	
	/** 
	 * 解法一：数组(非线程安全的，可以使用加锁)
	 * 时间复杂度：O(1)，该数据结构中，所有方法都具有恒定的时间复杂度
	 * 空间复杂度：O(N)，其中N是队列预分配容量。循环队列的整个生命周期中，都持有该预分配的空间。
	 * 
	 */
	private int[] queue;
	private int headIndex;
	private int count;
	private int capacity;
	
	public 设计循环队列(int k) {
		this.capacity = k;
		this.queue = new int[k];
		this.headIndex = 0;
		this.count = 0;
	}
	
	/** 
	 * 向循环队列中插入一个元素 
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
	 * 从循环队列中删除一个元素
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
	 * 从队列中获取队列最前面的元素
	 */
	public int Front() {
		if(this.count == 0) {
			return -1;
		}
		return this.queue[this.headIndex];
	}
	
	/** 
	 * 获取循环队列中最后面的那个元素
	 */
	public int Rear() {
		if(this.count == 0) {
			return -1;
		}
		int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
		return this.queue[tailIndex];
	}

	/** 
	 * 检查循环队列是否为空
	 */
	public boolean isEmpty() {
		return this.count == 0;
	}
	
	/** 
	 * 检查循环队列是否已经满了
	 */
	public boolean isFull() {
		return this.count == this.capacity;
	}
	
	/**
	 * 解法二：使用单链表
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(N)
	 */
	private Node head, tail;
	private int count1;  // 当前队列长度。可以用来做边界检查
	private int capacity1;  // 循环队列中可容纳的最大元素的数量
	
	public 设计循环队列(int k, int state) {
		this.capacity1 = k;
	}
	
	/**
	 * 向循环队列中插入一个元素
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
	 * 从队列中删除一个元素
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
	 * 获取队列最前面的元素
	 */
	public int Front1() {
		if(this.count1 == 0) {
			return -1;
		}
		return this.head.value;
	}
	
	/** 
	 * 获取队列最后面的元素
	 */
	public int Rear1() {
		if(this.count1 == 0) {
			return -1;
		}
		return this.tail.value;
	}
	
	/**
	 * 判断队列是否为空
	 */
	public boolean isEmpty1() {
		return this.count1 == 0;
	}
	
	/** 
	 * 判断队列是否已经满了
	 */
	public boolean isFull1() {
		return this.capacity1 == this.count1;
	}
}
