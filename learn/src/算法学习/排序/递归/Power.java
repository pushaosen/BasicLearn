package �㷨ѧϰ.����.�ݹ�;

/**
 * ʹ�õݹ���һ�����ĳ˷�
 * @author lenovo
 *
 */
public class Power {
	
	/**
	 * ��һ�����ĳ˷�
	 * @param x   ����
	 * @param y   ָ��
	 * @return
	 */
	public static int pow(int x, int y) {
		if(x == 0 || x == 1) {
			return x;
		}
		if(y > 1) {
			int b = y / 2;
			int a = x * x;
			if(y % 2 == 1) {  // yΪ����
				return pow(a, b) * x;
			}else {  // yΪż��
				return pow(a, b);
			}
		}else if(y == 0) {
			return 1;
		}else { // y == 1
			return x;
		}
	}

}
