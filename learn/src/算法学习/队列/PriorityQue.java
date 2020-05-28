package �㷨ѧϰ.����;

/**
 * ���ȼ����У����������ҪO(N)��ʱ�䣬��ɾ����������ҪO(1)��ʱ�䣬����ͨ�������Ľ�����ʱ��
 * @author lenovo
 *
 */
public class PriorityQue {
	
	private int maxSize;
	private int[] priQueArray;
	private int nItems;
	
	public PriorityQue(int s) {
		maxSize = s;
		priQueArray = new int[maxSize];
		nItems = 0;
	}
	
	// ��������
	public void insert(int vaue) {
		int j;
		if(nItems == 0) {
			priQueArray[nItems ++] = vaue;
		}else {
			j = nItems - 1;
			// ѡ������򷽷��ǲ������򣬰��մӴ�С��˳�����У�ԽС��Խ�ڶ��еĶ���
			while(j >= 0 && vaue > priQueArray[j]) {
				priQueArray[j + 1] = priQueArray[j];
				j --;
			}
			priQueArray[j + 1] = vaue;
			nItems ++;
		}
	}
	
	// �Ƴ����ݣ������ǰ��մ�С����ģ������Ƴ���������ָ�������ƶ�
	// ���Ƴ��ĵط�������int���͵ģ�������Ϊnull�����������������Ϊ -1
	public int remove() {
		int k = nItems - 1;
		int value = priQueArray[k];
		priQueArray[k] = -1;   // -1��ʾ���λ�õ����ݱ��Ƴ���
		nItems --;
		return value;
	}
	
	// �鿴���ȼ���ߵ�Ԫ��
	public int peekMin() {
		return priQueArray[nItems - 1];
	}
	
	// �ж��Ƿ�Ϊ��
	public boolean isEmpty() {
		return (nItems == 0);
	}
	
	// �ж��Ƿ�����
	public boolean isFull() {
		return (nItems == maxSize);
	}

}
