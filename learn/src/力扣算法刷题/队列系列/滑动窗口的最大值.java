package �����㷨ˢ��.����ϵ��;

public class �������ڵ����ֵ {
	
	/** 
	 * ��Ŀ������һ������ nums �ͻ������ڵĴ�С k�����ҳ����л�������������ֵ��
	 */
	
	/** 
	 * ʾ����
	 *     ���룺nums = [1,3,-1,-3,5,3,6,7], �� k = 3
	 *     �����[3,3,5,5,6,7]
	 */
	
	/** 
	 * ����
	 */
	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		�������ڵ����ֵ obj = new �������ڵ����ֵ();
		int[] result = obj.maxSlidingWindow(nums, k);
		System.out.println("ģ��ⷨ�Ľ��Ϊ��" + result);
		result = obj.maxSlidingWindow1(nums, k);
		System.out.println("�Ż���Ľⷨ�Ľ��Ϊ��" + result);
	}

	/** 
	 * �ⷨһ�� ģ�ⷨ���򵥱���
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || k <= 0 || nums.length < k) {
			return new int[0];
		}
		int length = nums.length - k + 1;
		int[] result = new int[length];
		int curMax;
		for(int i = 0; i < length; i ++) {
			curMax = Integer.MIN_VALUE;
			for(int j = 0; j < k; j ++) {
				curMax = Math.max(nums[i+j], curMax);
			}
			result[i] = curMax;
		}
		return result;
	}
	
	/** 
	 * �ⷨ��������֦�������Ч��
	 * �Ż��ⷨһ��˼·
	 */
	public int[] maxSlidingWindow1(int[] nums, int k) {
		if(nums == null || k <= 0 || nums.length < k) {
			return new int[0];
		}
		int length = nums.length - k + 1;
		int[] result = new int[length];
		
		int maxValueIndex = 0;
		int maxValue = nums[0];
		int startIndex = 0;
		int endIndex = k -1;
		
		/** 
		 * �����һ������
		 */
		for(int i = 0; i < k; i ++) {
			if(nums[i] >= maxValue) {
				maxValueIndex = i;
				maxValue = nums[i];
			}
		}
		result[0] = maxValue;
		
		/** 
		 * ����֮��Ĵ���
		 */
		for(int i = 1; i < length; i ++) {
			startIndex ++;
			endIndex ++;
			if(startIndex <= maxValueIndex) {  // ��һ�����ֵ���ڵ�ǰ�����ڣ�����ʡЩ����
				int num = nums[endIndex];
				if(num >= maxValue) {
					maxValueIndex = endIndex;
					maxValue = nums[endIndex];
				}
				result[i] = maxValue;
			}else {   // ��һ�����ֵ�����ڵ�ǰ������
				int num = nums[endIndex];
				/** 
				 * ��ǰ���ڵ����һ��Ԫ�أ�����һ�����ڵ����ֵ��
				 * ��ʾ��ǰ���ڵ����һ��Ԫ�ؾ��ǵ�ǰ���ڵ����ֵ
				 */
				if(num >= maxValue) {
					maxValueIndex = endIndex;
					maxValue = nums[endIndex];
				}else {
					/** 
					 * ���¼��㵱ǰ���ڵ����ֵ
					 */
					maxValueIndex = 0;
					maxValue = -1;
					for(int j = startIndex; j <= endIndex; j ++) {
						if(nums[j] >= maxValue) {
							maxValueIndex = j;
							maxValue = nums[j];
						}
					}
				}
				result[i] = maxValue;
			}
		}
		return result;
	}
}
