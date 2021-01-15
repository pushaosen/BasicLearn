package 力扣算法刷题.双指针系列;

public class 排序矩阵查找 {
	
	/** 
	 * 题目：给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
	 */
	
	/** 
	 * 示例：
	 *    现有矩阵 matrix 如下：
	 *      [
			  [1,   4,  7, 11, 15],
			  [2,   5,  8, 12, 19],
			  [3,   6,  9, 16, 22],
			  [10, 13, 14, 17, 24],
			  [18, 21, 23, 26, 30]
			]
			
		  给定 target = 5，返回true。
		 给定 target = 20，返回false
	 */
	
	/** 
	 * 解法一：双指针，排序矩阵查找
	 * 解题思路：
	 *       1、从右上角(第一行最后一列)开始遍历
	 *       2、若该点小于target，则行加一
	 *       3、若该点大于target，则列加一
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int M = matrix.length - 1;
		int N = matrix[0].length - 1;
		int i = 0, j = N;    // 右上角开始轮询
		
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
	 * 解法二：排序矩阵查找
	 * 解题思路：每一行、每一列都按升序排列，所以可从右上角开始遍历，大于目标数，前移一列，小于目标值，下移一行，
	 *       直到找到或者遍历完所有的元素结束。
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
