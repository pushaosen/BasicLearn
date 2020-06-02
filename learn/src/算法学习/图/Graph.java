package �㷨ѧϰ.ͼ;

/**
 * ͼ�Ĺ�����������������������ʵ�֣�ʹ�õ�����ʵ��
 * @author lenovo
 *
 */
public class Graph {
	
	private final int MAX_VERTS = 20;
	private Vertex[] vertexList;  // ��������
	private int[][] adjMat;   // �ڽӾ���
	private int nVerts;    // ��ǰ��������
	private StackX theStack;    // �����������ʹ�õ���ջ
	private QueueQ theQueue;    // �������ʹ�õ��Ķ���
	
	// ����ͼ
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
	
	// ��Ӷ���
	public void addVertex(char label) {
		vertexList[nVerts ++] = new Vertex(label);
	}
	
	// ��ӱ�
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	// ��ӡ������vλ���µĶ�����
	public void displayVertex(int v) {
		System.out.println(vertexList[v].lable);
	}
	
	// ��ȡ��v�ڽӵ�δ���ʵĶ���
	public int getAdjUnvisitedVertex(int v) {
		// ѭ������Ѱ�ң��ҵ���ֱ�ӷ���������δ�ҵ��򷵻�-1(��ʾδ�ҵ�)
		for(int i = 0; i < nVerts; i ++) {
			if(adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
				return i;
			}
		}
		return -1;
	}
	
	// �����������
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
			vertexList[i].wasVisited = false;  // ���ã���ֹ��ߵ��ٴ�ʹ��dfs
		}
	}
	
	// �����������
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
			vertexList[i].wasVisited = false;   // ���ã���ֹ�����ٴ�ʹ��bfs
		}
	}

}
