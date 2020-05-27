package 算法学习.链表;

/**
 * 用单向链表实现栈
 * @author lenovo
 *
 */
public class StackSingleLink {

	private SingleLinkedList link;   // 链表
	
	public StackSingleLink() {
		link = new SingleLinkedList();
	}
	
	// 添加元素
	public void push(Object obj) {
		link.addHead(obj);
	}
	
	// 移除栈顶元素
	public Object pop() {
		return link.deleteHead();
	}
	
	// 判断是否为空
	public boolean isEmpty() {
		return link.isEmpty();
	}
	
	// 打印栈内元素信息
	public void display() {
		link.display();
	}
	
}
