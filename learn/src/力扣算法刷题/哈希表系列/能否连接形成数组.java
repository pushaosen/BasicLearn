package 力扣算法刷题.哈希表系列;

import java.util.Arrays;

public class 能否连接形成数组 {
	
	/** 
	 * 题目：给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 
	 *     pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。
	 *     但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
	 *     
	 *     如果可以连接pieces中的数组形成 arr，返回true；否则， 返回false
	 */
	
	/** 
	 * 示例：
	 *    输入：arr = [85], pieces = [[85]]
	 *    输出：true
	 *    
	 *    输入：arr = [15,88], pieces = [[88],[15]]
	 *    输出：true
	 *    解释：依次连接 [15] 和 [88]
	 *    
	 *    输入：arr = [49,18,16], pieces = [[16,18,49]]
	 *    输出：false
	 *    解释：即便数字相符，也不能重新排列 pieces[0]
	 *    
	 *    输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
	 *    输出：true
	 *    解释：依次连接 [91]、[4,64] 和 [78]
	 *    
	 *    输入：arr = [1,3,5,7], pieces = [[2,4,6,8]]
	 *    输出：false
	 */
	
	/** 
	 * 测试：
	 */
	public static void main(String[] args) {
		int[] arr = {85};
		int[][] pieces = {{85}};
		能否连接形成数组  obj  = new 能否连接形成数组();
		System.out.println("使用数组的解法的结果为：" + obj.canFormArray(arr, pieces));
	}
	
	/** 
	 * 解法一：使用数组
	 */
	private boolean canFormArray(int[] arr, int[][] pieces) {
		int[] map = new int[101];  // 因为 1 <= arr[i], pieces[i][j] <= 100
		Arrays.fill(map, -1);    // 数组中所有的值初始化为-1，方便后面判断
		for(int i = 0; i < pieces.length; i ++) {
			// 每个pieces的第一个值作为数组map的index，piece在pieces中的index作为数组map对应的值
			map[pieces[i][0]] = i;
		}
		// 注意：for(),这里不要写 i++ 了，也可以改用while循环
		for(int i = 0; i < arr.length;) {
			int pieceIndex = map[arr[i]];
			if(pieceIndex != -1) {
				int[] piece = pieces[pieceIndex];
				i ++;
				// 从1开始遍历，0位置肯定符合，不用比了
				for(int j = 1; j < piece.length; j ++) {
					if(arr[i] != piece[j]) {
						return false;
					}else {
						i ++;
					}
				}
			}else {
				return false;
			}
		}
		return true;
	}

}
