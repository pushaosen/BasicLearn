package 力扣算法刷题.队列系列;

public class 设计循环双端队列 {

	/** 
	 * 题目：设计实现双端队列
	 * 你的实现要支持以下操作：
	 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
	 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
	 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
	 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
	 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
	 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
	 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
	 * isEmpty()：检查双端队列是否为空。
	 * isFull()：检查双端队列是否满了。
	 */
	
	/** 
	 * 解法一：数组实现
	 */
	private int capacity;
	private int[] arr;
	private int front;
	private int rear;
	
	public 设计循环双端队列(int k) {
		capacity = k + 1;
		arr = new int[capacity];
		// 头部指向第1个存放元素的位置
		// 插入时，先减，再赋值
		// 删除时，索引 +1(注意取模)
		front = 0;
		// 尾部指向下一个插入元素的位置
		// 插入时，先赋值，再加
		// 删除时，索引 -1(注意取模)
		rear = 0;
	}
	
	/** 
	 * 队列最前面添加一个元素
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
	 * 在队列尾部插入一个元素
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
	 * 删除队列最前面的元素
	 * @return
	 */
	public boolean deleteFront() {
		if(isEmpty()) {
			return false;
		}
		// front被设计在数组的开头，所以是 +1
		front = (front + 1) % capacity;
		return true;
	}
	
	/** 
	 * 删除队列最后面的元素
	 */
	public boolean deleteLast() {
		if(isEmpty()) {
			return false;
		}
		// rear被设计在数组的末尾，所以是 -1
		rear = (rear - 1 + capacity) % capacity;
		return true;
	}
	
	/** 
	 * 获取队列最前面的元素
	 */
	public int getFront() {
		if(isEmpty()) {
			return -1;
		}
		return arr[front];
	}
	
	/** 
	 * 获取队列最尾部的元素
	 */
	public int getRear() {
		if(isEmpty()) {
			return -1;
		}
		return arr[(rear - 1 + capacity) % capacity];
	}
	
	/** 
	 * 判断队列是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return front == rear;
	}

	/** 
	 * 判断队列是否已满
	 */
	public boolean isFull() {
		// 注意：这个设计是非常经典的做法
		return (rear + 1) % capacity == front;
	}
	
}
