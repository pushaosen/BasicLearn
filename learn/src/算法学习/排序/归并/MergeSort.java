package �㷨ѧϰ.����.�鲢;

import java.util.Arrays;

/**
 * �鲢�㷨�������ǹ鲢�����Ѿ���������顣�鲢������������A��B���������˵�������������C������C��������A��B�����������
 * @author lenovo
 *
 */
public class MergeSort {
	
	/**
	 * �ǵݹ��㷨
	 * @param a   a����
	 * @param b   b����
	 * @return
	 */
	public static int[] sort(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int aNum = 0, bNum = 0, cNum = 0;
		while(aNum < a.length && bNum < b.length) {  // �Ƚ�a�����b�����Ԫ�أ�˭��С��˭��ֵ��c����
			if(a[aNum] >= b[bNum]) {
				c[cNum ++] = b[bNum ++];
			}else {
				c[cNum ++] = a[aNum ++];
			}
		}
		
		// ���a����ȫ����ֵ��c�����ˣ�����b���黹��Ԫ�أ���b����ʣ��Ԫ��ȫ�����Ƶ�c����
		while(aNum == a.length && bNum < b.length) {
			c[cNum ++] = b[bNum ++];
		}
		// ���b����ȫ�����Ƶ�c�����ˣ�����a���黹��Ԫ�أ���a��������Ԫ��ȫ�����Ƶ�c����
		while(bNum == b.length && aNum < a.length) {
			c[cNum ++] = a[aNum ++];
		}
		return c;
	}
	
	// �鲢�����˼���ǣ���һ������ֳ����룬����ÿһ�룬Ȼ���������sort()���������������鲢Ϊһ����������
	
	/**
	 * �ݹ�Ĺ鲢�����㷨
	 * @param c      ��������
	 * @param start  ������ʼ��
	 * @param last   ���������
	 * @return
	 */
	public static int[] mergeSort(int[] c, int start, int last) {
		if(last > start) {
			 //Ҳ������(start+last)/2������д��Ϊ�˷�ֹ���鳤�Ⱥܴ����������ӳ���int��Χ���������
	        int mid = start + (last - start) / 2;
	        mergeSort(c, start, mid);     //�����������
	        mergeSort(c, mid + 1, last);  //�ұ���������
	        merge(c , start, mid, last);  //�ϲ���������
		}
		return c;
	}
	
	/**
	 * �鲢�������ϲ���������
	 * @param c       ������
	 * @param start   ������ʼ��
	 * @param mid     �����м���
	 * @param last    ���������
	 */
	public static void merge(int[] c, int start, int mid, int last) {
		int[] temp = new int[last - start + 1];   // ������ʱ���� 
		int i = start;  // �������������±�
		int j = mid + 1;   // �����ұ�������±�
		int k = 0;
		while(i <= mid && j <= last) {
			if(c[i] < c[j]) {
				temp[k ++] = c[i ++];
			}else {
				temp[k ++] = c[j ++];
			}
		}
		// �����ʣ������Ԫ��������������
		while(i <= mid) {
			temp[k ++] = c[i ++];
		}
		
		//���ұ�ʣ������Ԫ�����뵽��������
	    while(j <= last){
	        temp[k++] = c[j++];
	    }
		
		// ��������������ǵ�c������
		for(int k2 = 0 ; k2 < temp.length ; k2++){
	        c[k2+start] = temp[k2];
	    }
	}
	
	public static void main(String[] args) {
		int[] c = {2,7,8,3,1,6,9,0,5,4};
		c = mergeSort(c,0,c.length-1);
		System.out.println(Arrays.toString(c));
	}

}
