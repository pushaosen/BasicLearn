package �����㷨ˢ��.��ϣ��ϵ��;

import java.util.Arrays;

public class �ܷ������γ����� {
	
	/** 
	 * ��Ŀ������һ���������� arr �������е�ÿ������ ������ͬ ������һ�����������鹹�ɵ����� 
	 *     pieces�����е�����Ҳ ������ͬ �������� ����˳�� ���� pieces �е��������γ� arr ��
	 *     ���ǣ������� ��ÿ������ pieces[i] �е�������������
	 *     
	 *     �����������pieces�е������γ� arr������true������ ����false
	 */
	
	/** 
	 * ʾ����
	 *    ���룺arr = [85], pieces = [[85]]
	 *    �����true
	 *    
	 *    ���룺arr = [15,88], pieces = [[88],[15]]
	 *    �����true
	 *    ���ͣ��������� [15] �� [88]
	 *    
	 *    ���룺arr = [49,18,16], pieces = [[16,18,49]]
	 *    �����false
	 *    ���ͣ��������������Ҳ������������ pieces[0]
	 *    
	 *    ���룺arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
	 *    �����true
	 *    ���ͣ��������� [91]��[4,64] �� [78]
	 *    
	 *    ���룺arr = [1,3,5,7], pieces = [[2,4,6,8]]
	 *    �����false
	 */
	
	/** 
	 * ���ԣ�
	 */
	public static void main(String[] args) {
		int[] arr = {85};
		int[][] pieces = {{85}};
		�ܷ������γ�����  obj  = new �ܷ������γ�����();
		System.out.println("ʹ������Ľⷨ�Ľ��Ϊ��" + obj.canFormArray(arr, pieces));
	}
	
	/** 
	 * �ⷨһ��ʹ������
	 */
	private boolean canFormArray(int[] arr, int[][] pieces) {
		int[] map = new int[101];  // ��Ϊ 1 <= arr[i], pieces[i][j] <= 100
		Arrays.fill(map, -1);    // ���������е�ֵ��ʼ��Ϊ-1����������ж�
		for(int i = 0; i < pieces.length; i ++) {
			// ÿ��pieces�ĵ�һ��ֵ��Ϊ����map��index��piece��pieces�е�index��Ϊ����map��Ӧ��ֵ
			map[pieces[i][0]] = i;
		}
		// ע�⣺for(),���ﲻҪд i++ �ˣ�Ҳ���Ը���whileѭ��
		for(int i = 0; i < arr.length;) {
			int pieceIndex = map[arr[i]];
			if(pieceIndex != -1) {
				int[] piece = pieces[pieceIndex];
				i ++;
				// ��1��ʼ������0λ�ÿ϶����ϣ����ñ���
				for(int j = 1; j < piece.length; j ++) {
					if(arr[i] != piece[j]) {
						return false;
					}else {
						i ++;
					}
				}
			}else {
				return false;
			}
		}
		return true;
	}

}
