package 力扣算法刷题.双指针系列;

public class 删除排序数组中的重复项 {
	
	/** 
	 * 题目：给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
	 *     不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
	 */
	
	/** 
	 * 示例：
	 *    输入：nums = [0,0,1,1,1,1,2,3,3]
	 *    输出：7, nums = [0,0,1,1,2,3,3]
	 *    解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 你不需要考虑数组中超出新长度后面的元素。
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		删除排序数组中的重复项 obj = new 删除排序数组中的重复项();
		int[] nums = {0,0,1,1,1,1,2,3,3};
		System.out.println("删除多余的重复项的解答结果为：" + obj.removeDuplicates(nums));
		System.out.println("覆盖多余的重复项的解答结果为：" + obj.removeDuplicates1(nums));
	}
	
	/** 
	 * 解法一：删除多余的重复项
	 * 时间复杂度：O(n*n)
	 * 空间复杂度：O(1)
	 */
	public int[] remElement(int[] arr, int index) {
		for(int i = index + 1; i < arr.length; i ++) {
			arr[i - 1] = arr[i];
		}
		return arr;
	}
	public int removeDuplicates(int[] nums) {
		int i = 1, count = 1, length = nums.length;
		while(i < length) {
			if(nums[i] == nums[i - 1]) {
				count ++;
				if(count > 2) {
					this.remElement(nums, i);
					i --;
					length --;
				}
			}else {
				count = 1;
			}
			i ++;
		}
		return length;
	}
	
	/** 
	 * 解法二：覆盖多余的重复项
	 * 时间复杂度：O(N)，我们遍历每个数组元素一次
	 * 空间复杂度：O(1)
	 */
	public int removeDuplicates1(int[] nums) {
		int j = 1, count = 1;
		for(int i = 1; i < nums.length; i ++) {
			if(nums[i] == nums[i - 1]) {
				count ++;
			}else {
				count = 1;
			}
			if(count <= 2) {
				nums[j ++] = nums[i];
			}
		}
		return j;
	}

}
