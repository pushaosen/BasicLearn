package 力扣算法.Stack类.接雨水;

import java.util.Stack;

/**
 * 时间复杂度：虽然 while 循环里套了一个 while 循环，但是考虑到每个元素最多访问两次，入栈一次和出栈一次，所以时间复杂度是 O(n)O(n)。

空间复杂度：O(n)O(n)。栈的空间。

 */
public class 栈的方式 {
	
	public static int trap6(int[] height) {
	    int sum = 0;
	    Stack<Integer> stack = new Stack<>();
	    int current = 0;
	    while (current < height.length) {
	        //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
	        while (!stack.empty() && height[current] > height[stack.peek()]) {
	            int h = height[stack.peek()]; //取出要出栈的元素
	            stack.pop(); //出栈
	            if (stack.empty()) { // 栈空就出去
	                break; 
	            }
	            int distance = current - stack.peek() - 1; //两堵墙之前的距离。
	            int min = Math.min(height[stack.peek()], height[current]);
	            sum = sum + distance * (min - h);
	        }
	        stack.push(current); //当前指向的墙入栈
	        current++; //指针后移
	    }
	    return sum;
	}

	public static void main(String[] args) {
		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
		int result = trap6(arr);
		System.out.println("最后可以接水：" + result);
	}

}
