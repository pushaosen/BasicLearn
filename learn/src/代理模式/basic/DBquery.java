package ����ģʽ.basic;

/**
 * ģ�����ݿ��ѯ��
 * @author lenovo
 *
 */
public class DBquery implements IDBquery {
	
	public DBquery() {
		try {
			Thread.sleep(1000);   // ���ܰ������ݿ����ӵȺ�ʱ����
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String request() {
		return "request string";
	}

}
