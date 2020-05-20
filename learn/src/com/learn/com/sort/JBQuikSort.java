package com.learn.com.sort;

public class JBQuikSort {

	/**
	 * �ֽ������� �����õķ�ұ��˼�� ֱ�Ӿ��Ƿ�Ϊ�������� ֱ���ֵ�ֻ��һ����λ��
	 * 
	 * @param array
	 */
	public void sort(Integer[] array, int start, int end) {
		if (start < end) {
			int pos = sort0(array, start, end);// pos��λ�� �Ѿ�����ȷ��λ�� �����ڴ���
			sort(array, start, pos - 1);
			sort(array, pos + 1, end);
		}
	}

	public int findMiddleData(Integer[] array, int start, int end) {

		int pos = sort0(array, start, end);// pos��λ�� �Ѿ�����ȷ��λ�� �����ڴ���
		if (pos == ((start + end) / 2)) {
			return pos;
		} else if (pos > ((start + end) / 2)) {
			return findMiddleData(array, pos - 1, end);
		} else {
			return findMiddleData(array, pos + 1, end);
		}
	}

	/**
	 * ��������� ���輫����� ��ֻʣ�������� ����β�����?
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
			if (start < end) {// ˵���ұ��ҵ�һ���ȱ�׼���������ô������ߵĿ���
				array[start] = array[end];
				start++;
			}
			while (start < end && array[start] < standard) {
				start++;
			}
			if (start < end) {// ˵������ҵ���һ�����ڱ�׼���� �����ұߵĿ���
				array[end] = array[start];
				end--;
			}
		}
		array[start] = standard;// start==end �ض�����ѭ�� ��ʱӦ���ñ�׼��λ���м��λ��
		return start;
	}
}
