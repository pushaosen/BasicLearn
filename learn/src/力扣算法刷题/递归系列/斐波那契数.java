package �����㷨ˢ��.�ݹ�ϵ��;

public class 쳲������� {
	
	/**
	 * ��Ŀ��쳲���������ͨ����F(n)��ʾ���γɵ����г�Ϊ 쳲��������С��������� 0 �� 1 ��ʼ�������ÿһ�����ֶ���ǰ���������ֵĺ͡�Ҳ���ǣ�
	 * 
	 *     F(0) = 0��F(1) = 1
	 *     F(n) = F(n-1) + F(n-2)������ n > 1
	 */
	
	/**
	 * ʾ����
	 *    ���룺3
	 *    �����2
	 *    ���ͣ�F(3) = F(2) + F(1) = 1 + 1 = 2
	 */
	
	public static void main(String[] args) {
		쳲������� obj = new 쳲�������();
		int n = 3;
		System.out.println("쳲���������̬�滮�ⷨ���Ϊ��" + obj.fib(n));
		System.out.println("ͨ�ʽ�Ľⷨ�Ľ��Ϊ��" + obj.fib1(n));
	}
	
	/** 
	 * �ⷨһ����̬�滮
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 */
	public int fib(int n) {
		if(n < 2) {
			return n;
		}
		int p = 0, q = 0, r = 1;
		for(int i = 2; i <= n; ++ i) {
			p = q;
			q = r;
			r = p + q;
		}
		return r;
	}
	
	/** 
	 * �ⷨ����ͨ�ʽ
	 * F(n) = F(n-1) + F(n-2)��    �����Ƴ���x*x = x + 1
	 */
	public int fib1(int n) {
		double sqrt5 = Math.sqrt(5);
		double fibN = Math.pow((1+sqrt5)/2, n) - Math.pow((1 - sqrt5)/2, n);
		return (int)Math.round(fibN/sqrt5);
	}

}
