package �����㷨.��̬�滮�½��㷨˼��;

/**
 * ����ⷨ��ʱ�临�Ӷ�ΪO(NlogN)
 * @author lenovo
 *
 */
public class �����������֮���ֲ��ҽⷨ {
	
	public static int lengthOfLIS(int[] nums) {
		int[] top = new int[nums.length];
		// �ƶ�����ʼ��Ϊ 0
		int piles = 0;
		for(int i = 0; i < nums.length; i ++) {
			// Ҫ������˿���
			int poker = nums[i];
			
			/** �������߽�Ķ��ֲ��� */
			int left = 0, right = piles;
			while(left < right) {
				int mid = (left + right) / 2;
				if(top[mid] > poker) {
					right = mid;
				}else if(top[mid] < poker) {
					left = mid + 1;
				}else {
					right = mid;
				}
			}
			/***************************************/
			
			// û�ҵ����ʵ��ƶѣ��½�һ��
			if(left == piles) {
				piles ++;
			}
			// �������Ʒŵ��ƶѶ�
			top[left] = poker;
		}
		// �ƶ������� LIS����
		return piles;
	}

}

/***
 * ����ⷨȷʵ�����뵽�������漰��ѧ֤����˭���뵽������Щ����ִ�У����ܵõ�������������أ���λ���
 * ���ֲ��ҵ����ã�Ҫ�ǶԶ��ֲ��ҵ�ϸ�ڲ����������˼·Ҳ����д�ԡ�
 * */
