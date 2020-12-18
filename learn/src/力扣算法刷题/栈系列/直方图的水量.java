package 力扣算法刷题.栈系列;

public class 直方图的水量 {

	/** 
	 * 题目：给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，
	 * 最后直方图能存多少水量?直方图的宽度为 1。
	 */
	
	/** 
	 * 示例：
	 *     输入：[0,1,0,2,1,0,1,3,2,1,2,1]
	 *     输出：6
	 */
	
	/** 
	 * 解法一：双指针
	 * 执行用时：1ms
	 * 内存消耗：38.8MB
	 */
	public int trap(int[] height) {
		if(height.length < 3) {
			return 0;
		}
		int left = 0, right = height.length - 1;
		int leftMax = height[left], rightMax = height[right];
		int res = 0;
		
		while(left < right) {
			if(leftMax < rightMax) {
				res += leftMax - height[left ++];
				leftMax = Math.max(height[left], leftMax);
			}else {
				res += rightMax - height[right --];
				rightMax = Math.max(height[right], rightMax);
			}
		}
		return res;
	}
	
	private int[] height;
	/** 
	 * 解法二： 每次找到最高的柱子和第二高的柱子
	 * 
	 */
	public int trap1(int[] height) {
		if(height.length <= 2) {
			return 0;
		}
		this.height = height;
		int sum = 0;
		int start = 0, end = 0;
		for(int i = 0; i < height.length; ++ i) {  //初次遍历，找到最高的柱子给到start，end
			if(height[start] < height[i]) {
				start = i;
				end = i;
			}
		}
		while(start > 0 || end < height.length - 1) {
			//除start到end之外，找到最高柱子的位置 p，h[p] <=h[start] 并且h[p]<=h[end]
			int p = findHighest(start, end);
			if(start > p) { //p在start前面时,计算此时p到start之间的积水
				for(int i = p + 1; i < start; ++ i) {
					sum += height[p] - height[i];
				}
				start = p;
			}
			if(end < p) {
				for(int i = end + 1; i < p; ++ i) {
					sum += height[p] - height[i];
				}
				end = p;
			}
		}
		return sum;
	}
	
	/** 
	 * 这个方法的作用是找到 start到end之外(不包含自身)的最高的h[i]，返回i
	 */
	private int findHighest(int start, int end) {
		int p = -1, max = -1;
		for(int i = 0; i < start; ++ i) {
			if(max < height[i]) {
				max = height[i];
				p = i;
			}
		}
		for(int i = end + 1; i < height.length; ++ i) {
			if(max < height[i]) {
				max = height[i];
				p = i;
			}
		}
		return p;
	}
}
