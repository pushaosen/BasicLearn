package 代理模式.basic;

/**
 * 代理类
 * @author lenovo
 *
 */
public class DBqueryProxy implements IDBquery {
	
	private DBquery real = null;

	@Override
	public String request() {
		// 在真正需要的时候，才创建真实对象，创建过程可能很慢
		if(real == null) {
			real = new DBquery();
		}
		// 在多线程环境下，这里返回一个虚假类
		return real.request();
	}

}
