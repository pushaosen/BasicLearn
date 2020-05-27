package �㷨ѧϰ.����.�ݹ�;

/**
 * ʹ�õݹ����������
 * @author lenovo
 *
 */
public class Combination {
	
	private char[] persons;   // �������пɹ�ѡ�����Ա
	private boolean[] selects;  // ��ǳ�Ա�Ƿ�ѡ�У�ѡ��Ϊtrue
	
	public Combination(char[] persons) {
		this.persons = persons;
		this.selects = new boolean[persons.length];
	}
	
	public void showTeams(int teamNumber) {
		combination(teamNumber,0);
	}

	/**
	 * ѡ���Ա��ӣ��㷨����Ϊ��(n,k) = (n-1,k-1) + (n-1,k)
	 * @param teamNumber   ��Ҫѡ��Ķ�Ա��
	 * @param index        �ӵڼ�����Ա��ʼѡ��
	 */
	private void combination(int teamNumber, int index) {
		if(teamNumber == 0) {   // ��teamNumber=0ʱ���ҵ�һ��
			for(int i = 0, len = selects.length; i < len; i ++) {
				if(selects[i] == true) {
					System.out.print(persons[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		
		// index����������Ա��������ʾδ�ҵ�
		if(index >= persons.length) {
			return;
		}
		selects[index] = true;
		combination(teamNumber - 1, index + 1);
		selects[index] = false;
		combination(teamNumber, index + 1);
	}
	
	// ����
	public static void main(String[] args) {
		char[] persons = {'A', 'B', 'C', 'D', 'E'};
		Combination cb = new Combination(persons);
		cb.showTeams(3);
	}

}
