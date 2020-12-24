package �����㷨ˢ��.��ϵ��;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ���е����ֵ {
	
	/** 
	 * ��Ŀ���붨��һ�����в�ʵ�ֺ��� max_value �õ�����������ֵ��Ҫ����
	 *     max_value��push_back �� pop_front �ľ�̯ʱ�临�Ӷȶ���O(1)��
	 *     
	 *     ������Ϊ�գ�pop_front �� max_value ��Ҫ���� -1
	 */
	
	/** 
	 * ʾ����
	 *     ���룺["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
	 *         [[],[1],[2],[],[],[]]
	 *     �����[null,null,null,2,1,2]
	 */
	
	/** 
	 * �ⷨһ�������ⷨ
	 * ʱ�临�Ӷȣ�O(1)��������Ϊ��O(n)
	 * �ռ临�Ӷȣ�O(n)����Ҫ�ö��д洢���в����Ԫ�ء�
	 */
	int[] q = new int[20000];
	int begin = 0, end = 0;
	public int max_value() {
		int ans = -1;
		for(int i = begin; i != end; ++ i) {
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
		return q[begin ++];
	}
	
	/** 
	 * �ⷨ����ά��һ��������˫�˶���
	 * ʱ�临�Ӷȣ�O(1)
	 * �ռ临�Ӷȣ�O(n)����Ҫ�ö��д洢���в����Ԫ��
	 */
	Queue<Integer> q1 = new LinkedList<Integer>();
	Deque<Integer> d = new LinkedList<Integer>();
	public int max_value1() {
		if(d.isEmpty()) {
			return -1;
		}
		return d.peekFirst();
	}
	public void push_back1(int value) {
		while(!d.isEmpty() && d.peekLast() < value) {
			d.pollLast();
		}
		d.offerLast(value);
		q1.offer(value);
	}
	public int pop_front1() {
		if(q1.isEmpty()) {
			return -1;
		}
		int ans = q1.poll();
		if(ans == d.peekFirst()) {
			d.pollFirst();
		}
		return ans;
	}
}
