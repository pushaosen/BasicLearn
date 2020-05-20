package com.learn.com.sort;

public class JBQuikSort {

	/**
	 * 分解子问题 这里用的分冶的思想 直接就是分为左右两边 直到分到只有一个数位置
	 * 
	 * @param array
	 */
	public void sort(Integer[] array, int start, int end) {
		if (start < end) {
			int pos = sort0(array, start, end);// pos的位置 已经是正确的位置 无需在处理
			sort(array, start, pos - 1);
			sort(array, pos + 1, end);
		}
	}

	public int findMiddleData(Integer[] array, int start, int end) {

		int pos = sort0(array, start, end);// pos的位置 已经是正确的位置 无需在处理
		if (pos == ((start + end) / 2)) {
			return pos;
		} else if (pos > ((start + end) / 2)) {
			return findMiddleData(array, pos - 1, end);
		} else {
			return findMiddleData(array, pos + 1, end);
		}
	}

	/**
	 * 子问题求解 假设极端情况 就只剩下三个数 是如何操作的?
	 * 
	 * @param array
	 * @param start
	 * @param end
	 */
	private int sort0(Integer[] array, int start, int end) {
		int standard = array[start];
		while (start < end) {
			while (start < end && array[end] > standard) {
				end--;
			}
			if (start < end) {// 说明右边找到一个比标准大的数，那么就往左边的坑填
				array[start] = array[end];
				start++;
			}
			while (start < end && array[start] < standard) {
				start++;
			}
			if (start < end) {// 说明左边找到了一个大于标准的数 就往右边的坑填
				array[end] = array[start];
				end--;
			}
		}
		array[start] = standard;// start==end 必定跳出循环 此时应该让标准归位到中间的位置
		return start;
	}
}
