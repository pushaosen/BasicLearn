package �����㷨ˢ��.��ϵ��;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class ��С��k���� {

	/** 
	 * ��Ŀ�������������� arr ���ҳ�������С�� k ������
	 * ���磬����4��5��1��6��2��7��3��8��8�����֣�����С��4��������1��2��3��4��
	 */
	
	/** 
	 * ʾ����
	 *     ���룺arr = [3,2,1], k = 2
	 *     �����[1,2] ���� [2,1]
	 */
	
	/** 
	 * �ⷨһ������ⷨ
	 * ʱ�临�Ӷȣ�O(nlog n)
	 * �ռ临�Ӷȣ�O(nlog n)
	 */
	public int[] getLeastNumbers(int[] arr, int k) {
		int[] vec = new int[k];
		Arrays.sort(arr);
		for(int i = 0; i < k; ++ i) {
			vec[i] = arr[i];
		}
		return vec;
	}
	
	/** 
	 * �ⷨ�����ѽⷨ
	 * ʱ�临�Ӷȣ�O(nlog k)
	 * �ռ临�Ӷȣ�O(k)
	 */
	public int[] getLeastNumbers1(int[] arr, int k) {
		int[] vec = new int[k];
		if(k == 0) {  // �ų� 0 �����
			return vec;
		}
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer num1, Integer num2) {
				return num2 - num1;
			}
		});
		for(int i = 0; i < k; ++ i) {
			queue.offer(arr[i]);
		}
		for(int i = k; i < arr.length; i ++) {
			if(queue.peek() > arr[i]) {
				queue.poll();
				queue.offer(arr[i]);
			}
		}
		for(int i = 0; i < k; ++ i) {
			vec[i] = queue.poll();
		}
		return vec;
	}
	
	/** 
	 * �ⷨ��������˼�� 
	 * ʱ�临�Ӷȣ�����Ϊ��O(n)����������������Ϊ��O(n*n)
	 * �ռ临�Ӷȣ�����Ϊ��O(logn)����������������Ϊ��O(n)
	 */
	public int[] getLeastNumbers2(int[] arr, int k) {
		randomizedSelected(arr, 0, arr.length - 1, k);
		int[] vec = new int[k];
		for(int i = 0; i < k; i ++) {
			vec[i] = arr[i];
		}
		return vec;
	}

	private void randomizedSelected(int[] arr, int l, int r, int k) {
		if(l >= r) {
			return;
		}
		int pos = randomizedPartition(arr, l, r);
		int num = pos - l + 1;
		if(k == num) {
			return;
		}else if(k < num) {
			 randomizedSelected(arr, l, pos - 1, k);
		}else {
			randomizedSelected(arr, pos + 1, r, k - num);
		}
	}

	/** 
	 *  ��������Ļ���
	 */
	private int randomizedPartition(int[] nums, int l, int r) {
		int i = new Random().nextInt(r - l + 1) + l;
		swap(nums, r, i);
        return partition(nums, l, r);
	}

	private int partition(int[] nums, int l, int r) {
		int pivot = nums[r];
		int i = l - 1;
		 for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
