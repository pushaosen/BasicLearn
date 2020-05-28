package �㷨ѧϰ.����;

/**
 * ˫������
 * @author lenovo
 *
 */
public class TwoWayLinkedList {
	
	private Node head;  // ��ʾ����ͷ
	private Node tail;  // ��ʾ����β
	private int size;   // ��ʾ����Ľڵ����
	
	// ���췽��
	public TwoWayLinkedList() {
		size = 0;
		head = null;
		tail = null;
	}
	
	// ������ͷ��ӽڵ�
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
	
	// ������β��ӽڵ�
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
	
	// ɾ������ͷ
	public Node deleteHead() {
		Node temp = head;
		if(size != 0) {
			head = head.next;
			head.pre = null;
			size --;
		}
		return temp;
	}
	
	// ɾ������β
	public Node deleteTail() {
		Node temp = tail;
		if(size != 0) {
			tail = tail.pre;
			tail.next = null;
			size --;
		}
		return temp;
	}
	
	// ��ȡ����Ľڵ����
	public int getSize() {
		return size;
	}
	
	// �ж������Ƿ�Ϊ��
	public boolean isEmpty() {
		return (size == 0);
	}
	
	// ��ʾ�ڵ���Ϣ
	public void display() {
		if(size > 0) {
			Node node = head;
			int tempSize = size;
			if(tempSize == 1) {  // ��ʾ����ֻ��һ���ڵ�
				System.out.println("["+node.data+"]");
				return;
			}
			while(tempSize > 0) {  // ��ʾ����ֻ��һ���ڵ㣬��һֱѭ����ֱ��������
				if(node.equals(head)) {
					 System.out.print("["+node.data+"->");
				}else if(node.next == null) {
					System.out.print(node.data+"]");
				}else {
					System.out.print(node.data+"->");
				}
				node = node.next;   // ָ�����������
				tempSize --;    // �ڵ������1
			}
			System.out.println();
		}else {  // �������һ���ڵ㶼û�У�ֱ�Ӵ�ӡ[]
			System.out.println("[]");
		}
	}
	
	// �ڵ������
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
