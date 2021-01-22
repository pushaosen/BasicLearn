package �����㷨ˢ��.��ϣ��ϵ��;

import java.util.HashMap;
import java.util.Map;

public class ʹ������ܱ�P���� {
	
	/** 
	 * ��Ŀ������һ������������ nums�������Ƴ� ��� �����飨����Ϊ �գ���ʹ��ʣ��Ԫ�ص� �� �ܱ� p ������ ������ ���������鶼�Ƴ���
	 * 
	 * ���㷵������Ҫ�Ƴ������������ĳ��ȣ�����޷�������ĿҪ�󣬷��� -1 ��
	 * 
	 * ������ ����Ϊԭ������������һ��Ԫ�ء�
	 */
	
	/** 
	 * ʾ����
	 *    ���룺nums = [3,1,4,2], p = 6
	 *    �����1
	 *    ���ͣ�nums ��Ԫ�غ�Ϊ 10�����ܱ� p ���������ǿ����Ƴ������� [4] ��ʣ��Ԫ�صĺ�Ϊ 6��
	 *    
	 *    ���룺nums = [6,3,5,2], p = 9
	 *    �����2
	 *    ���ͣ������޷��Ƴ��κ�һ��Ԫ��ʹ�úͱ� 9 ���������ŷ������Ƴ������� [5,2] ��ʣ��Ԫ��Ϊ [6,3]����Ϊ 9 ��
	 *    
	 *    ���룺nums = [1,2,3], p = 3
	 *    �����0
	 *    ���ͣ���ǡ��Ϊ 6 ���Ѿ��ܱ� 3 �����ˡ��������ǲ���Ҫ�Ƴ��κ�Ԫ�ء�
	 *    
	 *    ���룺nums = [1,2,3], p = 7
	 *    �����-1
	 *    ���ͣ�û���κη���ʹ���Ƴ��������ʣ��Ԫ�صĺͱ� 7 ������
	 *    
	 *    ���룺nums = [1000000000,1000000000,1000000000], p = 3
	 *    �����0
	 */
	
	/** 
	 * ���ԣ�
	 */
	public static void main(String[] args) {
		int[] nums = {6,3,5,2};
		ʹ������ܱ�P����  obj = new ʹ������ܱ�P����();
		int p = 9;
		System.out.println("��ϣ��ⷨ�Ľ��Ϊ��" + obj.minSubarray(nums, p));
		System.out.println("�ⷨ���Ľ��Ϊ��" + obj.minSubarray1(nums, p));
	}
	
	/** 
	 * �ⷨһ����ϣ��
	 */
	private int minSubarray(int[] nums, int p) {
		int ans = Integer.MAX_VALUE;
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		// �� mod �洢 �͵�����
		long mod = 0;
		for(int num : nums) {
			mod += num;
		}
		mod = mod % p;
		if(mod == 0) {
			return 0;   // ��� ���� Ϊ�㣬��˵����������ĺ����ܱ������ģ�
		}
		long sum = 0;   // sum�洢����nums[0]��nums[i]�ĺͣ�Ҳ����ǰ׺��
		map.put((long)0, -1);   // �� 0 ����Ϊ-1����Ϊ������ʼ����Ϊ0��
		for(int i = 0; i < nums.length; i ++) {
			sum += nums[i];
			long counter = sum % p;    // ���ǰ׺�� �� p ȡ�࣡
			long ainmnum = (counter - mod + p) % p;  // ���Ŀ���ǰ׺��
			if(map.get(ainmnum) != null) {
				ans = Math.min(ans, i - map.get(ainmnum));
			}
			map.put(counter, i);   // ����ǰλ�õ�ǰ׺�ʹ洢map�У�
		}
		return ans >= nums.length ? -1 : ans;
	}
	
	/** 
	 * �ⷨ����ǰ׺��+��ϣ ����֮��
	 * ����˼·��
	 *       1����¼������ÿ��λ�õ�ǰ׺��
	 *       2��ʹ�ù�ϣ�� �ֱ�Ǽ�ÿ��λ������������ֵ  ���жϸ�λ���Ƿ�����������λ�õ�Ҫ��(����֮��)
	 *       3�������������p������ΪA��λ��Ϊi����ǰ׺�Ͷ�p������ΪB����ô��λ�������������ǣ�(A+B)%p
	 */
	private int minSubarray1(int[] nums, int p) {
		int N = nums.length;
		// ��¼λ��Ϊiʱ����0->i��ǰ׺�Ͷ�p������
		int[] prefixSum = new int[N];
		int sum = 0;
		for(int i = 0; i < N; i ++) {
			sum += nums[i] % p;
			sum %= p;
			prefixSum[i] = sum;
		}
		
		// �������������Ϊsum(��ȻҲ����prefixSum[N-1])
		// ����Ϊ0  �����Ƴ�  ����������
		if(sum == 0) {
			return 0;
		}
		// ���ս��������N  ����N��Ϊ�߽�ֵ
		int ans = N;
		// ���map��key��value  ��ʾ����ֵΪvalue��λ�ã���������ǰ׺�Ͷ�pȡ�������Ϊkey
		// �е�������֮�� ÿ��λ�ý��Լ�������ֵ��¼��map�У����ж��Լ����λ�ô��������Ƿ�����������λ�õ�Ҫ��
		Map<Integer, Integer> record = new HashMap<>();
		// �ڱ���֮ǰ����Ϊ�Ѿ�֪����������������Ϊsum����ô����һ��Ҫ��ɣ�
		record.put(sum, -1);
		for(int i = 0; i < N; i ++) {
			// λ��i��������
			int cur = prefixSum[i];
			// ��λ�ô�  ����������
			int target = (cur + sum) % p;
			// 1����¼�Լ���Ҫ�� ����ǰλ�õ�����ֵ��λ�ô���
			record.put(target, i);
			// 2���ж��Ƿ���ϱ��˵�Ҫ��
			if(record.containsKey(cur)) {
				int size = i - record.get(cur);
				ans = Math.min(ans, size);
				record.remove(cur);
			}
		}
		if(ans != N) {
			return ans;
		}
		return -1;
	}

}
