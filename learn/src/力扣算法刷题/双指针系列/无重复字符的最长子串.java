package �����㷨ˢ��.˫ָ��ϵ��;

import java.util.HashSet;
import java.util.Set;

public class ���ظ��ַ�����Ӵ� {
	
	/** 
	 * ��Ŀ������һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
	 */
	
	/** 
	 * ʾ����
	 *    ���룺 
	 *        s = "abcabcbb"
	 *    �����3
	 *    ���ͣ���Ϊ���ظ��ַ�����Ӵ���"abc"�������䳤��Ϊ3��
	 *    
	 *    ���룺s="bbbbb"
	 *    �����1
	 *    ���ͣ���Ϊ���ظ��ַ�����Ӵ���"b"�������䳤��Ϊ1��
	 *    
	 *    ���룺s = "pwwkew"
	 *    �����3
	 *    ���ͣ���Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3��
	 *        ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke" ��һ�������У������Ӵ���
	 *        
	 *    ���룺s = ""
	 *    �����0
	 */
	
	/** 
	 * ���ԣ�
	 */
	public static void main(String[] args) {
		String str = "abcabcbb";
		���ظ��ַ�����Ӵ� obj = new ���ظ��ַ�����Ӵ�();
		System.out.println("�������ڵĽⷨ�Ľ��Ϊ��" + obj.lengthOfLongestSubstring(str));
		str = "bbbbb";
		System.out.println("�������ڵĽⷨ�Ľ��Ϊ��" + obj.lengthOfLongestSubstring(str));
		str = "pwwkew";
		System.out.println("�������ڵĽⷨ�Ľ��Ϊ��" + obj.lengthOfLongestSubstring(str));
		str = "";
		System.out.println("�������ڵĽⷨ�Ľ��Ϊ��" + obj.lengthOfLongestSubstring(str));
	}
	
	/** 
	 * �ⷨһ����������
	 * ʱ�临�Ӷȣ�O(N)������N���ַ����ĳ��ȡ���ָ�����ָ��ֱ����������ַ���һ�Ρ�
	 * �ռ临�Ӷȣ�O(�O���O)�����Ц� ��ʾ�ַ��������ַ����п��Գ��ֵ��ַ������O���O ��ʾ�ַ����Ĵ�С����
	 *         ������û����ȷ˵���ַ�������˿���Ĭ��Ϊ���� ASCII ���� [0,128) �ڵ��ַ����� �O���O=128������
	 *         ��Ҫ�õ���ϣ�������洢���ֹ����ַ������ַ�����ШO���O ������˿ռ临�Ӷ�Ϊ O(�O���O)��
	 */
	public int lengthOfLongestSubstring(String str) {
		// ��ϣ���ϣ���¼ÿ���ַ��Ƿ���ֹ�
		Set<Character> occ = new HashSet<>();
		int n = str.length();
		// ��ָ�룬��ʼֵΪ-1���൱���������ַ�������߽����࣬��û�п�ʼ�ƶ�
		int rk = -1, ans = 0;
		for(int i = 0; i < n; ++ i) {
			if(i != 0) {
				// ��ָ�������ƶ�һ���Ƴ�һ���ַ�
				occ.remove(str.charAt(i - 1));
			}
			while(rk + 1 < n && !occ.contains(str.charAt(rk + 1))) {
				// ���ϵ��ƶ���ָ��
				occ.add(str.charAt(rk + 1));
				++ rk;
			}
			// ��i ��rk���ַ���һ�����������ظ��ַ��Ӵ�
			ans = Math.max(ans, rk - i + 1);
		}
		return ans;
	}

}
