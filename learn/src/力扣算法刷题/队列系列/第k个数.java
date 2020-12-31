package �����㷨ˢ��.����ϵ��;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ��k���� {
	
	/** 
	 * ��Ŀ����Щ����������ֻ�� 3��5��7�������һ���㷨�ҳ��� k ������ע�⣬���Ǳ�������Щ�����ӣ����Ǳ��벻���������������ӡ���
	 *     �磬ǰ��������˳��Ӧ���� 1��3��5��7��9��15��21��
	 */
	
	/** 
	 * ʾ����
	 *     ���룺k = 5
	 *     �����9
	 */
	
	public static void main(String[] args) {
		��k���� obj = new ��k����();
		int k = 5;
		System.out.println("��̬�滮�ⷨ�Ľ��Ϊ��" + obj.getKthMagicNumber(k));
		System.out.println("�ѽⷨ�Ľ��Ϊ��" + obj.getKthMagicNumber1(k));
	}
	
	/** 
	 * �ⷨһ����̬�滮
	 * ����˼·��
	 *       1��1û�������ӣ�1���κ�������(����1����)���ǻ���
	 *       2������1Ϊ��һλ��dp[0]=1;
	 *       3����ʼ������ָ��p3��p5��p7
	 *       4����dp[p3]*3,dp[p5]*5,dp[p7]*7��ѡȡ��С������Ϊ�µ����֣����������ֶ�Ӧ��ָ����ǰ�ƶ�һ��
	 */
	public int getKthMagicNumber(int k) {
		int p3 = 0, p5 = 0, p7 = 0;
		int[] dp = new int[k];
		dp[0] = 1;
		for(int i = 1; i < k; i ++) {
			// ѡ����С������
			dp[i] = Math.min(dp[p3] * 3, Math.min(dp[p5] * 5, dp[p7] * 7));
			// �������ֶ�Ӧ��ָ����ǰ�ƶ�һ��
			if(dp[i] == dp[p3] * 3) {
				p3++;
			}
			if(dp[i] == dp[p5] * 5) {
				p5++;
			}
			if(dp[i] == dp[p7] * 7) {
				p7++;
			}
		}
		return dp[k-1];
	}
	
	/** 
	 * �ⷨ������
	 * ����˼·��
	 *       1����HashSet����k��λ��ֵ
	 *       2��ѭ����ȡHashSet�еĵ�kλ
	 *       3��ѭ���л�ȡ��СλԪ�أ������������HashSet�� д��
	 *       4������HashSet�е�k��λ��ֵ
	 */
	public int getKthMagicNumber1(int k) {
		// ��С�Ѵ���д��ֵ  ����һ��Integer����
		PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
		// HashSet ����k��λ��ֵ
		Set<Long> list = new HashSet<>();
		priorityQueue.add(1L);
		while(true) {
			// ��ȡ��ɾ������Ԫ��
			Long val = priorityQueue.poll();
			// ��Ԫ���Ƿ�����HashSet�У��ڽ����������������
			if(!list.contains(val)) {
				list.add(val);
				priorityQueue.add(val * 3);
				priorityQueue.add(val * 5);
				priorityQueue.add(val * 7);
			}
			// ���ص�k��λ��ֵ
			if(list.size() == k) {
				return val.intValue();
			}
		}
	}
	

}
