package �㷨ѧϰ.����;

/**
 * �õ�������ʵ��ջ
 * @author lenovo
 *
 */
public class StackSingleLink {

	private SingleLinkedList link;   // ����
	
	public StackSingleLink() {
		link = new SingleLinkedList();
	}
	
	// ���Ԫ��
	public void push(Object obj) {
		link.addHead(obj);
	}
	
	// �Ƴ�ջ��Ԫ��
	public Object pop() {
		return link.deleteHead();
	}
	
	// �ж��Ƿ�Ϊ��
	public boolean isEmpty() {
		return link.isEmpty();
	}
	
	// ��ӡջ��Ԫ����Ϣ
	public void display() {
		link.display();
	}
	
}
