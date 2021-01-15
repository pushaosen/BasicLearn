package �����㷨ˢ��.˫ָ��ϵ��;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ����֮�� {
	
	/** 
	 * ��Ŀ��
	 *    ����һ������ n ������������ nums���ж� nums ���Ƿ��������Ԫ�� a��b��c ��ʹ�� a + b + c = 0 �������ҳ����к�Ϊ 0 �Ҳ��ظ�����Ԫ�顣
	 *    
	 * ע�⣺���в����԰����ظ�����Ԫ��
	 */
	
	/** 
	 * ʾ����
	 *    ���룺nums = [-1,0,1,2,-1,-4]
	 *    �����[[-1,-1,2],[-1,0,1]]
	 *    
	 *    ���룺nums = []
	 *    �����[]
	 *    
	 *    ���룺nums = [0]
	 *    �����[]
	 */
	
	/** 
	 * �ⷨһ������+˫ָ��
	 * ʱ�临�Ӷȣ�O(N*N)������N������nums�ĳ���
	 * �ռ临�Ӷȣ�O(logN)�����Ǻ��Դ洢�𰸵Ŀռ䣬���������Ŀռ临�Ӷ�ΪO(logN)��Ȼ�������޸������������nums����ʵ������²�һ������
	 *         ��˿��Կ�����ʹ����һ�����������洢��nums�ĸ������������򣬿ռ临�Ӷ�ΪO(N)
	 */
	public List<List<Integer>> threeSum(int[] nums){
		int n = nums.length;
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();
		// ö��a
		for(int first = 0; first < n; ++ first) {
			// ��Ҫ����һ��ö�ٵ�������ͬ
			if(first > 0 && nums[first] == nums[first - 1]) {
				continue;
			}
			// c ��Ӧ��ָ���ʼָ����������Ҷ�
			int third = n - 1;
			int target = -nums[first];
			// ö�� b
			for(int second = first + 1; second < n; ++ second) {
				// ��Ҫ����һ��ö�ٵ�������ͬ
				if(second > first + 1 && nums[second] == nums[second - 1]) {
					continue;
				}
				// ��Ҫ��֤b��ָ����c��ָ������
				while(second < third && nums[second] + nums[third] > target) {
					-- third;
				}
				// ���ָ���غϣ�����b���������
				// �Ͳ���������a+b+c=0 ����b<c��c�ˣ������˳�ѭ��
				if(second == third) {
					break;
				}
				if(nums[second] + nums[third] == target) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[first]);
					list.add(nums[second]);
					list.add(nums[third]);
					ans.add(list);
				}
			}
		}
		return ans;
	}

}
