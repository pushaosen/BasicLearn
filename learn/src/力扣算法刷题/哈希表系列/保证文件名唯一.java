package �����㷨ˢ��.��ϣ��ϵ��;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class ��֤�ļ���Ψһ {
	
	/** 
	 * ��Ŀ������һ������Ϊ n ���ַ������� names ���㽫�����ļ�ϵͳ�д��� n ���ļ��У��ڵ� i ���ӣ��½���Ϊ names[i] ���ļ��С�
	 *     ���������ļ� ���� ������ͬ���ļ������������½��ļ���ʹ�õ��ļ����Ѿ���ռ�ã�ϵͳ���� (k) ����ʽΪ���ļ��е��ļ�����Ӻ�׺��
	 *     ���� k ���ܱ�֤�ļ���Ψһ�� ��С������ ��
	 *     
	 *     ���س���Ϊ n ���ַ������飬���� ans[i] �Ǵ����� i ���ļ���ʱϵͳ��������ļ��е�ʵ�����ơ�
	 */
	
	/** 
	 * ʾ����
	 *    ���룺names = ["pes","fifa","gta","pes(2019)"]
	 *    �����["pes","fifa","gta","pes(2019)"]
	 *    
	 *    ���룺names = ["gta","gta(1)","gta","avalon"]
	 *    �����["gta","gta(1)","gta(2)","avalon"]
	 */
	
	/** 
	 * ���ԣ�
	 */
	public static void main(String[] args) {
		��֤�ļ���Ψһ  obj = new ��֤�ļ���Ψһ();
		String[] names = {"pes","fifa","gta","pes(2019)"};
		String[] result = obj.getFolderNames(names);
		System.out.println("��ϣ��ⷨ�Ľ��Ϊ��" + result.toString());
	}
	
	/** 
	 * �ⷨһ����ϣ��
	 * ����˼·������һ��map���������ʱ������������û��map���֣���ô������ֱ����������浽map�г��֣�
	 *        ��ô��Ҫ������������idx�����ҵ�δ���ֵ�����ʱ����¼��ǰidxΪ�´�Ѱ���ṩ����
	 *        ��������浽map
	 */
	@SuppressWarnings("null")
	private String[] getFolderNames(String[] names) {
		if(names == null && names.length == 0) {
			return null;
		}
		// ����ַ�������
		String[] re = new String[names.length];
		// �����ļ����ֵĴ���
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < names.length; i ++) {
			// ���û�г��ֹ���ֱ�Ӹ�ֵ����
			if(!map.containsKey(names[i])) {
				re[i] = names[i];
				map.put(names[i], 1);
			}else {
				// ������ֹ�����ȡ��֮ǰ���ֵĴ��������жϺ������û�г��ֹ�
				int count = map.get(names[i]);
				while(map.containsKey(names[i] + "(" + count + ")")) {
					count ++;
				}
				// ϸ�ڣ��ǵø��²���
				map.put(names[i] + "(" + count + ")", 1);
				map.put(names[i], map.get(names[i]) + 1);
				// ���εĽ��
				re[i] = names[i] + "(" + count + ")";
			}
		}
		return re;
	}

}
