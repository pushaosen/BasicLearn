package �����㷨ˢ��.��ϣ��ϵ��;

import java.util.Collection;
import java.util.HashMap;
import java.util.TreeSet;

public class ���ֱ�� {
	
	/** 
	 * ��Ŀ������һ����άƽ�漰ƽ���ϵ� N �����б�Points�����е�i���������ΪPoints[i]=[Xi,Yi]�����ҳ�һ��ֱ�ߣ���ͨ���ĵ����Ŀ��ࡣ
	 *     �贩�������ֱ����������ȫ�����Ŵ�С����������б�ΪS������践��[S[0],S[1]]��Ϊ�𰸣����ж���ֱ�ߴ�������ͬ�����ĵ㣬��ѡ��S[0]ֵ��С��ֱ��
	 *     ���أ�S[0]��ͬ��ѡ��S[1]ֵ��С��ֱ�߷��ء�
	 */
	
	/** 
	 * ʾ����
	 *    ���룺[[0,0],[1,1],[1,0],[2,0]]
	 *    �����[0, 2]
	 *    ���ͣ�����ֱ�ߴ�����3����ı��Ϊ��[0,2,3]
	 */
	
	/** 
	 * ���ԣ�
	 */
	public static void main(String[] args) {
		���ֱ��  obj = new ���ֱ��();
		int[][] points = {{0,0}, {1,1}, {1,0}, {2,0}};
		int[] result = obj.bestLine(points);
		System.out.println("ʹ��ֱ�߷��̵����Ľ��Ϊ��" + result.toString());
	}
	
	/** 
	 * �ⷨһ��ʹ��ֱ�߷���
	 */
	private HashMap<Integer, TreeSet<Integer>> map = null;
	public int[] bestLine(int[][] points) {
		map = new HashMap<>();
		// ��������������ȡset�������ļ�����Ȼ��Ա�����Ľڵ�˳����󷵻ط�����Ŀ�Ľ��
		for(int i = 0; i < points.length; i ++) {
			for(int j = i + 1; j < points[i].length; j ++) {
				int x1 = points[i][0];
                int x2 = points[j][0];
                int y1 = points[i][1];
                int y2 = points[j][1];

                int A = y2 - y1;
                int B = x1 - x2;
                int C = x2*y1 - x1*y2;
                
                int mcd = getMcd(getMcd(A,B),C);
                
                A /= mcd;
                B /= mcd;
                C /= mcd;
                
                int hashKey = Integer.valueOf(A+B+C+"");
                // ѡ��ӳ���
                putEle(hashKey, i, j);
			}
		}
		
		// ��ʼ�Ƚ�
		Collection<TreeSet<Integer>> values = map.values();
		int max = 0;
		TreeSet<Integer> maxSet = null;
		for(TreeSet<Integer> value : values) {
			if(value.size() > max) {
				max = value.size();
				maxSet = value;
			}else if(value.size() == max) {
				// �Ƚ�����set���±겢�����С   Ȼ���ⷵ�ؽ��
				maxSet = compareIndex(maxSet, value);
			}
		}
		
		Object[] array = maxSet.toArray();
		int[] res = new int[2];
		for(int i = 0; i < 2; i ++) {
			res[i] = (Integer) array[i];
			System.out.println(res[i] + "\t");
		}
		return res;
	}
	private TreeSet<Integer> compareIndex(TreeSet<Integer> maxSet, TreeSet<Integer> value) {
		// �ֱ��ȡԪ��
		Object[] maxArray = maxSet.toArray();
		Object[] valueArray = value.toArray();
		
		// ��αȽ�Ԫ��
		for(int i = 0; i < maxSet.size(); i ++) {
			if((Integer)maxArray[i] == (Integer)valueArray[i]) {
				continue;
			}
			if((Integer)maxArray[i] < (Integer)valueArray[i]) {
				return maxSet;
			}else {
				return value;
			}
		}
		return null;
	}
	private void putEle(int hashkey, int i, int j) {
		TreeSet<Integer> set = null;
		if(map.containsKey(hashkey)) {
			set = map.get(hashkey);
			set.add(i);
			set.add(j);
			map.put(hashkey, set);
		}else {
			set = new TreeSet<>();
			set.add(i);
			set.add(j);
			map.put(hashkey, set);
		}
	}
	@SuppressWarnings("unused")
	private int hash(int a, int b, int c) {
        //�з�������   ������λ��1  ������λ��0
        return Integer.hashCode(a>>3)*Integer.hashCode(b>>4)
                *Integer.hashCode(c>>5)>>>3;
    }
	// ��ȡ���Լ��
	private int getMcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		// Ĭ��a�����ֵ��b����Сֵ   a = ������   b=����
		int remain = a % b;
		if(remain == 0) {
			return b;
		}else {
			// ���a>b=>a%b��Сֵ  ��� a<b => a%b=a  �������ﲻ��Ҫ�ж�˭��˭С
			// ��Ϊ���a����b��ô����������   ���a<b��һ�ִ���Ĳ���λ�þͻ���λ���ˣ�����b/a��
			// �������д��getMcd(remain,b); ���п��������ѭ����  ��Ϊ���a<b����ô����Ĳ���һֱ�� a��b��
			return getMcd(b, remain);
		}
	}
	

}
