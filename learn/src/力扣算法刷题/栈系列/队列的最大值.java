package �����㷨ˢ��.ջϵ��;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ���е����ֵ {

	/** 
	 * ��Ŀ���붨��һ�����в�ʵ�ֺ��� max_value �õ�����������ֵ��Ҫ����
	 *     max_value��push_back �� pop_front �ľ�̯ʱ�临�Ӷȶ���O(1)��
	 *     
	 *     ������Ϊ�գ�pop_front��max_value ��Ҫ���� -1
	 */
	
	public static void main(String[] args) {
		���е����ֵ obj = new ���е����ֵ();
		obj.q = new int[]{1,2,3,4,5,6};
		System.out.println("���е����ֵΪ��" + obj.max_value());
		System.out.println("������˫�˶��е����ֵΪ��" + obj.max_value1());
	}
	
	/** 
	 * �ⷨһ�������ⷨ
	 * ʱ�临�Ӷȣ�O(1)
	 * �ռ临�Ӷȣ�O(n)
	 */
	int[] q = new int[20000];
	int begin = 0, end = 0;
	
	public int max_value() {
		int ans = -1;
		for(int i = begin; i < q.length; i ++) {
			ans = Math.max(ans, q[i]);
		}
		return ans;
	}
	
	public void push_back(int value) {
		q[end ++] = value;
	}
	
	public int pop_front() {
		if(begin == end) {
			return -1;
		}
		return q[begin++];
	}
	
	/** 
	 * �ⷨ����ά��һ��������˫�˶���
	 * ʱ�临�Ӷȣ�O(1)
	 * �ռ临�Ӷȣ�O(1)
	 */
	Queue<Integer> q1 = new LinkedList<Integer>();
	Deque<Integer> d1 = new LinkedList<Integer>(); 
	
	public int max_value1() {
		if(d1.isEmpty()) {
			return -1;
		}
		return d1.peekFirst();
	}
	
	public void push_back1(int value) {
		while(!d1.isEmpty() && d1.peekLast() < value) {
			d1.pollLast();
		}
		d1.offerLast(value);
		q1.offer(value);
	}
	
	public int pop_front1() {
		if(q1.isEmpty()) {
			return -1;
		}
		int ans = q1.poll();
		if(ans == d1.peekFirst()) {
			d1.pollFirst();
		}
		return ans;
	}
}
