package �����㷨ˢ��.��ϵ��;

import java.util.Deque;
import java.util.LinkedList;

public class ������ջʵ�ֶ��� {

	/* 
	 * ��Ŀ�� ������ջʵ��һ�����С����е��������£���ʵ�������������� appendTail �� deleteHead ���ֱ�
	 *     ����ڶ���β�������������ڶ���ͷ��ɾ�������Ĺ��ܡ�(��������û��Ԫ�أ�deleteHead �������� -1 )
	 */
	
	/** 
	 * ʾ����
	 *     ���룺["CQueue","appendTail","deleteHead","deleteHead"]
	 *         [[],[3],[],[]]
	 *     �����[null,null,3,-1]
	 */
	
	/** 
	 * �ⷨһ��ʹ��˫ջ
	 * ʱ�临�Ӷȣ�O(1)
	 * �ռ临�Ӷȣ�O(n)
	 */
	Deque<Integer> stack1 = new LinkedList<Integer>();
	Deque<Integer> stack2 = new LinkedList<Integer>();
	public void appendTail(int value) {
		stack1.push(value);
	}
	public int deleteHead() {
		// ����ڶ���ջΪ��
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if(stack2.isEmpty()) {
			return -1;
		}else {
			int deleteItem = stack2.pop();
			return deleteItem;
		}
	}
	
	/** 
	 * �ⷨ����ʹ��˫ջ
	 */
	LinkedList<Integer> A = new LinkedList<Integer>();
	LinkedList<Integer> B = new LinkedList<Integer>();
	public void appendTail1(int value) {
		A.addLast(value);
	}
	public int deleteHead1() {
		if(!B.isEmpty()) {
			return B.removeLast();
		}
		if(A.isEmpty()) {
			return -1;
		}
        while(!A.isEmpty()) {
        	B.addLast(A.removeLast());
        }
        return B.removeLast();
	}
	
}
