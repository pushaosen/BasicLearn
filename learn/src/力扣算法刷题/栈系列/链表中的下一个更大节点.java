package �����㷨ˢ��.ջϵ��;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class �����е���һ������ڵ� {
	
	/** 
	 * ��Ŀ������һ����ͷ�ڵ� head ��Ϊ��һ���ڵ�����������еĽڵ�ֱ���Ϊ��node_1, node_2, node_3, ... ��
	 */

	/** 
	 * �ⷨһ��ʹ�õ���ջ 
	 */
	public static int[] nextLargerNodes(TreeNode head) {
		int index = 0;
		Deque<Integer> stack = new ArrayDeque<>();
		List<Integer> list = new ArrayList<>();
		int[] temp = new int[10000 + 1];
		TreeNode curr = head;
		while(curr != null) {
			while(!stack.isEmpty() && list.get(stack.peek()) < curr.val) {
				temp[stack.peek()] = curr.val;
				stack.poll();
			}
			list.add(curr.val);
			stack.push(index);
			curr = curr.next;
			index ++;
		}
		int[] res = new int[index];
		System.arraycopy(temp, 0, res, 0, index);
		return res;
	}
}
