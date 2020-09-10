package �����㷨.��̬�滮�½��㷨˼��;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ̰���㷨֮�����������֮��̬�滮�ⷨʵ��
 * �Ƕ�̬�滮��һ������
 * @author lenovo
 *
 */
public class ̰���㷨֮�����������֮��̬�滮�ⷨ {

	/**
	 * ̰���㷨֮������������̰�Ľⷨ
	 * @param intvs
	 * @return
	 */
	@SuppressWarnings("all")
	private static int intervalSchedule(int[][] intvs) {
		if(intvs.length == 0) {
			return 0;
		}
		// ����end��������
		Arrays.sort(intvs, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});
		// ������һ�����䲻�ཻ
		int count = 1;
		// ����󡣵�һ��������� x
		int x_end = intvs[0][1];
		for(int[] interval : intvs) {
			int start = interval[0];
			if(start >= x_end) {
				// �ҵ�һ��ѡ���������
				count ++;
				x_end = interval[1];
			}
		}
		return count;
	}
}
