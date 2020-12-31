package 力扣算法刷题.队列系列;

public class 滑动窗口的最大值 {
	
	/** 
	 * 题目：给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
	 */
	
	/** 
	 * 示例：
	 *     输入：nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
	 *     输出：[3,3,5,5,6,7]
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		滑动窗口的最大值 obj = new 滑动窗口的最大值();
		int[] result = obj.maxSlidingWindow(nums, k);
		System.out.println("模拟解法的结果为：" + result);
		result = obj.maxSlidingWindow1(nums, k);
		System.out.println("优化后的解法的结果为：" + result);
	}

	/** 
	 * 解法一： 模拟法，简单暴力
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || k <= 0 || nums.length < k) {
			return new int[0];
		}
		int length = nums.length - k + 1;
		int[] result = new int[length];
		int curMax;
		for(int i = 0; i < length; i ++) {
			curMax = Integer.MIN_VALUE;
			for(int j = 0; j < k; j ++) {
				curMax = Math.max(nums[i+j], curMax);
			}
			result[i] = curMax;
		}
		return result;
	}
	
	/** 
	 * 解法二：“剪枝”，提高效率
	 * 优化解法一的思路
	 */
	public int[] maxSlidingWindow1(int[] nums, int k) {
		if(nums == null || k <= 0 || nums.length < k) {
			return new int[0];
		}
		int length = nums.length - k + 1;
		int[] result = new int[length];
		
		int maxValueIndex = 0;
		int maxValue = nums[0];
		int startIndex = 0;
		int endIndex = k -1;
		
		/** 
		 * 处理第一个窗口
		 */
		for(int i = 0; i < k; i ++) {
			if(nums[i] >= maxValue) {
				maxValueIndex = i;
				maxValue = nums[i];
			}
		}
		result[0] = maxValue;
		
		/** 
		 * 处理之后的窗口
		 */
		for(int i = 1; i < length; i ++) {
			startIndex ++;
			endIndex ++;
			if(startIndex <= maxValueIndex) {  // 上一轮最大值，在当前窗口内，可以省些计算
				int num = nums[endIndex];
				if(num >= maxValue) {
					maxValueIndex = endIndex;
					maxValue = nums[endIndex];
				}
				result[i] = maxValue;
			}else {   // 上一轮最大值，不在当前窗口内
				int num = nums[endIndex];
				/** 
				 * 当前窗口的最后一个元素，比上一个窗口的最大值大，
				 * 表示当前窗口的最后一个元素就是当前窗口的最大值
				 */
				if(num >= maxValue) {
					maxValueIndex = endIndex;
					maxValue = nums[endIndex];
				}else {
					/** 
					 * 重新计算当前窗口的最大值
					 */
					maxValueIndex = 0;
					maxValue = -1;
					for(int j = startIndex; j <= endIndex; j ++) {
						if(nums[j] >= maxValue) {
							maxValueIndex = j;
							maxValue = nums[j];
						}
					}
				}
				result[i] = maxValue;
			}
		}
		return result;
	}
}
