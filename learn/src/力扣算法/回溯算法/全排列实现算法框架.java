package 力扣算法.回溯算法;

import java.util.LinkedList;
import java.util.List;

/**
 * 框架核心代码结构：
 * for 选择 in 选择列表
 * 	   # 做选择
 *     将该选择从选择列表移除
 *     路径.add(选择)
 *     backtrack(路径，选择列表)
 *     路径.remove(选择)
 *     将该选择在加入选择列表
 *     
 * 时间复杂度不可能低于O(N!)，因为穷举决策树是无法避免的。这也是回溯算法的一个特点，不像动态规划
 *             存在重叠子问题可以优化，回溯算法就是纯暴力穷举，复杂度一般都很高。
 *
 */
public class 全排列实现算法框架 {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		List<List<Integer>> result = permute(arr);
		System.out.println("运行结果的排列组合为：" + result);
	}

	private static List<List<Integer>> res = new LinkedList<>();
	// 主函数，输入一组不重复的数字，返回它们的全排列
	static List<List<Integer>> permute(int[] nums){
		// 记录[路径]
		LinkedList<Integer> track = new LinkedList<>();
		backtrack(nums, track);
		return res;
	}
	
	// 路径：记录在track中
	// 选择列表：nums 中不存在于 track的那些元素
	// 结束条件：nums 中的元素全都在track 中出现
	static void backtrack(int[] nums, LinkedList<Integer> track) {
		// 触发结束条件
		if(track.size() == nums.length) {
			res.add(new LinkedList<>(track));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			// 排除不合法的选择
			if(track.contains(nums[i])) {
				continue;
			}
			// 做选择
			track.add(nums[i]);
			// 进入下一层决策树
			backtrack(nums, track);
			// 取消选择
			track.removeLast();
		}
	}
}

/**
 * 至此，我们就通过全排列问题详解了回溯算法的底层原理。当然，这个算法解决全排列问题不是很高效，因为对链表
 * 使用contains方法需要O(N)的时间复杂度。有更好的方法通过交换元素达到目的，但是难理解一些，这里就不写了，
 * 有兴趣可以自行搜索一下
 * */
