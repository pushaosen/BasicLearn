package 算法学习.排序.递归;

/**
 * 使用递归求一个数的乘方
 * @author lenovo
 *
 */
public class Power {
	
	/**
	 * 求一个数的乘方
	 * @param x   底数
	 * @param y   指数
	 * @return
	 */
	public static int pow(int x, int y) {
		if(x == 0 || x == 1) {
			return x;
		}
		if(y > 1) {
			int b = y / 2;
			int a = x * x;
			if(y % 2 == 1) {  // y为奇数
				return pow(a, b) * x;
			}else {  // y为偶数
				return pow(a, b);
			}
		}else if(y == 0) {
			return 1;
		}else { // y == 1
			return x;
		}
	}

}
