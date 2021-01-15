package 力扣算法刷题.双指针系列;

public class 直方图的水量 {
	
	/** 
	 * 题目：给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
	 */
	
	/** 
	 * 示例：
	 *    输入：[0,1,0,2,1,0,1,3,2,1,2,1]
	 *    输出：6
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		直方图的水量 obj = new 直方图的水量();
		System.out.println("双指针解法的结果为：" + obj.trap(height));
		System.out.println("解法二的结果为：" + obj.trap1(height));
	}
	
	/** 
	 * 解法一：双指针
	 * 解题思路：缓存两端最大值，从最大值较小的一边进行储水结算、移动，并更新最大值。
	 *       并使用左右指针，左边最大值比右边最大值小，则结果值加上左边最大值减去左边当前位置的值，并更新左边最大值
	 *                  左边最大值比右边最大值大，则结果值加上右边最大值减去右边当前位置的值，并更新右边最大值
	 */
	public int trap(int[] height) {
		// 边界值判断
		if(height.length < 3) {
			return 0;
		}
		
		// 使用左右指针
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
	
	/** 
	 * 解法二：每次找最高的柱子和第二高的柱子，求两者之间的积水
	 * 解题思路：
	 *       计start和end为上次找到的最高两根柱子的位置，start<end；
	 *       下一次找到start到end之外的最高柱子的位置为p；
	 *       1、p<start时，累加p到start之间的积水，
	 *       2、p>end时，累加end到p之间的积水
	 *       如此依次扩大start和end，直到水柱的整个范围，就可以求出总的积水
	 */
	int[] height;
	public int trap1(int[] height) {
		if(height.length <= 2) {
			return 0;
		}
		this.height = height;
		int sum = 0;
		int start = 0, end = 0;
		for(int i = 0; i < height.length; ++ i) {   // 初次遍历，找到最高的柱子给到start，end
			if(height[start] < height[i]) {
				start = i;
				end = i;
			}
		}
		while(start > 0 || end < height.length - 1) {
			// 除start到end之外，找到最高柱子的位置p，h[p] <= h[start]  并且 h[p] <= h[end]
			int p = findHighest(start, end);
			if(start > p) {   // p在start前面时，计算此时p到start之间的积水
				for(int i = p + 1; i < start; ++ i) {
					sum += height[p] - height[i];
				}
				start = p;
			}
			if(end < p) {    // p在end后面时，计算此时end到p之间的积水
				for(int i = end + 1; i < p; ++ i) {
					sum += height[p] - height[i];
				}
				end = p;
			}
		}
		return sum;
	}
	// 这个方法的作用是找到 start到end之外(不包含自身)的最高的h[i]，返回i
	private int findHighest(int start, int end) {
		int p = -1, max = -1;
		// 先找比start小的柱子，并不断更新最大值
		for(int i = 0; i < start; ++ i) {
			if(max < height[i]) {
				max = height[i];
				p = i;
			}
		}
		// 再找比end大的柱子，并不断更新最大值
		for(int i = end + 1; i < height.length; ++ i) {
			if(max < height[i]) {
				max = height[i];
				p = i;
			}
		}
		return p;
	}

}
