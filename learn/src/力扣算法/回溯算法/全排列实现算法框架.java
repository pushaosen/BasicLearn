package �����㷨.�����㷨;

import java.util.LinkedList;
import java.util.List;

/**
 * ��ܺ��Ĵ���ṹ��
 * for ѡ�� in ѡ���б�
 * 	   # ��ѡ��
 *     ����ѡ���ѡ���б��Ƴ�
 *     ·��.add(ѡ��)
 *     backtrack(·����ѡ���б�)
 *     ·��.remove(ѡ��)
 *     ����ѡ���ڼ���ѡ���б�
 *     
 * ʱ�临�ӶȲ����ܵ���O(N!)����Ϊ��پ��������޷�����ġ���Ҳ�ǻ����㷨��һ���ص㣬����̬�滮
 *             �����ص�����������Ż��������㷨���Ǵ�������٣����Ӷ�һ�㶼�ܸߡ�
 *
 */
public class ȫ����ʵ���㷨��� {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		List<List<Integer>> result = permute(arr);
		System.out.println("���н�����������Ϊ��" + result);
	}

	private static List<List<Integer>> res = new LinkedList<>();
	// ������������һ�鲻�ظ������֣��������ǵ�ȫ����
	static List<List<Integer>> permute(int[] nums){
		// ��¼[·��]
		LinkedList<Integer> track = new LinkedList<>();
		backtrack(nums, track);
		return res;
	}
	
	// ·������¼��track��
	// ѡ���б�nums �в������� track����ЩԪ��
	// ����������nums �е�Ԫ��ȫ����track �г���
	static void backtrack(int[] nums, LinkedList<Integer> track) {
		// ������������
		if(track.size() == nums.length) {
			res.add(new LinkedList<>(track));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			// �ų����Ϸ���ѡ��
			if(track.contains(nums[i])) {
				continue;
			}
			// ��ѡ��
			track.add(nums[i]);
			// ������һ�������
			backtrack(nums, track);
			// ȡ��ѡ��
			track.removeLast();
		}
	}
}

/**
 * ���ˣ����Ǿ�ͨ��ȫ������������˻����㷨�ĵײ�ԭ����Ȼ������㷨���ȫ�������ⲻ�Ǻܸ�Ч����Ϊ������
 * ʹ��contains������ҪO(N)��ʱ�临�Ӷȡ��и��õķ���ͨ������Ԫ�شﵽĿ�ģ����������һЩ������Ͳ�д�ˣ�
 * ����Ȥ������������һ��
 * */
