package �����㷨ˢ��.�ݹ�ϵ��;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class �绰�������ĸ��� {
	/** 
	 * ��Ŀ������һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�
	 *     �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
	 */
	
	/** 
	 * ʾ����
	 *     ���룺"23"
	 *     �����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
	 */
	
	/** 
	 * ����
	 */
	public static void main(String[] args) {
		�绰�������ĸ��� obj = new �绰�������ĸ���();
		String inputStr = "23";
		List<String> result = obj.letterCombinations(inputStr);
		System.out.println("���ݽⷨ�Ľ��Ϊ��" + result);
		result = obj.letterCombinations1(inputStr);
		System.out.println("���нⷨ�Ľ��Ϊ��" + result);
	}
	
	/** 
	 * �ⷨһ�����ݣ�������һ��ö�ٵ��������Թ��̣���Ҫ��������������Ѱ������Ľ⣬�������Ѳ���������ʱ���͡����ݡ����أ����Ա��·��
	 *          ���ݷ���һ��ѡ������������ѡ��������ǰ�������ԴﵽĿ�ꡣ����������ĳһ��ʱ������ԭ��ѡ�񲢲��Ż�ﲻ��Ŀ�꣬���˻�һ��
	 *          ����ѡ�������߲�ͨ���˻����ߵļ���Ϊ���ݷ������������������ĳ��״̬�ĵ��Ϊ"���ݵ�"��
	 * ����˼·��
	 *       ����ʹ�ù�ϣ��洢ÿ�����ֶ�Ӧ�����п��ܵ���ĸ��Ȼ����л��ݲ���
	 */
	public List<String> letterCombinations(String digits){
		List<String> combinations = new ArrayList<>();
		if(digits.length() == 0) {
			return combinations;
		}
		// ���г�ʼ�����ݣ�Ҳ����׼������
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
		// ���þ���ķ����������ݴ���
		backtrack(combinations, phoneMap, digits, 0, new StringBuilder());
		return combinations;
	}
	// ����Ļ��ݻص�����
	private void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index,
			StringBuilder combination) {
		if(index == digits.length()) {
			// �ݹ�����ĵ�
			combinations.add(combination.toString());
		}else {
			char digit = digits.charAt(index);
			String letters = phoneMap.get(digit);
			int lettersCount = letters.length();
			for(int i = 0; i < lettersCount; i ++) {
				combination.append(letters.charAt(i));
				// �ݹ�
				backtrack(combinations, phoneMap, digits, index + 1, combination);
				combination.deleteCharAt(index);
			}
		}
	}
	
	/** 
	 * �ⷨ�������з�
	 * ����˼·�����ǿ������ö��е��Ƚ��ȳ��ص㣬�����ѭ�������ĿҪ��
	 *        �����Ƚ�2��Ӧ���ַ�"a"��"b"��"c"���η��������
	 *        ֮���ٴӶ������ó���һ��Ԫ��"a"����3��Ӧ���ַ�"d"��"e"��"f"����ƴ��
	 */
	public List<String> letterCombinations1(String digits) {
		List<String> res = new ArrayList<>();
		if(digits == null || digits.length() == 0) {
			return res;
		}
		// һ��ӳ����ڶ���λ����"abc"��������λ����"def"
		// ����Ҳ������map����������Ը���ʡ���ڴ�
		String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		// �������������һ�����ַ���������վλ
		res.add("");
		for(int i = 0; i < digits.length(); i ++) {
			// �ɵ�ǰ���������ַ���ȡ�ֵ���в��Ҷ�Ӧ���ַ���
			String letters = letter_map[digits.charAt(i)-'0'];
			int size = res.size();
			// ��������г��Ⱥ󣬽������е�ÿ��Ԫ�ذ����ó���
			for(int j = 0; j < size; j ++) {
				// ÿ�ζ��Ӷ������ó���һ��Ԫ��
				String tmp = res.remove(0);
				// Ȼ���"def"�������ַ���ƴ�ӣ����ٴηŵ�������
				for(int k = 0; k < letters.length(); k ++) {
					res.add(tmp + letters.charAt(k));
				}
			}
		}
		return res;
	}
}
