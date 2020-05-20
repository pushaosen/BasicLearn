package ����ģʽ;

/**
 *  ���ܱȽϺ�
	������
	�̵߳İ�ȫ��
	���⣺��Ϊָ������һ���ָ���쳣
 * @author wb-pss576863
 *
 */
public class DCL {
	
	private DCL() {
	}
	
	private static DCL instance = null;

	public static DCL getInstance() {
		if(null == instance) {
			synchronized (DCL.class) {
				if(null == instance) {
					instance = new DCL();
				}
			}
		}
		return instance;
	}
}
