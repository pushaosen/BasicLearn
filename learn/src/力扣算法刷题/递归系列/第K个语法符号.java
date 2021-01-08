package �����㷨ˢ��.�ݹ�ϵ��;

public class ��K���﷨���� {
	
	/** 
	 * ��Ŀ���ڵ�һ������д��һ�� 0����������ÿһ�У���ǰһ���е�0�滻Ϊ01��1�滻Ϊ10��
	 * 
	 * �������� N ������ K�����ص� N ���е� K���ַ�����K��1��ʼ��
	 */
	
	/** 
	 * ʾ����
	 *    ���룺N = 1, K = 1
	 *    �����0
	 *    
	 *    ���룺N = 2, K = 2
	 *    �����1
	 *    
	 *    ���룺N = 4, K = 5
	 *    �����1
	 */
	
	/** 
	 * ����
	 */
	public static void main(String[] args) {
		��K���﷨���� obj = new ��K���﷨����();
		int N = 1, K = 1;
		System.out.println("�ⷨ�ĵĽ��Ϊ��" + obj.kthGrammar3(N, K));
		N = 2; K = 2;
		System.out.println("�ⷨ�ĵĽ��Ϊ��" + obj.kthGrammar3(N, K));
	}
	
	/** 
	 * �ⷨһ��������
	 * ˼·���㷨������ÿһ���ַ�����ÿ��ֻ��Ҫ�������һ�оͿ����ˡ������ҵ��ǣ��ַ����ĳ��ȿ��ܳ���10�ڣ�
	 *         ��Ϊ�ַ����ĳ�����ÿ�з����ģ���������������Ǻܸ�Ч
	 */
	public int kthGrammar(int N, int K) {
		int[] lastrow = new int[1<<N];
		for(int i = 1; i < N; i ++) {
			for(int j = (1<< (i-1))-1; j >= 0; --j) {
				lastrow[2*j] = lastrow[j];
				lastrow[2*j+1] = 1 - lastrow[j];
			}
		}
		return lastrow[K-1];
	}
	
	/** 
	 * �ⷨ�����ݹ�(���ӵ���)
	 * ʱ�临�Ӷȣ�O(N)
	 * �ռ临�Ӷȣ�O(1)
	 */
	public int kthGrammar1(int N, int K) {
		if(N == 1) {
			return 0;
		}
		return (~K&1) ^ kthGrammar1(N-1, (K+1)/2);
	}
	
	/** 
	 * �ⷨ�����ݹ�(��ת����)
	 * ʱ�临�Ӷȣ�O(N)
	 * �ռ临�Ӷȣ�O(1)
	 */
	public int kthGrammar2(int N, int K) {
		if(N == 1) {
			return 0;
		}
		if(K <= 1 << N - 2) {
			return kthGrammar2(N-1, K);
		}
		return kthGrammar2(N-1, K-(1 << N-2)) ^ 1;
	}
	
	/** 
	 * �ⷨ�ģ�Binary Count
	 * ʱ�临�Ӷȣ�O(logN)������N�Ķ������ַ�����ʾ��ʽ�ĳ���
	 * �ռ临�Ӷȣ�O(1)
	 */
	public int kthGrammar3(int N, int K) {
		return Integer.bitCount(K - 1) % 2;
	}

}
