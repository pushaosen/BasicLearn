package �����㷨ˢ��.ջϵ��;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class �������õ��ʱ��� {
	
	/** 
	 * ��Ŀ������һ�ݹ���ʱ��� hours�������¼��ĳһλԱ��ÿ��Ĺ���Сʱ����
	 *     ������Ϊ��Ա��һ���еĹ���Сʱ������ 8 Сʱ��ʱ����ô��һ����ǡ����۵�һ�졹
	 *     
	 *     ��ν���������õ�ʱ��Ρ�����ζ�����ʱ���ڣ������۵����������ϸ���ڡ������۵�������
	 *     
	 *     ���㷵�ء���������ʱ��Ρ�����󳤶�
	 */

	/** 
	 * ʵ����
	 *     ���룺hours = [9,9,6,0,6,6,9]
	 *     �����3
	 *     ���ͣ���ı������õ�ʱ�����[9, 9, 6]
	 */
	
	/** 
	 * �ⷨһ������ջ
	 */
	public int longestWPI(int[] hours) {
		for(int i = 0; i < hours.length; i ++) {
			hours[i] = hours[i] > 8 ? 1 : -1;
		}
		int[] score = new int[hours.length + 1];
		score[0] = 0;
		for(int i = 1; i < score.length; i ++) {
			score[i] = score[i - 1] + hours[i - 1];
		}
		// �ݼ�ջ
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < score.length; i ++) {
			if(!stack.empty() && score[stack.peek()] <= score[i]) {
				continue;
			}
			stack.push(i);
		}
		int ans = 0;
		for(int i = score.length - 1; i >= 0; i --) {
			if(score[i] > score[stack.peek()]) {
				ans = Math.max(ans, i - stack.peek());
				stack.pop();
				i ++;
				if(stack.empty()) {
					break;
				}
				continue;
			}
		}
		return ans;
	}
	
	/** 
	 * �ⷨ����ǰ׺+hash
	 * �����ã�
	 */
	public int longestWPI1(int[] hours) {
		int[] pre_sum = new int[hours.length + 1];
		pre_sum[0] = 0;
		int res = 0;
		// ��ʼ��ǰ׺������ pre_sum[i]��ʾ����Ϊi�������ǰ׺��
		for(int i = 1; i <= hours.length; i ++) {
			pre_sum[i] = pre_sum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
			// 1������[0:i-1]�������  res������sum[0:i-1]>0������г���
			if(pre_sum[i] > 0) {
				res = 1;
			}
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		// ��¼��һ�γ���pre_sum[i]������i �� ʹ��ǰ׺����pre_sum[i]����С����
		for(int i = 0; i < hours.length; i ++) {
			if(pre_sum[i] < 0 && !map.containsKey(pre_sum[i])) {
				map.put(pre_sum[i], i);
			}
		}
		
		/** 
		 * 2������[i:j]�������  ��ʱֻ�迼��pre_sum[j] <= 0�����
		 * ������[0,j)����һ��i��ʹsum[i:j]>0�Ҿ�����С��
		 * ����1��pre_sum[i + 1] < pre_sum[j + 1] <= 0
		 * ����2���������-(a+1)����ô-aһ��������-aһ���������-(a+1)֮ǰ     
		 * �������ۣ�pre_sum[i+1]��С��pre_sum[j+1]�����ĸ���ֻ�ܵ���pre_sum[j+1]-1
		 */
		for(int j = 0; j < hours.length; j ++) {
			if(pre_sum[j] <= 0 && map.containsKey(pre_sum[j+1]-1)) {
				int i = map.get(pre_sum[j+1] - 1);
				if(i <= j) {
					res = Math.max(j - i + 1, res);
				}
			}
		}
		return res;
	}
	
	/*
	 * �ⷨ������ϣ���¼ǰ׺������
	 */
	public int longestWPI2(int[] hours) {
		int sum = 0;
		int res = 0;
		Map<Integer, Integer> sumToIndex = new HashMap<>();
		for(int i = 0; i < hours.length; i ++) {
			int temp = hours[i] > 8 ? 1 : -1;
			sum += temp;
			if(sum > 0) {
				res = i + 1;
			}else {
				if(!sumToIndex.containsKey(sum)) {
					sumToIndex.put(sum, i);
				}
				if(sumToIndex.containsKey(sum - 1)) {
					res = Math.max(res, i - sumToIndex.get(sum - 1));
				}
			}
		}
		return res;
	}
	
	/*
	 * �ⷨ�ģ�������
	 */
	public int longestWPI3(int[] hours) {
		int n = hours.length;
		for(int i = 0; i < n; i ++) {
			hours[i] = hours[i] > 8 ? 1 : -1;
		}
		int res = 0;
		for(int i = 0; i < n; i ++) {
			int count = 0;
			for(int j = i; j < n; j ++) {
				count += hours[j];
				if(count > 0) {
					res = Math.max(res, j - i + 1);
				}
			}
			if(n - i <= res) {
				return res;
			}
		}
		return res;
	}
}
