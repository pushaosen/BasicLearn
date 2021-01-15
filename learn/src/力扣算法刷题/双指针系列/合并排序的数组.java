package 力扣算法刷题.双指针系列;

import java.util.Arrays;

public class 合并排序的数组 {
	
	/** 
	 * 题目：给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，
	 *     将B合并给A并排序。
	 *     
	 *     初始化A和B的元素的数量分别为m和n。
	 */
	
	/** 
	 * 示例：
	 *    输入：A = [1,2,3,0,0,0], m = 3
	 *        B = [2,5,6],       n = 3
	 *    输出：[1,2,2,3,5,6]
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		合并排序的数组 obj = new 合并排序的数组();
		int[] A = {1,2,3,0,0,0};
		int m = 3;
		int[] B = {2,5,6};
		int n = 3;
		// 直接合并后排序的解法
		obj.merge(A, m, B, n);
		// 升双指针的解法
		obj.merge1(A, m, B, n);
		// 逆向双指针的解法
		obj.merge2(A, m, B, n);
	}
	
	/** 
	 * 解法一：直接合并后排序
	 * 时间复杂度：O((m+n)log(m+n))，排序序列长度为m+n，套用快速排序的时间复杂度即可，平均情况为O((m+n)log(m+n))
	 * 空间复杂度：O(log(m+n))
	 */
	public void merge(int[] A, int m, int[] B, int n) {
		for(int i = 0; i != n; ++ i) {
			A[m + i] = B[i];
		}
		Arrays.sort(A);
		System.out.println("直接合并后排序的结果为：" + A.toString());
	}
	
	/** 
	 * 解法二：双指针
	 * 时间复杂度：O(m+n)，指针移动单调递增，最多移动m+n次，因此时间复杂度为O(m+n)
	 * 空间复杂度：O(m+n)，需要建立长度为m+n的中间数组sorted
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
		System.out.println("双指针的解法结果为：" + A.toString());
	}
	
	/** 
	 * 解法三：逆向双指针
	 * 时间复杂度：O(m+n)，指针移动单调递减，最多移动m+n次，因此时间复杂度为O(m+n)
	 * 空间复杂度：O(1)，直接对数组A原地修改，不需要额外空间
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
		System.out.println("逆向双指针的解法的结果为：" + A.toString());
	}
}
