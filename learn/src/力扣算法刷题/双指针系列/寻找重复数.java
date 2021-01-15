package �����㷨ˢ��.˫ָ��ϵ��;

public class Ѱ���ظ��� {
	
	/** 
	 * ��Ŀ������һ������ n + 1 ������������ nums �������ֶ��� 1 �� n ֮�䣨���� 1 �� n������֪���ٴ���һ���ظ���������
	 *     ���� nums ֻ�� һ���ظ������� ���ҳ� ����ظ����� ��
	 */
	
	/** 
	 * ʾ����
	 *    ���룺nums = [1,3,4,2,2]
	 *    �����2
	 *    
	 *    ���룺nums = [3,1,3,4,2]
	 *    �����3
	 *    
	 *    ���룺nums = [1,1]
	 *    �����1
	 *    
	 *    ���룺nums = [1,1,2]
	 *    �����1
	 */
	
	/** 
	 * ���ԣ�
	 */
	public static void main(String[] args) {
		int[] nums = {1,3,4,2,2};
		Ѱ���ظ��� obj = new Ѱ���ظ���();
		System.out.println("���ֲ��ҽⷨ�Ľ��Ϊ��" + obj.findDuplicate(nums));
		System.out.println("����ָ��ⷨ�Ľ��Ϊ��" + obj.findDuplicate1(nums));
	}
	
	/** 
	 * �ⷨһ�����ֲ���
	 * ʱ�临�Ӷȣ�O(nlog n)������nΪnums����ĳ��ȡ����ֲ��������Ҫ����O(nlog n)�Σ�ÿ���жϵ�ʱ����ҪO(n)����nums[]�������С�ڵ���mid�ĸ��������
	 *         ��ʱ�临�Ӷ�ΪO(nlog n)
	 * �ռ临�Ӷȣ�O(1)������ֻ��Ҫ�����ռ������ɱ�����
	 */
	public int findDuplicate(int[] nums) {
		int n = nums.length;
		int l = 1, r = n - 1, ans = -1;
		while(l <= r) {
			int mid = (l + r) >> 1;
			int cnt = 0;
			for(int i = 0; i < n; ++ i) {
				if(nums[i] <= mid) {
					cnt ++;
				}
			}
			if(cnt <= mid) {
				l = mid + 1;
			}else {
				r = mid - 1;
				ans = mid;
			}
		}
		return ans;
	}
	
	/** 
	 * �ⷨ��������ָ��
	 * ʱ�临�Ӷȣ�O(n)����Floyd ��Ȧ�㷨��ʱ�临�Ӷ�Ϊ���Ե�ʱ�临�Ӷȡ�
	 * �ռ临�Ӷȣ�O(1)������ֻ��Ҫ�����ռ������ɱ���
	 */
	public int findDuplicate1(int[] nums) {
		int slow = 0, fast = 0;
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while(slow != fast);
		slow = 0;
		while(slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}

}
