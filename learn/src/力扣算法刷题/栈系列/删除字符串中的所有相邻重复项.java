package �����㷨ˢ��.ջϵ��;

import java.util.Stack;

public class ɾ���ַ����е����������ظ��� {

	/** 
	 * ��Ŀ������һ���ַ��� s����k ���ظ���ɾ������������� s ��ѡ�� k ����������ȵ���ĸ����ɾ�����ǣ�ʹ��ɾȥ��
	 * �ַ����������Ҳ�����һ��
	 * ����Ҫ�� s �ظ��������޴�������ɾ��������ֱ���޷�����Ϊֹ��
	 * ��ִ��������ɾ�������󣬷������յõ����ַ�����
	 */
	
	/** 
	 * ʾ����
	 *     ���룺s = "deeedbbcccbdaa", k = 3
	 *     �����"aa"
	 *     ���ͣ�
	 *         ��ɾ�� "eee" �� "ccc"���õ� "ddbbbdaa"
	 *         ��ɾ�� "bbb"���õ� "dddaa"
	 *         ���ɾ�� "ddd"���õ� "aa"
	 */
	
	public static void main(String[] args) {
		String str = "deeedbbcccbdaa";
		int k = 3;
		ɾ���ַ����е����������ظ��� obj = new ɾ���ַ����е����������ظ���();
		System.out.println("�����ⷨ�Ľ��Ϊ��" + obj.removeDuplicates(str, k));
		System.out.println("��������ⷨ�Ľ��Ϊ��" + obj.removeDuplicates1(str, k));
		System.out.println("ջ�ⷨ�Ľ��Ϊ��" + obj.removeDuplicates2(str, k));
		System.out.println("˫ָ��ⷨ�Ľ��Ϊ��" + obj.removeDuplicates3(str, k));
	}
	
	/* 
	 * �ⷨһ�������ⷨ
	 * ʱ�临�Ӷȣ�O(n*n/k),����n���ַ����ĳ���
	 * �ռ临�Ӷȣ�O(1)
	 */
	public String removeDuplicates(String str, int k) {
		StringBuilder sb = new StringBuilder(str);
		int length = -1;
		while(length != sb.length()) {
			length = sb.length();
			for(int i = 0, count = 1; i < sb.length(); ++ i) {
				if(i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
					count = 1;
				}else if(++count == k) {
					sb.delete(i - k + 1, i + 1);
					break;
				}
			}
		}
		return sb.toString();
	}
	
	/** 
	 * �ⷨ�����������
	 * ʱ�临�Ӷȣ�O(n)������n���ַ������ȡ�ÿ���ַ���������һ�Ρ�
	 * �ռ临�Ӷȣ�O(n)���洢ÿ���ַ��ļ�����
	 */
	public String removeDuplicates1(String str, int k) {
		StringBuilder sb = new StringBuilder(str);
		int[] count = new int[sb.length()];
		for(int i = 0; i < sb.length(); ++ i) {
			if(i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
				count[i] = 1;
			}else {
				count[i] = count[i - 1] + 1;
				if(count[i] == k) {
					sb.delete(i - k + 1, i + 1);
					i = i - k;
				}
			}
		}
		return sb.toString();
	}
	
	/** 
	 * �ⷨ����ջ�ⷨ
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 */
	public String removeDuplicates2(String str, int k) {
		StringBuilder sb = new StringBuilder(str);
		Stack<Integer> counts = new Stack<>();
		for(int i = 0; i < sb.length(); ++ i) {
			if(i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
				counts.push(1);
			}else {
				int incremented = counts.pop() + 1;
				if(incremented == k) {
					sb.delete(i - k + 1, i + 1);
					i = i - k;
				}else {
					counts.push(incremented);
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * �ⷨ�ģ�˫ָ��
	 * �뷽������ͬ
	 */
	public String removeDuplicates3(String str, int k) {
		Stack<Integer> counts = new Stack<>();
		char[] sa = str.toCharArray();
		int j = 0;
		for(int i = 0; i < str.length(); ++i, ++j ) {
			sa[j] = sa[i];
			if(j == 0 || sa[j] != sa[j - 1]) {
				counts.push(1);
			}else {
				int incremented = counts.pop() + 1;
				if(incremented == k) {
					j = j - k;
				}else {
					counts.push(incremented);
				}
			}
		}
		return new String(sa, 0, j);
	}
}
