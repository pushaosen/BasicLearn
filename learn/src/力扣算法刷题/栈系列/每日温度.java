package �����㷨ˢ��.ջϵ��;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ÿ���¶� {
	
	/** 
	 * ��Ŀ�������ÿ�� ���� �б���������һ���б�
	 * ��Ӧλ�õ����Ϊ��Ҫ��۲⵽���ߵ����£�������Ҫ�ȴ���������
	 * �����������֮�󶼲������ߣ����ڸ�λ���� 0 �����档
	 * 
	 * ���磺����һ���б� temperatures = [73, 74, 75, 71, 69, 72, 76, 
	 * 73]��������Ӧ���� [1, 1, 4, 2, 1, 1, 0, 0]��
	 */
	
	public static void main(String[] args) {
		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
		int[] result = fun(temperatures);
		int[] dailyTemperaturesResult = dailyTemperatures(temperatures);
		System.out.println("�����ⷨ�Ľ��Ϊ��" + Arrays.asList(result).toString());
		System.out.println("����ջ�ⷨ�Ľ��Ϊ��" + Arrays.asList(dailyTemperaturesResult).toString());
	}

	/** 
	 * �ⷨһ�������ⷨ
	 * ʱ�临�Ӷȣ�O(mn)
	 * �ռ临�Ӷȣ�O(m)
	 */
	public static int[] fun(int[] t) {
		int length = t.length;
		int[] ans = new int[length];
		int[] next =new int[101];
		// �Ȱ�ÿ�������ʼ��Ϊ��Integer�����ֵ
		Arrays.fill(next, Integer.MAX_VALUE);
		for(int i = length - 1; i >= 0; -- i) {
			int warmerIndex  = Integer.MAX_VALUE;
			for(int j = t[i] + 1; j <= 100; ++ j) {
				if(next[j] < warmerIndex) {
					warmerIndex = next[j];
				}
			}
			if(warmerIndex < Integer.MAX_VALUE) {
				ans[i] = warmerIndex - i;
			}
			next[t[i]] = i;
		}
		return ans;
	}
	
	/** 
	 * �ⷨ��������ջ
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 */
	public static int[] dailyTemperatures(int[] t) {
		int length = t.length;
		int[] ans = new int[length];
		Deque<Integer> stack = new LinkedList<Integer>();
		for(int i = 0; i < length; i ++) {
			int temperature = t[i];
			while(!stack.isEmpty() && temperature > t[stack.peek()]) {
				int prevIndex = stack.pop();
				ans[prevIndex] = i - prevIndex;
			}
			stack.push(i);
		}
		return ans;
	}
	
	
}
