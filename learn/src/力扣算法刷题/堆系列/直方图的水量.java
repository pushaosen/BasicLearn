package 力扣算法刷题.堆系列;

import java.util.Stack;

public class 直方图的水量 {

	/** 
	 * 题目：给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1
	 */
	
	/** 
	 * 示例：
	 *     输入：[0,1,0,2,1,0,1,3,2,1,2,1]
	 *     输出：6
	 */
	
	/** 
	 * 解法一：单调栈
	 */
	public int trap(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int water = 0;
		// 特殊情况
		if(height.length < 3) {
			return 0;
		}
		for(int i = 0; i < height.length; i ++) {
			while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
				// 栈顶元素
				int popnum = stack.pop();
				// 相同元素的情况例1,1
				if(!stack.isEmpty() && height[popnum] == height[stack.peek()]) {
					stack.pop();
				}
				// 计算该层的水的单位
				if(!stack.isEmpty()) {
					int temp = height[stack.peek()];  // 栈顶元素值
					// 高
					int hig = Math.min(temp-height[popnum], height[i] - height[popnum]);
					// 宽
					int wid = i - stack.peek() - 1;
					water += hig * wid;
				}
			}
			// 这里入栈的是索引
			stack.push(i);
		}
		return water;
	}
}
