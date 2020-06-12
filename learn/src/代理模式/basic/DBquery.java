package 代理模式.basic;

/**
 * 模拟数据库查询类
 * @author lenovo
 *
 */
public class DBquery implements IDBquery {
	
	public DBquery() {
		try {
			Thread.sleep(1000);   // 可能包含数据库连接等耗时操作
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String request() {
		return "request string";
	}

}
