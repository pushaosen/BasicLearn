package �����㷨ˢ��.ջϵ��;

import java.util.Deque;
import java.util.LinkedList;

public class ������ջʵ�ֶ��� {

	/** 
	 * ��Ŀ��������ջʵ�ֶ���
	 * ������ջʵ��һ�����С����е��������£���ʵ��������������appendTail��deleteHead���ֱ����
	 * �ڶ���β�������������ڶ���ͷ��ɾ�������Ĺ��ܡ�(��������û��Ԫ�أ�deleteHead �������� -1)
	 */
	
	/** 
	 * ʾ����
	 *     ���룺
	 */
	
	private static Deque<Integer> stack1 = new LinkedList<Integer>();
	private static Deque<Integer> stack2 = new LinkedList<Integer>();
	
	
	/** 
	 * �ڶ���β������ 
	 */
	public static void appendTail(int value) {
		stack1.push(value);
	}
	
	/** 
	 * ɾ��ͷ����Ԫ��
	 */
	public static int deleteHead() {
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
	
}
