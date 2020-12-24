package �����㷨ˢ��.��ϵ��;

import java.util.Comparator;
import java.util.PriorityQueue;

public class �ع��ַ��� {

	/* 
	 * ��Ŀ�� ����һ���ַ���S������Ƿ��������Ų����е���ĸ��ʹ�������ڵ��ַ���ͬ��
	 *     ��ͬ�У����������еĽ�����������У����ؿ��ַ�����
	 */
	
	/** 
	 * ʾ����
	 *     ���룺S = "aab"
	 *     �����"aba"
	 *     
	 *     ���룺S = "aaab"
	 *     �����""
	 */
	
	public static void main(String[] args) {
		�ع��ַ��� obj = new �ع��ַ���();
		String str = "aab";
		String str1 = "aaab";
		System.out.println("�������ѵ�̰���㷨�Ľ��Ϊ��" + obj.reorganizeString(str));
		System.out.println("�������ѵ�̰���㷨�Ľ��Ϊ��" + obj.reorganizeString(str1));
		System.out.println("���ڼ�����̰���㷨�Ľ��Ϊ��" + obj.reorganizeString1(str));
		System.out.println("���ڼ�����̰���㷨�Ľ��Ϊ��" + obj.reorganizeString1(str1));
	}
	
	/** 
	 * �ⷨһ���������ѵ�̰���㷨
	 * 
	 */
	public String reorganizeString(String str) {
		if(str.length() < 2) {
			return str;
		}
		int[] counts = new int[26];
		int maxCount = 0;
		int length = str.length();
		for(int i = 0; i < length; i ++) {
			char c = str.charAt(i);
			counts[c - 'a'] ++;
			maxCount = Math.max(maxCount, counts[c - 'a']);
		}
		if(maxCount > (length + 1) / 2) {
			return "";
		}
		// ����һ����������ȶ��У�����
		PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
			public int compare(Character c1, Character c2) {
				return counts[c2 - 'a'] - counts[c1 - 'a'];
			}
		});
		for(char c = 'a'; c <= 'z'; c ++) {
			if(counts[c - 'a'] > 0) {
				queue.offer(c);
			}
		}
		StringBuilder sdf = new StringBuilder();
		while(queue.size() > 1) {
			char c1 = queue.poll();
			char c2 = queue.poll();
			sdf.append(c1);
			sdf.append(c2);
			int index1 = c1 - 'a', index2 = c2 - 'a';
			counts[index1] --;
			counts[index2] --;
			if(counts[index1] > 0) {
				queue.offer(c1);
			}
			if(counts[index2] > 0) {
				queue.offer(c2);
			}
		}
		if(queue.size() > 0) {
			sdf.append(queue.poll());
		}
		return sdf.toString();
	}
	
	/** 
	 * �ⷨ�������ڼ�����̰���㷨
	 */
	public String reorganizeString1(String str) {
		if(str.length() < 2) {
			return str;
		}
		int[] counts = new int[26];
		int maxCount = 0;
		int length = str.length();
		for(int i = 0; i < length; i ++) {
			char c = str.charAt(i);
			counts[c - 'a'] ++;
			maxCount = Math.max(maxCount, counts[c-'a']);
		}
		if(maxCount > (length + 1) / 2) {
			return "";
		}
		char[] reorganizeArray = new char[length];
		int evenIndex = 0, oddIndex = 1;
		int halfLength = length / 2;
		for(int i = 0; i < 26; i ++) {
			char c = (char)('a' + i);
			while(counts[i] > 0 && counts[i] <= halfLength && oddIndex < length) {
				reorganizeArray[oddIndex] = c;
				counts[i] --;
				oddIndex += 2;
			}
			while(counts[i] > 0) {
				reorganizeArray[evenIndex] = c;
				counts[i] -- ;
				evenIndex += 2;
			}
		}
		return new String(reorganizeArray);
	}
}
