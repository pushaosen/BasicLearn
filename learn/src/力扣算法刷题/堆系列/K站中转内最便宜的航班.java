package 力扣算法刷题.堆系列;

import java.util.Arrays;

public class K站中转内最便宜的航班 {

	/**
	 * 题目：有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
	 *     现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任
	 *     务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有
	 *     这样的路线，则输出 -1。
	 */
	
	/** 
	 * 示例：
	 *     输入：n = 3,edges = [[0,1,100],[1,2,100],[0,2,500]]
	 *         src = 0, dst = 2, k = 1
	 *     输出：200
	 */ 
	
	public static void main(String[] args) {
		int n = 3;
		int[][] edges = {{0,1,100}, {1,2,100}, {0,2,500}};
		int src = 0;
		int dst = 2;
		int k = 1;
		K站中转内最便宜的航班 obj = new K站中转内最便宜的航班();
		System.out.println("计算到各节点的最短距离解法的结果为：" + obj.findCheapestPrice(n, edges, src, dst, k));
	}
	
	/** 
	 * 解法一：计算到各节点的最短距离【通过】
	 * 时间复杂度：O(E*K)，其中E是flights的长度
	 * 空间复杂度：O(n)，存储 dis 和 pre
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
