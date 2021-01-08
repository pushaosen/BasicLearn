package �����㷨ˢ��.�ݹ�ϵ��;

public class ��ֵ�������η� {
	
	/** 
	 * ��Ŀ��ʵ�ֺ���double Power(double base, int exponent)����base��exponent�η�������ʹ�ÿ⺯����ͬʱ����Ҫ���Ǵ������⡣
	 */
	
	/** 
	 * ʾ����
	 *     ���룺2.00000, 10
	 *     �����1024.00000
	 *     
	 *     ���룺2.10000, 3
	 *     �����9.26100
	 */
	
	/** 
	 * �ⷨһ�������ݷ�
	 */
	public double myPow(double x, int n) {
		if(x == 0) {
			return 0;
		}
		long b = n;
		double res = 1.0;
		if(b<0) {
			x = 1/x;
			b = -b;
		}
		while(b > 0) {
			if((b & 1) == 1) {
				res *= x;
			} 
			x *= x;
			b >>= 1;
		}
		return res;
	}

}
