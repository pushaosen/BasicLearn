package �����㷨ˢ��.��ϣ��ϵ��;

import java.util.HashSet;
import java.util.Set;

public class �������� {
	
	/** 
	 * ��Ŀ������һ���ַ�������дһ�������ж����Ƿ�Ϊĳ�����Ĵ�������֮һ��
	 *     ���Ĵ���ָ������������һ���ĵ��ʻ���������ָ��ĸ���������С�
	 *     ���Ĵ���һ�����ֵ䵱�еĵ��ʡ�
	 */
	
	/** 
	 * ʾ����
	 *    ���룺"tactcoa"
	 *    �����true��������"tacocat"��"atcocta"���ȵȣ�
	 */
	
	/** 
	 * ����
	 */
	public static void main(String[] args) {
		String s = "tactcoa";
		�������� obj = new ��������();
		System.out.println("��ϣ��Ľⷨ�Ľ��Ϊ��" + obj.canPermutePalindrome(s));
	}
	
	/** 
	 * �ⷨһ����ϣ��
	 */
	public boolean canPermutePalindrome(String s) {
		Set<Character> set = new HashSet<>();
		for(char c : s.toCharArray()) {
			if(!set.add(c)) {
				set.remove(c);
			}
		}
		return set.size() <= 1;
	}
	
	/** 
	 * �ⷨ����������ʵ��
	 */
	public boolean canPermutePalindrome2(String s) {
		int[] map = new int[256];
		int count = 0;
		for(char c : s.toCharArray()) {
			if((map[c]++ & 1) == 1) {
				count --;
			}else {
				count ++;
			}
		}
		return count <= 1;
	}

}
