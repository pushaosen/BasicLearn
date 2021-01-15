package �����㷨ˢ��.˫ָ��ϵ��;

public class ���������� {
	
	/** 
	 * ��Ŀ������M��N����ÿһ�С�ÿһ�ж����������У����д�����ҳ�ĳԪ�ء�
	 */
	
	/** 
	 * ʾ����
	 *    ���о��� matrix ���£�
	 *      [
			  [1,   4,  7, 11, 15],
			  [2,   5,  8, 12, 19],
			  [3,   6,  9, 16, 22],
			  [10, 13, 14, 17, 24],
			  [18, 21, 23, 26, 30]
			]
			
		  ���� target = 5������true��
		 ���� target = 20������false
	 */
	
	/** 
	 * �ⷨһ��˫ָ�룬����������
	 * ����˼·��
	 *       1�������Ͻ�(��һ�����һ��)��ʼ����
	 *       2�����õ�С��target�����м�һ
	 *       3�����õ����target�����м�һ
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int M = matrix.length - 1;
		int N = matrix[0].length - 1;
		int i = 0, j = N;    // ���Ͻǿ�ʼ��ѯ
		
		while(i <= M && j >= 0) {
			if(matrix[i][j] == target) {
				return true;
			}else if(matrix[i][j] < target) {
				i ++;
			}else {
				j --;
			}
		}
		return false;
	}
	
	/** 
	 * �ⷨ��������������
	 * ����˼·��ÿһ�С�ÿһ�ж����������У����Կɴ����Ͻǿ�ʼ����������Ŀ������ǰ��һ�У�С��Ŀ��ֵ������һ�У�
	 *       ֱ���ҵ����߱��������е�Ԫ�ؽ�����
	 */
	public boolean searchMatrix1(int[][] matrix, int target) {
		if(matrix.length == 0) {
			return false;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int i = 0, j = cols - 1;
		while(i >= 0 && i < rows && j >= 0 && j < cols) {
			if(matrix[i][j] == target) {
				return true;
			}else if(matrix[i][j] < target) {
				++ i;
			}else {
				-- j;
			}
		}
		return false;
	}
}
