package �����㷨.Stack��.����ˮ;

/**
 * ʱ�临�Ӷȣ� O(n)O(n)��

�ռ临�Ӷȣ� O(1)O(1)��
 * @author lenovo
 *
 */
public class ˫ָ�� {

	public static int trap(int[] height) {
	    int sum = 0;
	    int max_left = 0;
	    int[] max_right = new int[height.length];
	    for (int i = height.length - 2; i >= 0; i--) {
	        max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
	    }
	    for (int i = 1; i < height.length - 1; i++) {
	        max_left = Math.max(max_left, height[i - 1]);
	        int min = Math.min(max_left, max_right[i]);
	        if (min > height[i]) {
	            sum = sum + (min - height[i]);
	        }
	    }
	    return sum;
	}

	public static void main(String[] args) {
		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
		int result = trap(arr);
		System.out.println("�����Խ�ˮ��" + result);
	}
}
