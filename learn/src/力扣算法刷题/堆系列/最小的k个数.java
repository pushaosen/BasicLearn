package 力扣算法刷题.堆系列;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class 最小的k个数 {

	/** 
	 * 题目：输入整数数组 arr ，找出其中最小的 k 个数。
	 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
	 */
	
	/** 
	 * 示例：
	 *     输入：arr = [3,2,1], k = 2
	 *     输出：[1,2] 或者 [2,1]
	 */
	
	/** 
	 * 解法一：排序解法
	 * 时间复杂度：O(nlog n)
	 * 空间复杂度：O(nlog n)
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
	 * 解法二：堆解法
	 * 时间复杂度：O(nlog k)
	 * 空间复杂度：O(k)
	 */
	public int[] getLeastNumbers1(int[] arr, int k) {
		int[] vec = new int[k];
		if(k == 0) {  // 排除 0 的情况
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
	 * 解法三：快排思想 
	 * 时间复杂度：期望为：O(n)，但是在最坏的情况下为：O(n*n)
	 * 空间复杂度：期望为：O(logn)，但是在最坏的情况下为：O(n)
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
	 *  基于随机的划分
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
