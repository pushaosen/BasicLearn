package �㷨ѧϰ.����;

/**
 * ˫�˶��е�ʵ��
 * @author lenovo
 *
 */
public class DoublePointLinkedList {

	private Node head; // ͷ�ڵ�
	private Node tail; // β�ڵ�
	private int size;  // �ڵ���
	
	public DoublePointLinkedList() {
		size = 0;
		head = null;
		tail = null;
	}
	
	// ����ͷ�����ڵ�
	public void addHead(Object data) {
		Node node = new Node(data);
		if(size == 0) {  // �������Ϊ�գ���ôͷ�ڵ��β�ڵ㶼�Ǹ������ڵ�
			head = node;
			tail = node;
			size ++;
		}else {
			node.next = head;
			head = node;
			size ++;
		}
	}

	// ����β�����ڵ�
	public void addTail(Object data) {
		Node node = new Node(data);
		if(size == 0) {
			head = node;
			tail = node;
			size ++;
		}else {
			tail.next = node;
			tail = node;
			size ++;
		}
	}
	
	// ɾ��ͷ���ڵ㣬�ɹ�����true��ʧ�ܷ���false
	public boolean deleteHead() {
		if(size == 0) {  // ��ǰ����ڵ���Ϊ0
			return false;
		}
		if(head.next == null) {  // ��ǰ����ڵ���Ϊ1
			head = null;
			tail = null;
		}else {
			head = head.next;
		}
		size --;
		return true;
	}
	
	// �ж��Ƿ�Ϊ��
	public boolean isEmpty() {
		return (size == 0);
	}
	
	// �������Ľڵ����
	public int getSize() {
		return size;
	}
	
	// ��ʾ�ڵ���Ϣ
	public void display() {
		if(size > 0) {
			Node node = head;
			int tempSize = size;
			if(tempSize == 1) { // ��ǰ����ֻ��һ���ڵ�
				System.out.println("["+node.data+"]");
				return;
			}
			while(tempSize > 0) {
				if(node.equals(head)){
					System.out.print("["+node.data+"->");
				}else if(node.next == null){
					System.out.print(node.data+"]");
				}else {
					System.out.print(node.data+"->");
				}
				node = node.next;
				tempSize --;
			}
			System.out.println();
		}else {  // �������һ���ڵ㶼û�У�ֱ�Ӵ�ӡ[]
			System.out.println("[]");
		}
	}
	
	// �����ڵ�
	private class Node{
		
		private Object data;
		private Node next;
		
		public Node(Object data) {
			this.data = data;
		}
	}
}
