package 力扣算法刷题.双指针系列;

import java.util.Arrays;

public class 合并两个有序数组 {
	
	/** 
	 * 题目：给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1称成为一个有序数组
	 * 
	 *     初始化nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 有足够的空间（空间大小等于 m + n）来保存 nums2 中的元素
	 */
	
	/** 
	 * 示例：
	 *    输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
	 *    输出：[1,2,2,3,5,6]
	 *    
	 *    输入：nums1 = [1], m = 1, nums2 = [], n = 0
	 *    输出：[1]
	 */
	
	/** 
	 * 解法一：合并后排序
	 * 解题思路：
	 *       最朴素的解法就是将两个数组合并之后再排序。该算法只需要一行(Java是2行)，时间复杂度较差，为O((n+m)log(n+m))。这是由于这种方法没有利用两个数组本身已经有序这一点。
	 *       
	 * 时间复杂度：O((n+m)log(n+m))
	 * 空间复杂度：O(1)
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		System.arraycopy(nums2, 0, nums1, m, n);
		Arrays.sort(nums1);
	}
	
	/** 
	 * 解法二：双指针 / 从前往后
	 * 时间复杂度：O(n+m)
	 * 空间复杂度：O(m)
	 */
	public void merge1(int[] nums1, int m, int[] nums2, int n) {
		int[] nums1_copy = new int[m];
		System.arraycopy(nums1, 0, nums1_copy, 0, m);
		
		int p1 = 0;
		int p2 = 0;
		
		int p = 0;
		
		while((p1 < m) && (p2 < n)) {
			nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
		}
		
		if(p1 < m) {
			System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
		}
		
		if(p2 < n) {
			System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
		}
	}
	
	/** 
	 * 解法三：双指针 / 从后往前
	 * 时间复杂度：O(m+n)
	 * 空间复杂度：O(1)
	 */
	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m - 1;
		int p2 = n - 1;
		
		int p = m + n -1;
		
		while((p1 >= 0) && (p2 >= 0)) {
			nums1[p --] = (nums1[p1] < nums2[p2]) ? nums2[p2 --] : nums1[p1 --];
		}
		System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
	}

}
