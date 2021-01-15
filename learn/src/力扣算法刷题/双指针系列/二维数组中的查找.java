package �����㷨ˢ��.˫ָ��ϵ��;

public class ��ά�����еĲ��� {
	
	/** 
	 * ��Ŀ����һ�� n * m �Ķ�ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
	 *     �����һ����Ч�ĺ���������������һ����ά�����һ���������ж��������Ƿ��и�����
	 */
	
	/** 
	 * ʾ�������о��� matrix ���£�
	 *     [
			  [1,   4,  7, 11, 15],
			  [2,   5,  8, 12, 19],
			  [3,   6,  9, 16, 22],
			  [10, 13, 14, 17, 24],
			  [18, 21, 23, 26, 30]
			]
			
			���� target = 5������true��
			���� target = 20������false��
	 */
	
	
	/** 
	 * �ⷨһ������
	 * ʱ�临�Ӷȣ�O(mn)
	 * �ռ临�Ӷȣ�O(1)
	 */
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int rows = matrix.length, columns = matrix[0].length;
		for(int i = 0; i < rows; i ++) {
			for(int j = 0; j < columns; j ++) {
				if(matrix[i][j] == target) {
					return true;
				}
			}
		}
		return false;
	}
	
	/** 
	 * �ⷨ�������Բ���
	 * ʱ�临�Ӷȣ�O(n+m)�����ʵ����±�����������n�Σ���������m�Σ����ѭ�������ִ��n + m��
	 * �ռ临�Ӷȣ�O(1)
	 */
	public boolean findNumberIn2DArray1(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int rows = matrix.length, columns = matrix[0].length;
		int row = 0, column = columns - 1;
		while(row < rows && column >= 0) {
			int num = matrix[row][column];
			if(num == target) {
				return true;
			}else if(num > target) {
				column --;
			}else {
				row ++;
			}
		}
		return false;
	}

}
