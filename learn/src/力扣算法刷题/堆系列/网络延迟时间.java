package 力扣算法刷题.堆系列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class 网络延迟时间 {

	/** 
	 * 题目：有 N 个网络节点，标记为 1 到 N。
	 *     给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。
	 */
	
	/* 
	 * 示例：
	 *     输入： times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
	 *     输出：2
	 */
	
	public static void main(String[] args) {
		int[][]  times = {{2,1,1},{2,3,1},{3,4,1}};
		int N = 4, K = 2;
		网络延迟时间 obj = new 网络延迟时间();
		System.out.println("深度优先搜索的解法的结果为：" + obj.networkDelayTime(times, N, K));
		System.out.println("堆实现的解法的结果为：" + obj.networkDelayTime1(times, N, K));
	}
	
	/** 
	 * 解法一：深度优先搜索
	 * 时间复杂度：O(N的N次方+ElogE)
	 * 空间复杂度：O(N+E)，图的大小是O(E)加上DFS中隐式调用堆栈的大小O(N)
	 */
	private Map<Integer, Integer> dist;
	public int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for(int[] edge : times) {
			if(!graph.containsKey(edge[0])) {
				graph.put(edge[0], new ArrayList<>());
			}
			int[] temp = {edge[2], edge[1]};
			graph.get(edge[0]).add(temp);
		}
		// 进行排序操作
		for(int node : graph.keySet()) {
			Collections.sort(graph.get(node), (a, b) -> a[0] - b[0]);
		}
		dist = new HashMap<>();
		for(int node = 1; node <= N; ++ node) {
			dist.put(node, Integer.MAX_VALUE);
		}
		dfs(graph, K, 0);
		int ans = 0;
		for(int cand : dist.values()) {
			if(cand == Integer.MAX_VALUE) {
				return -1;
			}
			ans = Math.max(ans, cand);
		}
		return ans;
	}
	private void dfs(Map<Integer, List<int[]>> graph, int node, int elapsed) {
		if(elapsed >= dist.get(node)) {
			return;
		}
		dist.put(node, elapsed);
		if(graph.containsKey(node)) {
			for (int[] info: graph.get(node)) {
				// 进行递归调用
				dfs(graph, info[1], elapsed + info[0]);
			}
		}
	}
	
	/** 
	 * 解法二：堆实现的方式
	 * 时间复杂度：O(ElogE)，E是times的长度
	 * 空间复杂度：O(N+E)，图的大小是O(E)加上其他对象的大小O(N)
	 */
	public int networkDelayTime1(int[][] times, int N, int K) {
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for(int[] edge : times) {
			if(!graph.containsKey(edge[0])) {
				graph.put(edge[0], new ArrayList<>());
			}
			int[] tempObj = {edge[1], edge[2]};
			graph.get(edge[0]).add(tempObj);
		}
		PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (info1, info2) -> info1[0] - info2[0]);
        heap.offer(new int[]{0, K});

        Map<Integer, Integer> dist = new HashMap<>();
        
        while(!heap.isEmpty()) {
        	int[] info = heap.poll();
        	int d = info[0], node = info[1];
        	if(dist.containsKey(node)) {
        		continue;
        	}
        	dist.put(node, d);
        	if(graph.containsKey(node)) {
        		for(int[] edge : graph.get(node)) {
        			int nei = edge[0], d2 = edge[1];
        			if(!dist.containsKey(nei)) {
        				heap.offer(new int[] {d+d2, nei});
        			}
        		}
        	}
        }
        
        if(dist.size() != N) {
        	return -1;
        }
        int ans = 0;
        for(int cand : dist.values()) {
        	ans = Math.max(ans, cand);
        }
        return ans;
	}
}
