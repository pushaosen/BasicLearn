package 力扣算法刷题.双指针系列;

public class 两数之和输入有序数组 {
	
	/** 
	 * 题目：给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。
	 *     函数应该返回这两个下标值index1和index2，其中index1必须小于index2
	 *     
	 * 说明：
	 *    返回的下标值(index1和index2)不是从零开始的。
	 *    你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
	 */
	
	/** 
	 * 示例：
	 *    输入：numbers = [2, 7, 11, 15], target = 9
	 *    输出：[1,2]
	 *    解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		两数之和输入有序数组 obj = new 两数之和输入有序数组();
		int[] result = obj.twoSum1(nums, target);
		System.out.println("双指针解法的结果为：" + result);
	}
	
	/** 
	 * 解法一：二分查找
	 * 时间复杂度：O(nlogn)，其中n是数组的长度。需要遍历数组一次确定第一个数，时间复杂度是O(n)，寻找第二个数使用二分查找，时间复杂度是O(logn)，因此总的时间复杂度是O(nlogn)。
	 * 空间复杂度：O(1)
	 */
	public int[] twoSum(int[] nums, int target) {
		for(int i = 0; i < nums.length; ++ i) {
			int low = i + 1, high = nums.length - 1;
			while(low <= high) {
				int mid = (high - low) / 2;
				if(nums[mid] == target - nums[i]) {
					return new int[] {i + 1, mid + 1};
				}else if(nums[mid] > target - nums[i]) {
					high = mid - 1;
				}else {
					low = mid + 1;
				}
			}
		}
		return new int[] {-1, -1};
	}
	
	/** 
	 * 解法二：双指针
	 * 时间复杂度：O(n)，其中n是数组的长度。两个指针移动的总次数最多为n次
	 * 空间复杂度：O(1)。
	 */
	public int[] twoSum1(int[] numbers, int target) {
		int low = 0, high = numbers.length - 1;
		while(low < high) {
			int sum = numbers[low] + numbers[high];
			if(sum == target) {
				return new int[] {low + 1, high + 1};
			}else if(sum < target) {
				++ low;
			}else {
				-- high;
			}
		}
		return new int[] {-1, -1};
	}

}
