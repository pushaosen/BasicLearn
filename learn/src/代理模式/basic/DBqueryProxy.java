package ����ģʽ.basic;

/**
 * ������
 * @author lenovo
 *
 */
public class DBqueryProxy implements IDBquery {
	
	private DBquery real = null;

	@Override
	public String request() {
		// ��������Ҫ��ʱ�򣬲Ŵ�����ʵ���󣬴������̿��ܺ���
		if(real == null) {
			real = new DBquery();
		}
		// �ڶ��̻߳����£����ﷵ��һ�������
		return real.request();
	}

}
