package 算法学习.栈;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 增强功能版栈
 * @author lenovo
 *
 */
public class ArrayStack {
	
	// 存储元素的数组，申明为Object类型能存储任意类型的数据
	private Object[] elementData;
	// 指向栈顶的指针
	private int top;
	// 栈的总容量
	private int size;
	
	// 默认构造一个容量为10的栈
	public ArrayStack() {
		this.elementData = new Object[10];
		this.top = -1;
		this.size = 10;
	}
	
	// 自定义容量的构造方法
	public ArrayStack(int initialCapacity) {
		if(initialCapacity < 0) {
			throw new IllegalAccessError("初始栈的容量不能小于0：" + initialCapacity);
		}
		this.elementData = new Object[initialCapacity];
		this.top = -1;
		this.size = initialCapacity;
	}
	
	// 压入元素
	public Object push(Object item) {
		// 是否需要扩容
		isGrow(top + 1);
		elementData[++ top] = item;
		return item;
	}
	
	// 弹出栈顶元素
	public Object pop() {
		Object obj = peek();
		remove(top);
		return obj;
	}
	
	// 获取栈顶元素
	public Object peek() {
		if(top == -1) {
			throw new EmptyStackException();
		}
		return elementData[0];
	}
	
	// 判断是否为空
	public boolean isEmpty() {
		return (top == -1);
	}
	
	// 删除栈顶元素
	public void remove(int top) {
		// 栈顶元素置为null
		elementData[top] = null;
		this.top --;
	}

	// 是否需要扩容，如果需要，则扩大一倍并返回true，不需要则返回false
	public boolean isGrow(int minCapacity) {
		int old = size;
		// 如果当前元素压入栈之后总容量大于前面定义的容量，则需要扩容
		if(minCapacity >= old) {
			// 定义扩大后栈的总容量
			int newCapacity = 0;
			// 栈容量扩大两倍(左移一位)看是否超过int类型所表示的最大范围
			if((old << 1) - Integer.MAX_VALUE > 0) {
				newCapacity = Integer.MAX_VALUE;
			}else {
				newCapacity = (old << 1);  // 左移一位，相当于*2
			}
			this.size = newCapacity;
			elementData = Arrays.copyOf(elementData, size);
			return true;
		}
		return false;
	}
	
	// 测试
	public static void main(String[] args) {
		
	}
}
