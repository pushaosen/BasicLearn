package 力扣算法刷题.递归系列;

public class 第K个语法符号 {
	
	/** 
	 * 题目：在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
	 * 
	 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
	 */
	
	/** 
	 * 示例：
	 *    输入：N = 1, K = 1
	 *    输出：0
	 *    
	 *    输入：N = 2, K = 2
	 *    输出：1
	 *    
	 *    输入：N = 4, K = 5
	 *    输出：1
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		第K个语法符号 obj = new 第K个语法符号();
		int N = 1, K = 1;
		System.out.println("解法四的结果为：" + obj.kthGrammar3(N, K));
		N = 2; K = 2;
		System.out.println("解法四的结果为：" + obj.kthGrammar3(N, K));
	}
	
	/** 
	 * 解法一：暴力法
	 * 思路和算法：生成每一行字符串，每次只需要保存最后一行就可以了。但不幸的是，字符串的长度可能超过10亿，
	 *         因为字符串的长度是每行翻倍的，所以这个方法不是很高效
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
	 * 解法二：递归(父子递推)
	 * 时间复杂度：O(N)
	 * 空间复杂度：O(1)
	 */
	public int kthGrammar1(int N, int K) {
		if(N == 1) {
			return 0;
		}
		return (~K&1) ^ kthGrammar1(N-1, (K+1)/2);
	}
	
	/** 
	 * 解法三：递归(翻转递推)
	 * 时间复杂度：O(N)
	 * 空间复杂度：O(1)
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
	 * 解法四：Binary Count
	 * 时间复杂度：O(logN)，其中N的二进制字符串表示形式的长度
	 * 空间复杂度：O(1)
	 */
	public int kthGrammar3(int N, int K) {
		return Integer.bitCount(K - 1) % 2;
	}

}
