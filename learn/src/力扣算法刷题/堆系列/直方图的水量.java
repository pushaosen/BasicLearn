package �����㷨ˢ��.��ϵ��;

import java.util.Stack;

public class ֱ��ͼ��ˮ�� {

	/** 
	 * ��Ŀ������һ��ֱ��ͼ(Ҳ����״ͼ)���������˴�����ԴԴ���ϵص�ˮ�����ֱ��ͼ�ܴ����ˮ��?ֱ��ͼ�Ŀ��Ϊ 1
	 */
	
	/** 
	 * ʾ����
	 *     ���룺[0,1,0,2,1,0,1,3,2,1,2,1]
	 *     �����6
	 */
	
	/** 
	 * �ⷨһ������ջ
	 */
	public int trap(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int water = 0;
		// �������
		if(height.length < 3) {
			return 0;
		}
		for(int i = 0; i < height.length; i ++) {
			while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
				// ջ��Ԫ��
				int popnum = stack.pop();
				// ��ͬԪ�ص������1,1
				if(!stack.isEmpty() && height[popnum] == height[stack.peek()]) {
					stack.pop();
				}
				// ����ò��ˮ�ĵ�λ
				if(!stack.isEmpty()) {
					int temp = height[stack.peek()];  // ջ��Ԫ��ֵ
					// ��
					int hig = Math.min(temp-height[popnum], height[i] - height[popnum]);
					// ��
					int wid = i - stack.peek() - 1;
					water += hig * wid;
				}
			}
			// ������ջ��������
			stack.push(i);
		}
		return water;
	}
}
