package �����㷨ˢ��.��ϵ��;

import java.util.Arrays;

public class Kվ��ת������˵ĺ��� {

	/**
	 * ��Ŀ���� n ������ͨ�� m ���������ӡ�ÿ�����඼�ӳ��� u ��ʼ���Լ۸� w �ִ� v��
	 *     ���ڸ������еĳ��кͺ��࣬�Լ��������� src ��Ŀ�ĵ� dst�������
	 *     �����ҵ��� src �� dst ��ྭ�� k վ��ת������˵ļ۸� ���û��
	 *     ������·�ߣ������ -1��
	 */
	
	/** 
	 * ʾ����
	 *     ���룺n = 3,edges = [[0,1,100],[1,2,100],[0,2,500]]
	 *         src = 0, dst = 2, k = 1
	 *     �����200
	 */ 
	
	public static void main(String[] args) {
		int n = 3;
		int[][] edges = {{0,1,100}, {1,2,100}, {0,2,500}};
		int src = 0;
		int dst = 2;
		int k = 1;
		Kվ��ת������˵ĺ��� obj = new Kվ��ת������˵ĺ���();
		System.out.println("���㵽���ڵ����̾���ⷨ�Ľ��Ϊ��" + obj.findCheapestPrice(n, edges, src, dst, k));
	}
	
	/** 
	 * �ⷨһ�����㵽���ڵ����̾��롾ͨ����
	 * ʱ�临�Ӷȣ�O(E*K)������E��flights�ĳ���
	 * �ռ临�Ӷȣ�O(n)���洢 dis �� pre
	 */
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		int[][] dist = new int[2][n];
		int INF = Integer.MAX_VALUE / 2;
		Arrays.fill(dist[0], INF);
		Arrays.fill(dist[1], INF);
		dist[0][src] = dist[1][src] = 0;
		
		for(int i = 0; i <= K; ++ i) {
			for(int[] edge : flights) {
				dist[i&1][edge[1]] = Math.min(dist[i&1][edge[1]], 
						dist[i&1][edge[0]] + edge[2]);
			}
		}
		
		return dist[K&1][dst] < INF ? dist[K&1][dst] : -1;
	}
}
