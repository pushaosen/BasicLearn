package 力扣算法.动态规划章节算法思想;

/**
 * 这个解法的时间复杂度为O(NlogN)
 * @author lenovo
 *
 */
public class 最长递增子序列之二分查找解法 {
	
	public static int lengthOfLIS(int[] nums) {
		int[] top = new int[nums.length];
		// 牌堆数初始化为 0
		int piles = 0;
		for(int i = 0; i < nums.length; i ++) {
			// 要处理的扑克牌
			int poker = nums[i];
			
			/** 搜索左侧边界的二分查找 */
			int left = 0, right = piles;
			while(left < right) {
				int mid = (left + right) / 2;
				if(top[mid] > poker) {
					right = mid;
				}else if(top[mid] < poker) {
					left = mid + 1;
				}else {
					right = mid;
				}
			}
			/***************************************/
			
			// 没找到合适的牌堆，新建一堆
			if(left == piles) {
				piles ++;
			}
			// 把这张牌放到牌堆顶
			top[left] = poker;
		}
		// 牌堆数就是 LIS长度
		return piles;
	}

}

/***
 * 这个解法确实很难想到。首先涉及数学证明，谁能想到按照这些规则执行，就能得到最长递增子序列呢？其次还有
 * 二分查找的运用，要是对二分查找的细节不清楚，给了思路也很难写对。
 * */
