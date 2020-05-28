package �㷨ѧϰ.ջ;

/**
 * ������ʵ�ֵ�ջ
 * @author lenovo
 *
 */
public class MyStack {
	
	private int[] array;
	private int maxSize;
	private int top;
	
	// ���췽��
	public MyStack(int size) {
		this.maxSize = size;
		array = new int[size];
		top = -1;
	}
	
	// ѹ������
	public void push(int value) {
		if(top < maxSize - 1) {
			array[++ top] = value;
		}
	}
	
	// ����ջ������
	public int pop() {
		return array[top --];
	}
	
	// ����ջ������
	public int peek() {
		return array[top];
	}
	
	// �ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return (top == -1);
	}

	// �ж�ջ�Ƿ�����
	public boolean isFull() {
		return (top == maxSize - 1);
	}
	
	// ����
	public static void main(String[] args) {
		MyStack stack = new MyStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
	}
}
