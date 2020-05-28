package 算法学习.链表;

/**
 * 双向链表
 * @author lenovo
 *
 */
public class TwoWayLinkedList {
	
	private Node head;  // 表示链表头
	private Node tail;  // 表示链表尾
	private int size;   // 表示链表的节点个数
	
	// 构造方法
	public TwoWayLinkedList() {
		size = 0;
		head = null;
		tail = null;
	}
	
	// 在链表头添加节点
	public void addHead(Object value) {
		Node node = new Node(value);
		if(size == 0) {
			head = node;
			tail = node;
			size ++;
		}else {
			head.pre = node;
			node.next = head;
			head = node;
			size ++;
		}
	}
	
	// 在链表尾添加节点
	public void addTail(Object value) {
		Node node = new Node(value);
		if(size == 0) {
			head = node;
			tail = node;
			size ++;
		}else {
			node.pre = tail;
			tail.next = node;
			tail = node;
			size ++;
		}
	}
	
	// 删除链表头
	public Node deleteHead() {
		Node temp = head;
		if(size != 0) {
			head = head.next;
			head.pre = null;
			size --;
		}
		return temp;
	}
	
	// 删除链表尾
	public Node deleteTail() {
		Node temp = tail;
		if(size != 0) {
			tail = tail.pre;
			tail.next = null;
			size --;
		}
		return temp;
	}
	
	// 获取链表的节点个数
	public int getSize() {
		return size;
	}
	
	// 判断链表是否为空
	public boolean isEmpty() {
		return (size == 0);
	}
	
	// 显示节点信息
	public void display() {
		if(size > 0) {
			Node node = head;
			int tempSize = size;
			if(tempSize == 1) {  // 表示链表只有一个节点
				System.out.println("["+node.data+"]");
				return;
			}
			while(tempSize > 0) {  // 表示链表不只有一个节点，就一直循环，直到遍历完
				if(node.equals(head)) {
					 System.out.print("["+node.data+"->");
				}else if(node.next == null) {
					System.out.print(node.data+"]");
				}else {
					System.out.print(node.data+"->");
				}
				node = node.next;   // 指针继续向下走
				tempSize --;    // 节点个数减1
			}
			System.out.println();
		}else {  // 如果链表一个节点都没有，直接打印[]
			System.out.println("[]");
		}
	}
	
	// 节点基础类
	private class Node{
		private Object data;
		private Node next;
		private Node pre;
		
		public Node(Object data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + ", pre=" + pre + "]";
		}
		
	}

}
