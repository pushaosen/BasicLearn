package �����㷨ˢ��.˫ָ��ϵ��;

public class ��ɫ���� {
	
	/** 
	 * ��Ŀ������һ��������ɫ����ɫ����ɫ��һ�� n ��Ԫ�ص����飬ԭ�ض����ǽ�������ʹ����
	 *     ͬ��ɫ��Ԫ�����ڣ������պ�ɫ����ɫ����ɫ˳�����С�
	 *     
	 *     �����У�����ʹ������ 0�� 1 �� 2 �ֱ��ʾ��ɫ����ɫ����ɫ��
	 */
	
	/** 
	 * ʾ����
	 *    ���룺nums = [2,0,2,1,1,0]
	 *    �����[0,0,1,1,2,2]
	 *    
	 *    ���룺nums = [2,0,1]
	 *    �����[0,1,2]
	 *    
	 *    ���룺nums = [0]
	 *    �����[0]
	 *    
	 *    ���룺nums = [1]
	 *    �����[1]
	 */
	
	/** 
	 * �ⷨһ����ָ��
	 * ʱ�临�Ӷȣ�O(n)������n������nums�ĳ���
	 * �ռ临�Ӷȣ�O(1)
	 */
	public void sortColors(int[] nums) {
		int n = nums.length;
		int ptr = 0;
		for(int i = 0; i < n; ++ i) {
			if(nums[i] == 0) {
				int temp = nums[i];
				nums[i] = nums[ptr];
				nums[ptr] = temp;
				++ ptr;
			}
		}
		for(int i = ptr; i < n; ++ i) {
			if(nums[i] == 1) {
				int temp = nums[i];
				nums[i] = nums[ptr];
				nums[ptr] = temp;
				++ ptr;
			}
		}
	}
	
	/** 
	 * �ⷨ����˫ָ��
	 * ʱ�临�Ӷȣ�O(n)������n������ĳ���
	 * �ռ临�Ӷȣ�O(1)
	 */
	public void sortColors1(int[] nums) {
		int n = nums.length;
		int p0 = 0, p1 = 0;
		for(int i = 0; i < n; i ++) {
			if(nums[i] == 1) {
				int temp = nums[i];
				nums[i] = nums[p1];
				nums[p1] = temp;
				++ p1;
			}else if(nums[i] == 0){
				int temp = nums[i];
				nums[i] = nums[p0];
				nums[p0] = temp;
				if(p0 < p1) {
					temp = nums[i];
					nums[i] = nums[p1];
					nums[p1] = temp;
				}
				++ p0;
				++ p1;
			}
		}
	}
	
	/** 
	 * �ⷨ����˫ָ���Ż���
	 * ʱ�临�Ӷȣ�O(n)������n�������nums�ĳ���
	 * �ռ临�Ӷȣ�O(1)
	 */
	public void sortColors2(int[] nums) {
		int n = nums.length;
		int p0 = 0, p2 = n - 1;
		for(int i = 0; i <= p2; i ++) {
			while(i <= p2 && nums[i] == 2) {
				int temp = nums[i];
				nums[i] = nums[p0];
				nums[p0] = temp;
				++ p0;
			}
		}
	}

}
