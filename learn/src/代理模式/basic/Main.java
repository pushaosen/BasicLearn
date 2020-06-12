package 代理模式.basic;

/**
 * 主类：进行相关测试
 * @author lenovo
 *
 */
public class Main {
	
	public Main() {
		IDBquery q = new DBqueryProxy();  // 使用代理
		q.request();        // 在真正使用的时候才创建对象，节约系统资源，提升系统运行效率
	}

}
