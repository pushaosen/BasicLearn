package 算法学习.图;

/**
 * 模拟图的顶点
 * @author lenovo
 *
 */
public class Vertex {
	
	public char lable;   // 名字
	public boolean wasVisited;  // 是否被访问
	
	public Vertex(char lab) {
		lable = lab;
		wasVisited = false;
	}

}
