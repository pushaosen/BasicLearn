package �����㷨ˢ��.��ϵ��;

import java.util.Stack;

public class ջ����Сֵ {

	/** 
	 * ��Ŀ�������һ��ջ�����˳���ջ֧�ֵ�pop��push�������⣬��֧��min��������
	 *     ��������ջԪ���е���Сֵ��ִ��push��pop��min������ʱ�临�Ӷȱ���ΪO(1)
	 */
	
	/**
	 * �ⷨһ��ʹ�ø�������
	 *      �Լ�����һ��������
	 */
	// ����ͷ���൱��ջ��
	private TreeNode head;
	// ѹջ����Ҫ�ж�ջ�Ƿ�Ϊ��
	public void push(int value) {
		if(empty()) {
			head = new TreeNode(value, value, null);
		}else {
			head = new TreeNode(value, Math.min(value, head.min), head);
		}
	}
	
	// ��ջ���൱�ڰ�����ͷɾ��
	public void pop() {
		if(empty()) {
			throw new IllegalStateException("ջΪ�ա���");
		}
		head = head.next;
	}
	
	// ջ����ֵҲ��������ͷ��ֵ
	public int top() {
		if(empty()) {
			throw new IllegalStateException("ջΪ�ա���");
		}
		return head.val;
	}
	
	// ������ͷ��㱣���������������С��ֵ�����Է���head.minҲ�����൱�ڷ���ջ����Сֵ
	public int getMin() {
		if(empty()) {
			throw new IllegalStateException("ջΪ�ա���");
		}
		return head.min;
	}
	
	private boolean empty() {
		return head == null;
	}
	
	/** 
	 * �ⷨ����ʹ�ø�������
	 *      ʹ�ùٷ��ṩ��ջ
	 */
	private Stack<StackNode> stack = new Stack<>();
	// ѹջ
	public void push1(int value) {
		if(empty1()) {
			stack.push(new StackNode(value, value));
		}else {
			stack.push(new StackNode(value, Math.min(value, getMin1())));
		}
	}
	
	// ��ջ
	public void pop1() {
		if(empty1()) {
			throw new IllegalStateException("ջΪ�ա���");
		}
		stack.pop();
	}
	
	// ��ȡջ��Ԫ��
	public int top1() {
		if(empty1()) {
			throw new IllegalStateException("ջΪ�ա���");
		}
		return stack.peek().val;
	}

	private int getMin1() {
		if(empty1()) {
			throw new IllegalStateException("ջΪ�ա���");
		}
		return stack.peek().min;
	}

	private boolean empty1() {
		return stack.isEmpty();
	}
	
	/** 
	 * �ⷨ����ʹ�õ���ջ
	 */
	private long min;
	private Stack<Long> stack1 = new Stack<>();
	// ѹջ
	public void push2(int value) {
		if(stack1.isEmpty()) {
			stack1.push(0L);
		}else {
			// ������ջ������ջ��ֵ����Сֵ�Ĳ�ֵ���п���Ϊ����Ҳ����Ϊ��
			stack1.push(value - min);
			if(value < min) {
				min = Long.valueOf(value);
			}
		}
	}
	
	// ��ջ
	public void pop2() {
		if(stack1.isEmpty()) {
			return;
		}
		Long pop = stack1.pop();
		// ��Ϊ��ջ���ǲ�ֵ������ջ��Ϊ������ʱ��˵��ջ����Сֵ�Ѿ���ջ��
		// ����Ҫ���¸�����Сֵ
		if(pop < 0) {
			min -= pop;
		}
	}
	
	// ��ȡջ��Ԫ��
	public int top2() {
		Long top = stack1.peek();
		if(top > 0) {
			// ջ��Ԫ����������ģ�˵��ջ��Ԫ��ѹջ��ʱ���Ǳ�ջ����Сֵ��ģ�����
			// top=x - min�����Լ���x=top+min
			return (int)(top + min);
		}else {
			//��ջ��Ԫ���Ǹ�����ʱ��˵��ջ��Ԫ��ѹջ��ʱ���Ǳ�ջ����СֵС�ģ�
			//��ѹջ��֮�����������Сֵmin�����������ʹ�����湫ʽ�϶��ǲ���
			//�ġ����ջ��Ԫ��ѹջ��ʱ�����СֵС�����������Сֵ�������Сֵ
			//��������Ҫѹջ��ֵ����������ֱ�ӷ���min�����ˡ�
			return (int)min;
		}
	}
	
	// ��ȡջ����С��Ԫ��
	public int getMin2() {
		return (int)min;
	}
}


// �ڵ���
class StackNode{
	public int val;
	public int min;
	
	public StackNode(int val, int min) {
		this.val = val;
		this.min = min;
	}
}
