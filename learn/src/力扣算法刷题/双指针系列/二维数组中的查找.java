package 力扣算法刷题.双指针系列;

public class 二维数组中的查找 {
	
	/** 
	 * 题目：在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
	 *     请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
	 */
	
	/** 
	 * 示例：现有矩阵 matrix 如下：
	 *     [
			  [1,   4,  7, 11, 15],
			  [2,   5,  8, 12, 19],
			  [3,   6,  9, 16, 22],
			  [10, 13, 14, 17, 24],
			  [18, 21, 23, 26, 30]
			]
			
			给定 target = 5，返回true。
			给定 target = 20，返回false。
	 */
	
	
	/** 
	 * 解法一：暴力
	 * 时间复杂度：O(mn)
	 * 空间复杂度：O(1)
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
	 * 解法二：线性查找
	 * 时间复杂度：O(n+m)，访问到的下标的行最多增加n次，列最多减少m次，因此循环体最多执行n + m次
	 * 空间复杂度：O(1)
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
