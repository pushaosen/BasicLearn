package 算法学习.图;

/**
 * 图的广度优先搜索和深度优先搜索实现：使用的数组实现
 * @author lenovo
 *
 */
public class Graph {
	
	private final int MAX_VERTS = 20;
	private Vertex[] vertexList;  // 顶点数组
	private int[][] adjMat;   // 邻接矩阵
	private int nVerts;    // 当前顶点总数
	private StackX theStack;    // 深度优先搜索使用到的栈
	private QueueQ theQueue;    // 广度搜索使用到的队列
	
	// 构造图
	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int i = 0; i < MAX_VERTS; i ++) {
			for(int j = 0; j < MAX_VERTS; j ++) {
				adjMat[i][j] = 0;
			}
		}
		theStack = new StackX();
		theQueue = new QueueQ();
	}
	
	// 添加顶点
	public void addVertex(char label) {
		vertexList[nVerts ++] = new Vertex(label);
	}
	
	// 添加边
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	// 打印数组中v位置下的顶点名
	public void displayVertex(int v) {
		System.out.println(vertexList[v].lable);
	}
	
	// 获取和v邻接的未访问的顶点
	public int getAdjUnvisitedVertex(int v) {
		// 循环遍历寻找，找到后，直接返回索引，未找到则返回-1(表示未找到)
		for(int i = 0; i < nVerts; i ++) {
			if(adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
				return i;
			}
		}
		return -1;
	}
	
	// 深度优先搜索
	public void dfs() {
		vertexList[0].wasVisited = true;
		displayVertex(0);
		theStack.push(0);
		
		while(!theStack.isEmpty()) {
			int v = getAdjUnvisitedVertex(theStack.peek());
			if(v == -1) {
				theStack.pop();
			}else {
				vertexList[v].wasVisited = true;
				displayVertex(v);
				theStack.push(v);
			}
		}
		
		for(int i = 0; i < nVerts; i ++) {
			vertexList[i].wasVisited = false;  // 重置，防止后边的再次使用dfs
		}
	}
	
	// 广度优先搜索
	public void bfs() {
		vertexList[0].wasVisited = true;
		displayVertex(0);
		theQueue.inseart(0);
		int v2;
		
		while(!theQueue.isEmpty()) {
			int v1 = theQueue.remove();
			
			while((v2 = getAdjUnvisitedVertex(v1)) != -1) {
				vertexList[v2].wasVisited = true;
				displayVertex(v2);
				theQueue.inseart(v2);
			}
		}
		
		for (int i = 0; i < nVerts; i ++) {
			vertexList[i].wasVisited = false;   // 重置，防止后面再次使用bfs
		}
	}

}
