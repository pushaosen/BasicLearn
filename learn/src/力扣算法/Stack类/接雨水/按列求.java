package 力扣算法.Stack类.接雨水;

/**
 * 时间复杂度：O(n²）O(n²），遍历每一列需要 nn，找出左边最高和右边最高的墙加起来刚好又是一个 nn，所以是 n²n²。

空间复杂度：O(1）O(1）
 * @author lenovo
 *
 */
public class 按列求 {

	public static int trap(int[] height) {
	    int sum = 0;
	    //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
	    for (int i = 1; i < height.length - 1; i++) {
	        int max_left = 0;
	        //找出左边最高
	        for (int j = i - 1; j >= 0; j--) {
	            if (height[j] > max_left) {
	                max_left = height[j];
	            }
	        }
	        int max_right = 0;
	        //找出右边最高
	        for (int j = i + 1; j < height.length; j++) {
	            if (height[j] > max_right) {
	                max_right = height[j];
	            }
	        }
	        //找出两端较小的
	        int min = Math.min(max_left, max_right);
	        //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
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
