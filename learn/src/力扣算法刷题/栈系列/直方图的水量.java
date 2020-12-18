package �����㷨ˢ��.ջϵ��;

public class ֱ��ͼ��ˮ�� {

	/** 
	 * ��Ŀ������һ��ֱ��ͼ(Ҳ����״ͼ)���������˴�����ԴԴ���ϵص�ˮ��
	 * ���ֱ��ͼ�ܴ����ˮ��?ֱ��ͼ�Ŀ��Ϊ 1��
	 */
	
	/** 
	 * ʾ����
	 *     ���룺[0,1,0,2,1,0,1,3,2,1,2,1]
	 *     �����6
	 */
	
	/** 
	 * �ⷨһ��˫ָ��
	 * ִ����ʱ��1ms
	 * �ڴ����ģ�38.8MB
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
	 * �ⷨ���� ÿ���ҵ���ߵ����Ӻ͵ڶ��ߵ�����
	 * 
	 */
	public int trap1(int[] height) {
		if(height.length <= 2) {
			return 0;
		}
		this.height = height;
		int sum = 0;
		int start = 0, end = 0;
		for(int i = 0; i < height.length; ++ i) {  //���α������ҵ���ߵ����Ӹ���start��end
			if(height[start] < height[i]) {
				start = i;
				end = i;
			}
		}
		while(start > 0 || end < height.length - 1) {
			//��start��end֮�⣬�ҵ�������ӵ�λ�� p��h[p] <=h[start] ����h[p]<=h[end]
			int p = findHighest(start, end);
			if(start > p) { //p��startǰ��ʱ,�����ʱp��start֮��Ļ�ˮ
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
	 * ����������������ҵ� start��end֮��(����������)����ߵ�h[i]������i
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
