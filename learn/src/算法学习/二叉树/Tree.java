package �㷨ѧϰ.������;

/**
 * �������ľ��巽��
 * @author lenovo
 *
 */
public interface Tree {

	/**
	 * ���ҽڵ�
	 * @param key
	 * @return
	 */
	public Node find(int key);
	
	/**
	 * �����½ڵ�
	 * @param key
	 * @return
	 */
	public boolean insert(int key);
	
	/**
	 * ɾ���ڵ�
	 * @param key
	 * @return
	 */
	public boolean delete(int key);
}
