package 力扣算法.Stack类.接雨水;

/**
 * 时间复杂度：O(n)O(n)。

空间复杂度：O(n)O(n)，用来保存每一列左边最高的墙和右边最高的墙。
 * @author lenovo
 *
 */
public class 动态规划 {

	public static int trap(int[] height) {
	    int sum = 0;
	    int[] max_left = new int[height.length];
	    int[] max_right = new int[height.length];
	    
	    for (int i = 1; i < height.length - 1; i++) {
	        max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
	    }
	    for (int i = height.length - 2; i >= 0; i--) {
	        max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
	    }
	    for (int i = 1; i < height.length - 1; i++) {
	        int min = Math.min(max_left[i], max_right[i]);
	        if (min > height[i]) {
	            sum = sum + (min - height[i]);
	        }
	    }
	    return sum;
	}
	
	public static void main(String[] args) {
		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
		int result = trap(arr);
		System.out.println("最后可以接水：" + result);
	}

}
