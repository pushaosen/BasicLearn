package 算法学习.链表;

/**
 * 有序链表：在有序链表中插入和删除某一项最多需要O(N)次比较，平均需要O(N/2)次
 * @author lenovo
 *
 */
public class OrderLinkedList {

	private Node head;
	
	public OrderLinkedList() {
		this.head = null;
	}
	
	// 插入节点，并按照从小到大的顺序排列
	public void insert(int value) {
		Node node = new Node(value);
		Node pre = null;
		Node current = head;
		while(current != null && value > current.data) {
			pre = current;
			current = current.next;
		}
		
		if(pre == null) {
			head = node;
			head.next = current;
		}else {
			pre.next = node;
			node.next = current;
		}
	}
	
	// 删除节点
	public void deleteHead() {
		head = head.next;
	}
	
	// 打印所有节点的信息
	public void display() {
		Node current = head;
		while(current != null) {
			System.out.print(current.data+" ");
			current = current.next;
		}
		System.out.println();
	}
	
	// 节点基础类
	private class Node{
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
}
