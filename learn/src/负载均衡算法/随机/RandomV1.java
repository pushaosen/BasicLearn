package ���ؾ����㷨.���;

import ���ؾ����㷨.Server.ServerIps;

/**
 * ������㷨
 * @author wb-pss576863
 *
 */
public class RandomV1 {
	
	private static String getServer() {
		// ����һ���������Ϊlist���±�ֵ
		
		java.util.Random random = new java.util.Random();
		int randomPos = random.nextInt(ServerIps.LIST.size());
		return ServerIps.LIST.get(randomPos);
	}

	public static void main(String[] args) {
		// ��������10��
		for (int i=0; i<10; i++) {
			System.out.println(getServer());
		}
	}
}
