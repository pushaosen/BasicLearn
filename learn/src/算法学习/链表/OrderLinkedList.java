package �㷨ѧϰ.����;

/**
 * �������������������в����ɾ��ĳһ�������ҪO(N)�αȽϣ�ƽ����ҪO(N/2)��
 * @author lenovo
 *
 */
public class OrderLinkedList {

	private Node head;
	
	public OrderLinkedList() {
		this.head = null;
	}
	
	// ����ڵ㣬�����մ�С�����˳������
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
	
	// ɾ���ڵ�
	public void deleteHead() {
		head = head.next;
	}
	
	// ��ӡ���нڵ����Ϣ
	public void display() {
		Node current = head;
		while(current != null) {
			System.out.print(current.data+" ");
			current = current.next;
		}
		System.out.println();
	}
	
	// �ڵ������
	private class Node{
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
}
