package �����㷨.Stack��.����ˮ;

import java.util.Stack;

/**
 * ʱ�临�Ӷȣ���Ȼ while ѭ��������һ�� while ѭ�������ǿ��ǵ�ÿ��Ԫ�����������Σ���ջһ�κͳ�ջһ�Σ�����ʱ�临�Ӷ��� O(n)O(n)��

�ռ临�Ӷȣ�O(n)O(n)��ջ�Ŀռ䡣

 */
public class ջ�ķ�ʽ {
	
	public static int trap6(int[] height) {
	    int sum = 0;
	    Stack<Integer> stack = new Stack<>();
	    int current = 0;
	    while (current < height.length) {
	        //���ջ���ղ��ҵ�ǰָ��ĸ߶ȴ���ջ���߶Ⱦ�һֱѭ��
	        while (!stack.empty() && height[current] > height[stack.peek()]) {
	            int h = height[stack.peek()]; //ȡ��Ҫ��ջ��Ԫ��
	            stack.pop(); //��ջ
	            if (stack.empty()) { // ջ�վͳ�ȥ
	                break; 
	            }
	            int distance = current - stack.peek() - 1; //����ǽ֮ǰ�ľ��롣
	            int min = Math.min(height[stack.peek()], height[current]);
	            sum = sum + distance * (min - h);
	        }
	        stack.push(current); //��ǰָ���ǽ��ջ
	        current++; //ָ�����
	    }
	    return sum;
	}

	public static void main(String[] args) {
		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
		int result = trap6(arr);
		System.out.println("�����Խ�ˮ��" + result);
	}

}
