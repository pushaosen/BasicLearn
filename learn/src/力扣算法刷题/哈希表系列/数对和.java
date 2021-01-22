package �����㷨ˢ��.��ϣ��ϵ��;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class ���Ժ� {
	
	/** 
	 * ��Ŀ�����һ���㷨���ҳ�����������֮��Ϊָ��ֵ�����������ԡ�һ����ֻ������һ������
	 */
	
	/** 
	 * ����
	 */
	public static void main(String[] args) {
		���Ժ�  obj = new ���Ժ�();
		int[] nums = {5,6,5,6};
		int target = 11;
		List<List<Integer>> result = obj.pairSums(nums, target);
		System.out.println("˫ָ��Ľⷨ�Ľ��Ϊ��" + result.toString());
	}
	
	/** 
	 * ʾ����
	 *    ���룺nums = [5,6,5], target = 11
	 *    �����[[5,6]]
	 *    
	 *    ���룺nums = [5,6,5,6], target = 11
	 *    �����[[5,6],[6,5]]
	 */
	
	/** 
	 * �ⷨһ��˫ָ��
	 */
	private List<List<Integer>> pairSums(int[] nums, int target){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		// ����
		Arrays.sort(nums);
		// ͷβָ��
		int i = 0, j = nums.length - 1;
		while(i < j) {
			int sum = nums[i] + nums[j];
			if(sum == target) {   // 1���պ���ȣ�����ָ�붼���м���
				list.add(Arrays.asList(nums[i], nums[j]));
				i ++;
				j --;
			}else if(target > sum) {   // 2������֮��̫С����ָ�����ƣ��úͱ��
				i++;
			}else {      // 3������֮��̫����ָ�����ƣ��úͱ�С
				j --;
			}
		}
		return list;
	}
	
	/** 
	 * �ⷨ������ϣ��
	 * ����˼·��1����ͨ��һ��Map�洢���ݳ��ֵĴ���
	 *        2��ͨ���ж��Ƿ������֮��Ӵﵽk������
	 *        3��ͳ�ƽ��
	 */
	private List<List<Integer>> pairSums1(int[] nums, int target){
		List<List<Integer>> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		// ͳ��ÿ�����ݳ��ֵĴ�����keyΪ���ݣ�valueΪ����
		for(int num : nums) {
			Integer i = map.getOrDefault(num, 0);
			map.put(num, i + 1);
		}
		for(int num : nums) {
			// ��ʹﵽk������
			int x = target - num;
			// ��map��ȡx
			int i = map.get(num);
			// ���������С�ڵ���0��˵�����ݱ�ʹ�ù��ˡ���������������Ҳ���������ˡ�
			if(i <= 0) {
				continue;
			}
			// ͳ��������һ���ȼ�ȥ����ֹ������ͬ��������Ӵﵽk����ֻ��һ������
			map.put(num, i - 1);
			// �Ƿ�����һ�����ݣ���ͳ�Ƶ���������0
			if(map.containsKey(x) && map.get(x) > 0) {
				list.add(Arrays.asList(num, x));
				map.put(x, map.get(num) - 1);    // ������1
			}
		}
		return list;
	}

}
