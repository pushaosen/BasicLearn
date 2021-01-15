package 力扣算法刷题.双指针系列;

public class 分割两个字符串得到回文串 {
	
	/** 
	 * 题目：给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同
	 *     的下标分隔开，由 a 可以得到两个字符串： aprefix 和 asuffix ，满足 a = aprefix
	 *     + asuffix ，同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b = bprefix
	 *     + bsuffix 。请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。
	 *     
	 *     当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为
	 *     空。比方说， s = "abc" 那么 "" + "abc" ， "a" + "bc" ， "ab" + "c" 和 "abc" + "" 都是合法分割。
	 *     
	 *     如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。
	 */
	
	/** 
	 * 示例：
	 *    输入：a = "x", b = "y"
	 *    输出：true
	 *    解释：如果 a 或者 b 是回文串，那么答案一定为 true ，因为你可以如下分割：
	 *        aprefix = "", asuffix = "x"
	 *        bprefix = "", bsuffix = "y"
	 *        那么 aprefix + bsuffix = "" + "y" = "y" 是回文串。
	 *        
	 *    输入：a = "abdef", b = "fecab"
	 *    输出：true
	 *    
	 *    输入：a = "ulacfd", b = "jizalu"
	 *    输出：true
	 *    解释：在下标为 3 处分割：
	 *        aprefix = "ula", asuffix = "cfd"
	 *        bprefix = "jiz", bsuffix = "alu"
	 *        那么 aprefix + bsuffix = "ula" + "alu" = "ulaalu" 是回文串。
	 *        
	 *    输入：a = "xbdef", b = "xecab"
	 *    输出：false
	 */
	
	/** 
	 * 测试：
	 */
	public static void main(String[] args) {
		分割两个字符串得到回文串 obj = new 分割两个字符串得到回文串();
		String a = "x", b = "y";
		System.out.println("双指针的解法的结果为：" + obj.checkPalindromeFormation(a, b));
		a = "abdef"; b = "fecab";
		System.out.println("双指针的解法的结果为：" + obj.checkPalindromeFormation(a, b));
		a = "ulacfd"; b = "jizalu";
		System.out.println("双指针的解法的结果为：" + obj.checkPalindromeFormation(a, b));
		a = "xbdef"; b = "xecab";
		System.out.println("双指针的解法的结果为：" + obj.checkPalindromeFormation(a, b));
	}
	
	/** 
	 * 解法一：双指针
	 */
	public boolean checkPalindromeFormation(String a, String b) {
		int len = a.length();
		if(isPalindrome(a, 0, len) || isPalindrome(b, 0 ,len)) {
			return true;
		}
		// 继续往下走
		//prefixA + suffixB
		int index = 0;
		while(a.charAt(index) == b.charAt(len - 1 - index)) {
			index ++;
		}
		if (isPalindrome(a, index, len - index) || isPalindrome(b, index, len - index)) {
			return true;
		}
		//prefixB + suffixA
		index = 0;
		while (a.charAt(len - 1 - index) == b.charAt(index)) {
			index ++;
		}
		if (isPalindrome(b, index, len - index) || isPalindrome(a, index, len - index)) {
			return true;
		}
		return false;
	}
	private boolean isPalindrome(String str, int low, int high) {
		//high is not contained
		int time = ((high - low) >> 1);
		for(int i = 0; i < time; i ++) {
			if(str.charAt(low + i) != str.charAt(high - 1 - i)) {
				return false;
			}
		}
		return true;
	}

}
