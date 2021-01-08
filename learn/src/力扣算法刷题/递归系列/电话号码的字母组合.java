package 力扣算法刷题.递归系列;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合 {
	/** 
	 * 题目：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
	 *     给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
	 */
	
	/** 
	 * 示例：
	 *     输入："23"
	 *     输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
	 */
	
	/** 
	 * 测试
	 */
	public static void main(String[] args) {
		电话号码的字母组合 obj = new 电话号码的字母组合();
		String inputStr = "23";
		List<String> result = obj.letterCombinations(inputStr);
		System.out.println("回溯解法的结果为：" + result);
		result = obj.letterCombinations1(inputStr);
		System.out.println("队列解法的结果为：" + result);
	}
	
	/** 
	 * 解法一：回溯：类似于一个枚举的搜索尝试过程，主要是在搜索过程中寻找问题的解，当发现已不满足条件时，就“回溯”返回，尝试别的路径
	 *          回溯法是一种选优搜索法，按选优条件向前搜索，以达到目标。但当搜索到某一步时，发现原先选择并不优或达不到目标，就退回一步
	 *          重新选择，这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为"回溯点"。
	 * 解题思路：
	 *       首先使用哈希表存储每个数字对应的所有可能的字母，然后进行回溯操作
	 */
	public List<String> letterCombinations(String digits){
		List<String> combinations = new ArrayList<>();
		if(digits.length() == 0) {
			return combinations;
		}
		// 进行初始化数据，也就是准备数据
		Map<Character, String> phoneMap = new HashMap<Character, String>(){
			private static final long serialVersionUID = 1L;
		{
			put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
		}};
		// 调用具体的方法进行数据处理
		backtrack(combinations, phoneMap, digits, 0, new StringBuilder());
		return combinations;
	}
	// 具体的回溯回调方法
	private void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index,
			StringBuilder combination) {
		if(index == digits.length()) {
			// 递归结束的点
			combinations.add(combination.toString());
		}else {
			char digit = digits.charAt(index);
			String letters = phoneMap.get(digit);
			int lettersCount = letters.length();
			for(int i = 0; i < lettersCount; i ++) {
				combination.append(letters.charAt(i));
				// 递归
				backtrack(combinations, phoneMap, digits, index + 1, combination);
				combination.deleteCharAt(index);
			}
		}
	}
	
	/** 
	 * 解法二：队列法
	 * 解题思路：我们可以利用队列的先进先出特点，再配合循环完成题目要求
	 *        我们先将2对应的字符"a"，"b"，"c"依次放入队列中
	 *        之后再从队列中拿出第一个元素"a"，跟3对应的字符"d"，"e"，"f"挨个拼接
	 */
	public List<String> letterCombinations1(String digits) {
		List<String> res = new ArrayList<>();
		if(digits == null || digits.length() == 0) {
			return res;
		}
		// 一个映射表，第二个位置是"abc"，第三个位置是"def"
		// 这里也可以用map，用数组可以更节省点内存
		String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		// 先往队列中添加一个空字符串，进行站位
		res.add("");
		for(int i = 0; i < digits.length(); i ++) {
			// 由当前遍历到的字符，取字典表中查找对应的字符串
			String letters = letter_map[digits.charAt(i)-'0'];
			int size = res.size();
			// 计算出队列长度后，将队列中的每个元素挨个拿出来
			for(int j = 0; j < size; j ++) {
				// 每次都从队列中拿出第一个元素
				String tmp = res.remove(0);
				// 然后跟"def"这样的字符串拼接，并再次放到队列中
				for(int k = 0; k < letters.length(); k ++) {
					res.add(tmp + letters.charAt(k));
				}
			}
		}
		return res;
	}
}
