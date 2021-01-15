package 力扣算法刷题.双指针系列;

public class 寻找重复数 {
	
	/** 
	 * 题目：给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
	 *     假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
	 */
	
	/** 
	 * 示例：
	 *    输入：nums = [1,3,4,2,2]
	 *    输出：2
	 *    
	 *    输入：nums = [3,1,3,4,2]
	 *    输出：3
	 *    
	 *    输入：nums = [1,1]
	 *    输出：1
	 *    
	 *    输入：nums = [1,1,2]
	 *    输出：1
	 */
	
	/** 
	 * 测试：
	 */
	public static void main(String[] args) {
		int[] nums = {1,3,4,2,2};
		寻找重复数 obj = new 寻找重复数();
		System.out.println("二分查找解法的结果为：" + obj.findDuplicate(nums));
		System.out.println("快慢指针解法的结果为：" + obj.findDuplicate1(nums));
	}
	
	/** 
	 * 解法一：二分查找
	 * 时间复杂度：O(nlog n)，其中n为nums数组的长度。二分查找最多需要二分O(nlog n)次，每次判断的时候需要O(n)遍历nums[]数组求解小于等于mid的个数，因此
	 *         总时间复杂度为O(nlog n)
	 * 空间复杂度：O(1)，我们只需要常数空间存放若干变量。
	 */
	public int findDuplicate(int[] nums) {
		int n = nums.length;
		int l = 1, r = n - 1, ans = -1;
		while(l <= r) {
			int mid = (l + r) >> 1;
			int cnt = 0;
			for(int i = 0; i < n; ++ i) {
				if(nums[i] <= mid) {
					cnt ++;
				}
			}
			if(cnt <= mid) {
				l = mid + 1;
			}else {
				r = mid - 1;
				ans = mid;
			}
		}
		return ans;
	}
	
	/** 
	 * 解法二：快慢指针
	 * 时间复杂度：O(n)，「Floyd 判圈算法」时间复杂度为线性的时间复杂度。
	 * 空间复杂度：O(1)，我们只需要常数空间存放若干变量
	 */
	public int findDuplicate1(int[] nums) {
		int slow = 0, fast = 0;
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while(slow != fast);
		slow = 0;
		while(slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}

}
