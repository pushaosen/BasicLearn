package �㷨ѧϰ.ͼ;

/**
 * �Զ���ջ
 * @author lenovo
 *
 */
public class StackX {

	private final int SIZE = 20;
	private int[] st;
	private int top;
	
	// Ĭ�Ϲ��캯��
	public StackX() {
		st = new int[SIZE];
		top = -1;
	}
	
	// ��ջ
	public void push(int j) {
		st[++top] = j;
	}
	
	// ��ջ
	public int pop() {
		if(top == 0) {
			return -1;
		}
		return st[--top];
	}
	
	// ��ջ�����ǲ�ɾ��
	public int peek() {
		return st[top];
	}
	
	// �ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return (top == -1);
	}
}
