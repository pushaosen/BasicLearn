package 算法学习.图;

/**
 * 自定义栈
 * @author lenovo
 *
 */
public class StackX {

	private final int SIZE = 20;
	private int[] st;
	private int top;
	
	// 默认构造函数
	public StackX() {
		st = new int[SIZE];
		top = -1;
	}
	
	// 入栈
	public void push(int j) {
		st[++top] = j;
	}
	
	// 出栈
	public int pop() {
		if(top == 0) {
			return -1;
		}
		return st[--top];
	}
	
	// 出栈：但是不删除
	public int peek() {
		return st[top];
	}
	
	// 判断栈是否为空
	public boolean isEmpty() {
		return (top == -1);
	}
}
