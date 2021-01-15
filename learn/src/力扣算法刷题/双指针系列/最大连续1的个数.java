package 力扣算法刷题.双指针系列;

public class 最大连续1的个数 {
	
	/** 
	 * 题目：
	 *    给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
	 *    返回仅包含 1 的最长（连续）子数组的长度。
	 */
	
	/** 
	 * 示例：
	 *    输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
	 *    输出：6
	 *    解释：[1,1,1,0,0,1,1,1,1,1,1]
	 *        粗体数字从 0 翻转到 1，最长的子数组长度为 6。
	 *        
	 *    输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
	 *    输出：10
	 *    解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
	 *        粗体数字从 0 翻转到 1，最长的子数组长度为 10。
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		最大连续1的个数 obj = new 最大连续1的个数();
		int[] A = {1,1,1,0,0,0,1,1,1,1,0};
		int k = 2;
		System.out.println("滑动窗口+双指针的解法的结果为：" + obj.longestOnes(A, k));
		int[] B = {0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1};
		int k1 = 3;
		System.out.println("滑动窗口+双指针的解法的结果为：" + obj.longestOnes(B, k1));
	}
	
	/** 
	 * 解法一：滑动窗口+双指针
	 */
	public int longestOnes(int[] A, int k) {
		int count = 0;   // 统计0的个数
		int left = 0; // 滑动窗口区间左端点
		int right = 0;   // 滑动窗口区间右端点
		int res = 0;   // 最终结果
		// 滑动窗口表示的区间为[left,right)，左闭右开
		while(right < A.length) {
			if(A[right++] == 0) {    // 窗口扩充一个元素，如果为0则count++；
				count ++;
			}
			while(count > k) {   // 当窗口内0的个数超过k的时候，开始收缩窗口
				if(A[left++] == 0) {
					count --;
				}
			}
			// 此时count<=k，保存窗口的最大宽度
			res = Math.max(res, right - left);
		}
		return res;
	}
	
	/** 
	 * 解法二：解法一的优化
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * 解题思路：使用双指针left和right指代窗口的左右边界，移动right指针遍历整个数组，同时维护一个变量max，每次right移动计算一次当前的最大值。
	 * 分析：
	 *    分为以下几种情况：
	 *         1、当A[right] = 1时，left不变，right继续移动
	 *         2、当A[right] = 0时，
	 *               (1)、0的数量在K的范围内，left不变，right继续移动
	 *               (2)、0的数量 > K，
	 *                     1、当A[left] == 0时，即left指向了一个零，只需要left右移一格，就可以减少一个零
	 *                     2、当A[left] == 1时，即此时窗口内包含了K个零，需要先移动至下个零，再右移一格才能减少一个零
	 */
	public int longestOnes2(int[] A, int K) {
	    int max = 0;
	    for (int left = 0, right = 0; right < A.length; right++) {
	        if (A[right] == 0) {
	            if (K == 0) {
	                while (A[left] == 1) {
	                    left++;
	                }
	                left++;
	            } else {
	                K--;
	            }
	        }
	        max = right - left + 1 > max ? right - left + 1 : max;
	    }
	    return max;
	}

}
