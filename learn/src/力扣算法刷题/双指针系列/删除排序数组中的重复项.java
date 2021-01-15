package �����㷨ˢ��.˫ָ��ϵ��;

public class ɾ�����������е��ظ��� {
	
	/** 
	 * ��Ŀ������һ�������������� nums ������Ҫ�� ԭ�� ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ�����������Σ������Ƴ���������³��ȡ�
	 *     ��Ҫʹ�ö��������ռ䣬������� ԭ�� �޸��������� ����ʹ�� O(1) ����ռ�����������
	 */
	
	/** 
	 * ʾ����
	 *    ���룺nums = [0,0,1,1,1,1,2,3,3]
	 *    �����7, nums = [0,0,1,1,2,3,3]
	 *    ���ͣ�����Ӧ�����³��� length = 5, ����ԭ�����ǰ���Ԫ�ر��޸�Ϊ 1, 1, 2, 2, 3 �� �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
	 */
	
	/** 
	 * ����
	 */
	public static void main(String[] args) {
		ɾ�����������е��ظ��� obj = new ɾ�����������е��ظ���();
		int[] nums = {0,0,1,1,1,1,2,3,3};
		System.out.println("ɾ��������ظ���Ľ����Ϊ��" + obj.removeDuplicates(nums));
		System.out.println("���Ƕ�����ظ���Ľ����Ϊ��" + obj.removeDuplicates1(nums));
	}
	
	/** 
	 * �ⷨһ��ɾ��������ظ���
	 * ʱ�临�Ӷȣ�O(n*n)
	 * �ռ临�Ӷȣ�O(1)
	 */
	public int[] remElement(int[] arr, int index) {
		for(int i = index + 1; i < arr.length; i ++) {
			arr[i - 1] = arr[i];
		}
		return arr;
	}
	public int removeDuplicates(int[] nums) {
		int i = 1, count = 1, length = nums.length;
		while(i < length) {
			if(nums[i] == nums[i - 1]) {
				count ++;
				if(count > 2) {
					this.remElement(nums, i);
					i --;
					length --;
				}
			}else {
				count = 1;
			}
			i ++;
		}
		return length;
	}
	
	/** 
	 * �ⷨ�������Ƕ�����ظ���
	 * ʱ�临�Ӷȣ�O(N)�����Ǳ���ÿ������Ԫ��һ��
	 * �ռ临�Ӷȣ�O(1)
	 */
	public int removeDuplicates1(int[] nums) {
		int j = 1, count = 1;
		for(int i = 1; i < nums.length; i ++) {
			if(nums[i] == nums[i - 1]) {
				count ++;
			}else {
				count = 1;
			}
			if(count <= 2) {
				nums[j ++] = nums[i];
			}
		}
		return j;
	}

}
