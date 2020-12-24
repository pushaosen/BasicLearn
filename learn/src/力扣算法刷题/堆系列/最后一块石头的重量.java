package �����㷨ˢ��.��ϵ��;

import java.util.PriorityQueue;

public class ���һ��ʯͷ������ {

	/** 
	 * ��Ŀ����һ��ʯͷ��ÿ��ʯͷ������������������
	 *     ÿһ�غϣ�����ѡ������ ���ص� ʯͷ��Ȼ������һ����顣����ʯͷ��
	 *     �����ֱ�Ϊ x �� y���� x <= y����ô����Ŀ��ܽ�����£�
	 *        ��� x == y����ô����ʯͷ���ᱻ��ȫ���飻
	 *        ��� x != y����ô����Ϊ x ��ʯͷ������ȫ���飬������Ϊ y ��ʯͷ������Ϊ y-x
	 *     ������ֻ��ʣ��һ��ʯͷ�����ش�ʯͷ�����������û��ʯͷʣ�£��ͷ���0��
	 */
	
	/** 
	 * ʾ����
	 *     ���룺[2,7,4,1,8,1]
	 *     �����1
	 *     ���ͣ�
	 *         ��ѡ��7��8���õ�1����������ת��Ϊ��[2,4,1,1,1]��
	 *         ��ѡ��2��4���õ�2����������ת��Ϊ��[2,1,1,1]��
	 *         ������2��1���õ�1����������ת��Ϊ��[1,1,1]��
	 *         ���ѡ��1��1���õ�0����������ת��Ϊ��[1]����������ʣ�µ��ǿ�ʯͷ��������
	 */
	
	public static void main(String[] args) {
		���һ��ʯͷ������ obj = new ���һ��ʯͷ������();
		int[] stones = {2,7,4,1,8,1};
		System.out.println("ʹ�����ȶ��нⷨ�Ľ��Ϊ��" + obj.lastStoneWeight(stones));
	}
	
	/** 
	 * �ⷨһ��ʹ�����ȶ���
	 * ������������Ҫ��̬ά�������������(֧�����ӡ�ɾ��)������ʹ�����ȶ���������ʵ����ݽṹ��
	 * ʱ�临�Ӷȣ�O(NlogN)
	 * �ռ临�Ӷȣ�O(N)�����ȶ��еĴ�С
	 */
	public int lastStoneWeight(int[] stones) {
		int len = stones.length;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (o1, o2) -> -o1 + o2);;
		// �Ȱ�����ʯͷ�Ž����ȶ�����
		for(int stone : stones) {
			maxHeap.add(stone);
		}
		
		while(maxHeap.size() > 2) {
			Integer head1 = maxHeap.poll();
			Integer head2 = maxHeap.poll();
			if(head1.equals(head2)) {
				continue;
			}
			maxHeap.offer(head1 - head2);
		}
		
		if(maxHeap.isEmpty()) {
			return 0;
		}
		return maxHeap.poll();
	}
}
