package �����㷨ˢ��.�ݹ�ϵ��;

public class �ݹ�˷� {
	
	/** 
	 * ��Ŀ���ݹ�˷��� дһ���ݹ麯������ʹ�� * ������� ʵ����������������ˡ�����ʹ�üӺš����š�λ�ƣ���Ҫ����һЩ��
	 * 
	 * ��ʾ����֤�˷��������
	 */
	
	/** 
	 * ʾ����
	 *    ���룺A = 1, B = 10
	 *    �����10
	 *    
	 *    ���룺A = 3, B = 4
	 *    �����12
	 */
	
	/** 
	 * ���ԣ�
	 */
	public static void main(String[] args) {
		�ݹ�˷� obj = new �ݹ�˷�();
		int A = 1, B = 10;
		System.out.println("�ⷨһ�Ľ��Ϊ��" + obj.multiply(A, B));
		A = 3; B= 4;
		System.out.println("�ⷨһ�Ľ��Ϊ��" + obj.multiply(A, B));
	}
	
	/**
	 * �ⷨһ��
	 * ʱ�临�Ӷȣ�O(logn)��n���ᳬ��65536��
	 * �ռ临�Ӷȣ�O(1)
	 */
	public int multiply(int A, int B) {
		int min = Math.min(A, B);
		int max = Math.max(A, B);
		int ans = 0;
		
		for(int i = 0; min != 0; i ++) {
			if((min & 1) == 1) {
				ans += max << i;
			}  
			min >>= 1;
		}
		
		return ans;
	}

}
