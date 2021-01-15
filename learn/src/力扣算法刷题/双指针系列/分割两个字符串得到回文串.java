package �����㷨ˢ��.˫ָ��ϵ��;

public class �ָ������ַ����õ����Ĵ� {
	
	/** 
	 * ��Ŀ�����������ַ��� a �� b �����ǳ�����ͬ������ѡ��һ���±꣬�������ַ������� ��ͬ
	 *     ���±�ָ������� a ���Եõ������ַ����� aprefix �� asuffix ������ a = aprefix
	 *     + asuffix ��ͬ���� b ���Եõ������ַ��� bprefix �� bsuffix ������ b = bprefix
	 *     + bsuffix �������ж� aprefix + bsuffix ���� bprefix + asuffix �ܷ񹹳ɻ��Ĵ���
	 *     
	 *     ���㽫һ���ַ��� s �ָ�� sprefix �� ssuffix ʱ�� ssuffix ���� sprefix ����Ϊ
	 *     �ա��ȷ�˵�� s = "abc" ��ô "" + "abc" �� "a" + "bc" �� "ab" + "c" �� "abc" + "" ���ǺϷ��ָ
	 *     
	 *     ��� �ܹ��ɻ����ַ��� ����ô�뷵�� true�����򷵻� false ��
	 */
	
	/** 
	 * ʾ����
	 *    ���룺a = "x", b = "y"
	 *    �����true
	 *    ���ͣ���� a ���� b �ǻ��Ĵ�����ô��һ��Ϊ true ����Ϊ��������·ָ
	 *        aprefix = "", asuffix = "x"
	 *        bprefix = "", bsuffix = "y"
	 *        ��ô aprefix + bsuffix = "" + "y" = "y" �ǻ��Ĵ���
	 *        
	 *    ���룺a = "abdef", b = "fecab"
	 *    �����true
	 *    
	 *    ���룺a = "ulacfd", b = "jizalu"
	 *    �����true
	 *    ���ͣ����±�Ϊ 3 ���ָ
	 *        aprefix = "ula", asuffix = "cfd"
	 *        bprefix = "jiz", bsuffix = "alu"
	 *        ��ô aprefix + bsuffix = "ula" + "alu" = "ulaalu" �ǻ��Ĵ���
	 *        
	 *    ���룺a = "xbdef", b = "xecab"
	 *    �����false
	 */
	
	/** 
	 * ���ԣ�
	 */
	public static void main(String[] args) {
		�ָ������ַ����õ����Ĵ� obj = new �ָ������ַ����õ����Ĵ�();
		String a = "x", b = "y";
		System.out.println("˫ָ��Ľⷨ�Ľ��Ϊ��" + obj.checkPalindromeFormation(a, b));
		a = "abdef"; b = "fecab";
		System.out.println("˫ָ��Ľⷨ�Ľ��Ϊ��" + obj.checkPalindromeFormation(a, b));
		a = "ulacfd"; b = "jizalu";
		System.out.println("˫ָ��Ľⷨ�Ľ��Ϊ��" + obj.checkPalindromeFormation(a, b));
		a = "xbdef"; b = "xecab";
		System.out.println("˫ָ��Ľⷨ�Ľ��Ϊ��" + obj.checkPalindromeFormation(a, b));
	}
	
	/** 
	 * �ⷨһ��˫ָ��
	 */
	public boolean checkPalindromeFormation(String a, String b) {
		int len = a.length();
		if(isPalindrome(a, 0, len) || isPalindrome(b, 0 ,len)) {
			return true;
		}
		// ����������
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
