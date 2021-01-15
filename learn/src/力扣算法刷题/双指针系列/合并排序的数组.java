package �����㷨ˢ��.˫ָ��ϵ��;

import java.util.Arrays;

public class �ϲ���������� {
	
	/** 
	 * ��Ŀ�������������������� A �� B������ A ��ĩ�����㹻�Ļ���ռ����� B�� ��дһ��������
	 *     ��B�ϲ���A������
	 *     
	 *     ��ʼ��A��B��Ԫ�ص������ֱ�Ϊm��n��
	 */
	
	/** 
	 * ʾ����
	 *    ���룺A = [1,2,3,0,0,0], m = 3
	 *        B = [2,5,6],       n = 3
	 *    �����[1,2,2,3,5,6]
	 */
	
	/** 
	 * ����
	 */
	public static void main(String[] args) {
		�ϲ���������� obj = new �ϲ����������();
		int[] A = {1,2,3,0,0,0};
		int m = 3;
		int[] B = {2,5,6};
		int n = 3;
		// ֱ�Ӻϲ�������Ľⷨ
		obj.merge(A, m, B, n);
		// ��˫ָ��Ľⷨ
		obj.merge1(A, m, B, n);
		// ����˫ָ��Ľⷨ
		obj.merge2(A, m, B, n);
	}
	
	/** 
	 * �ⷨһ��ֱ�Ӻϲ�������
	 * ʱ�临�Ӷȣ�O((m+n)log(m+n))���������г���Ϊm+n�����ÿ��������ʱ�临�Ӷȼ��ɣ�ƽ�����ΪO((m+n)log(m+n))
	 * �ռ临�Ӷȣ�O(log(m+n))
	 */
	public void merge(int[] A, int m, int[] B, int n) {
		for(int i = 0; i != n; ++ i) {
			A[m + i] = B[i];
		}
		Arrays.sort(A);
		System.out.println("ֱ�Ӻϲ�������Ľ��Ϊ��" + A.toString());
	}
	
	/** 
	 * �ⷨ����˫ָ��
	 * ʱ�临�Ӷȣ�O(m+n)��ָ���ƶ���������������ƶ�m+n�Σ����ʱ�临�Ӷ�ΪO(m+n)
	 * �ռ临�Ӷȣ�O(m+n)����Ҫ��������Ϊm+n���м�����sorted
	 */
	public void merge1(int[] A, int m, int[] B, int n) {
		int pa = 0, pb = 0;
		int[] sorted = new int[m+n];
		int cur;
		while(pa < m || pb < n) {
			if(pa == m) {
				cur = B[pb++];
			}else if(pb == n) {
				cur = A[pa++];
			}else if(A[pa] < B[pb]) {
				cur = A[pa++];
			}else {
				cur = B[pb++];
			}
			sorted[pa + pb - 1] = cur;
		}
		for(int i = 0; i != m + n; ++ i) {
			A[i] = sorted[i];
		}
		System.out.println("˫ָ��Ľⷨ���Ϊ��" + A.toString());
	}
	
	/** 
	 * �ⷨ��������˫ָ��
	 * ʱ�临�Ӷȣ�O(m+n)��ָ���ƶ������ݼ�������ƶ�m+n�Σ����ʱ�临�Ӷ�ΪO(m+n)
	 * �ռ临�Ӷȣ�O(1)��ֱ�Ӷ�����Aԭ���޸ģ�����Ҫ����ռ�
	 */
	public void merge2(int[] A, int m, int[] B, int n) {
		int pa = m - 1, pb = n - 1;
        int tail = m + n - 1;
        int cur;
        while (pa >= 0 || pb >= 0) {
            if (pa == -1) {
                cur = B[pb--];
            } else if (pb == -1) {
                cur = A[pa--];
            } else if (A[pa] > B[pb]) {
                cur = A[pa--];
            } else {
                cur = B[pb--];
            }
            A[tail--] = cur;
        }
		System.out.println("����˫ָ��Ľⷨ�Ľ��Ϊ��" + A.toString());
	}
}
