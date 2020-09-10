package 力扣算法.动态规划章节算法思想;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法之区间调度问题之动态规划解法实现
 * 是动态规划的一个特例
 * @author lenovo
 *
 */
public class 贪心算法之区间调度问题之动态规划解法 {

	/**
	 * 贪心算法之区间调度问题的贪心解法
	 * @param intvs
	 * @return
	 */
	@SuppressWarnings("all")
	private static int intervalSchedule(int[][] intvs) {
		if(intvs.length == 0) {
			return 0;
		}
		// 按照end升序排序
		Arrays.sort(intvs, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});
		// 至少有一个区间不相交
		int count = 1;
		// 排序后。第一个区间就是 x
		int x_end = intvs[0][1];
		for(int[] interval : intvs) {
			int start = interval[0];
			if(start >= x_end) {
				// 找到一个选择的区间了
				count ++;
				x_end = interval[1];
			}
		}
		return count;
	}
}
