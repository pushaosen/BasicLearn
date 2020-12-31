package �����㷨ˢ��.����ϵ��;

import java.util.LinkedList;
import java.util.Queue;

public class ������������ {
	
	/** 
	 * ��Ŀ��дһ�� RecentCounter ���������ض�ʱ�䷶Χ�����������
	 * ����ʵ��һ���ࣺ
	 *     RecentCounter() ��ʼ����������������Ϊ 0 ��
	 *     int ping(int t) ��ʱ�� t ���һ������������ t ��ʾ�Ժ���Ϊ��λ��ĳ��ʱ�䣬�����ع�ȥ 3000 �����ڷ�������
	 *     �������������������󣩡�ȷ�е�˵�������� [t-3000, t] �ڷ�������������
	 *     
	 * ��֤��ÿ�ζ� ping �ĵ��ö�ʹ�ñ�֮ǰ����� t��
	 */
	
	/** 
	 * ʾ����
	 *     ���룺["RecentCounter", "ping", "ping", "ping", "ping"]
	 *         [[], [1], [100], [3001], [3002]]
	 *     �����[null, 1, 2, 3, 3]
	 */
	
	/** 
	 * ����
	 */
	public static void main(String[] args) {
		
	}
	
	/** 
	 * �ⷨһ��ʹ�ö���
	 * ʱ�临�Ӷȣ�O(Q)������Q��ping�Ĵ���
	 * �ռ临�Ӷȣ�O(W)������W=3000�Ƕ��������洢�� ping �ļ�¼��Ŀ��
	 */
	private Queue<Integer> queue = new LinkedList<>();
	public int ping(int t) {
		queue.add(t);
		while(queue.peek() < t - 3000) {
			queue.poll();
		}
		return queue.size();
	}

}
