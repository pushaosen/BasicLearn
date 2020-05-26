package �㷨ѧϰ.����.�ݹ�;

/**
 * ���ֲ��һ����ࣺǰ���������Ѿ�����
 * 
 * �ݹ�Ķ��壺1���߽�����
 * 		   2���ݹ�ǰ����
 *         3���ݹ鷵�ض�
 * @author lenovo
 *
 */
public class BinarySearch {
	
	/**
	 * ���õݹ�Ķ��ֲ��ң���ʹ����ͨ��ѭ������(ʱ�临�Ӷ�Ϊ��O(logN))
	 * @param array   �Ѿ��ź��������
	 * @param key     ��Ҫ���ҵ�ֵkey
	 * @return
	 */
	public static int findTwoPoint(int[] array, int key) {
		int start = 0;
		int last = array.length;
		while(start <= last) {   // ʹ��ѭ������ݹ�
			int mid = (last - start) / 2 + start;   // ��ʼ������м�ֵ
			if(key == array[mid]) {        // ����ֵ�뵱ǰֵһ����
				return mid;
			}else if(key > array[mid]) {   // ����ֵ�ȵ�ǰֵ��
				start = mid + 1;
			}else if(key < array[mid]) {   // ����ֵ�ȵ�ǰֵС
				last = mid - 1;
			}
		}
		return -1;
	}
	
	/**
	 * ʹ�õݹ���ж��ֲ��ң�ʱ�临�Ӷ�Ϊ��O(logN)   �õݹ����Ҳ��һ�����͵ķ����㷨������
	 * @param array   ����
	 * @param key     ��Ҫ���ҵ�ֵ
	 * @param low     �����������Сֵ
	 * @param high    ������������ֵ
	 * @return
	 */
	public static int search(int[] array, int key, int low, int high) {
		int mid = (high - low) / 2 + low;
		if(key == array[mid]) {   // ����ֵ�뵱ǰֵ���
			return mid;
		}else if(low > high) {    // �Ҳ�������ֵ������-1
 			return -1;
		}else {
			if(key < array[mid]) {    // ����ֵ�ȵ�ǰֵС
				return search(array, key, low, high - 1);    // �ݹ����
			}else if(key > array[mid]) {  // ����ֵ�ȵ�ǰֵ��
				return search(array, key, low + 1, high);    // �ݹ����
			}
		}
		return -1;
	}
	
	/**
	 * ��ŵ������
	 * @param dish    ���Ӹ���(Ҳ��ʾ����)
	 * @param from    ��ʼ����
	 * @param temp    �н�����
	 * @param to      Ŀ������
	 */
	public static void move(int dish, String from, String temp, String to) {
		if(dish == 1) {
			System.out.println("������"+dish+"������"+from+"�ƶ���Ŀ������"+to);
		}else {
			move(dish-1,from,to,temp);//AΪ��ʼ������BΪĿ��������CΪ�н�����
	        System.out.println("������"+dish+"������"+from+"�ƶ���Ŀ������"+to);
	        move(dish-1,temp,from,to);//BΪ��ʼ������CΪĿ��������AΪ�н�����
		}
	}
	
	public static void main(String[] args) {
		// ���Ժ�ŵ������
		move(3,"A","B","C");
	}

}
