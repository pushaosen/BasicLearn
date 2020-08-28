package 力扣算法.Stack类;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * 时间复杂度：O(2^n \cdot n)O(2 
n
 ⋅n)。仍然需要对子序列做二进制枚举，枚举出的序列虽然省去了判断合法性和哈希的过程，但是仍然需要 O(n)O(n) 的时间添加到答案中。
空间复杂度：O(n)O(n)。这里临时数组的空间代价是 O(n)O(n)，递归使用的栈空间的空间代价也是 O(n)O(n)。

 * @author lenovo
 *
 */
public class 递增子序列 {
	
	public static void main(String[] args) {
		int[] arr = {4, 6, 7, 7};
		List<List<Integer>> list = new 递增子序列().findSubsequences(arr);
		System.out.println(list);
	}

    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }

}
