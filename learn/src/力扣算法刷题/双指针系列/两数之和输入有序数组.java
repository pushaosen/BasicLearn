package �����㷨ˢ��.˫ָ��ϵ��;

public class ����֮�������������� {
	
	/** 
	 * ��Ŀ������һ���Ѱ����������е��������飬�ҵ�������ʹ���������֮�͵���Ŀ������
	 *     ����Ӧ�÷����������±�ֵindex1��index2������index1����С��index2
	 *     
	 * ˵����
	 *    ���ص��±�ֵ(index1��index2)���Ǵ��㿪ʼ�ġ�
	 *    ����Լ���ÿ������ֻ��ӦΨһ�Ĵ𰸣������㲻�����ظ�ʹ����ͬ��Ԫ�ء�
	 */
	
	/** 
	 * ʾ����
	 *    ���룺numbers = [2, 7, 11, 15], target = 9
	 *    �����[1,2]
	 *    ���ͣ�2 �� 7 ֮�͵���Ŀ���� 9 ����� index1 = 1, index2 = 2 ��
	 */
	
	/** 
	 * ����
	 */
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		����֮�������������� obj = new ����֮��������������();
		int[] result = obj.twoSum1(nums, target);
		System.out.println("˫ָ��ⷨ�Ľ��Ϊ��" + result);
	}
	
	/** 
	 * �ⷨһ�����ֲ���
	 * ʱ�临�Ӷȣ�O(nlogn)������n������ĳ��ȡ���Ҫ��������һ��ȷ����һ������ʱ�临�Ӷ���O(n)��Ѱ�ҵڶ�����ʹ�ö��ֲ��ң�ʱ�临�Ӷ���O(logn)������ܵ�ʱ�临�Ӷ���O(nlogn)��
	 * �ռ临�Ӷȣ�O(1)
	 */
	public int[] twoSum(int[] nums, int target) {
		for(int i = 0; i < nums.length; ++ i) {
			int low = i + 1, high = nums.length - 1;
			while(low <= high) {
				int mid = (high - low) / 2;
				if(nums[mid] == target - nums[i]) {
					return new int[] {i + 1, mid + 1};
				}else if(nums[mid] > target - nums[i]) {
					high = mid - 1;
				}else {
					low = mid + 1;
				}
			}
		}
		return new int[] {-1, -1};
	}
	
	/** 
	 * �ⷨ����˫ָ��
	 * ʱ�临�Ӷȣ�O(n)������n������ĳ��ȡ�����ָ���ƶ����ܴ������Ϊn��
	 * �ռ临�Ӷȣ�O(1)��
	 */
	public int[] twoSum1(int[] numbers, int target) {
		int low = 0, high = numbers.length - 1;
		while(low < high) {
			int sum = numbers[low] + numbers[high];
			if(sum == target) {
				return new int[] {low + 1, high + 1};
			}else if(sum < target) {
				++ low;
			}else {
				-- high;
			}
		}
		return new int[] {-1, -1};
	}

}
