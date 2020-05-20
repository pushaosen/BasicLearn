package ���ؾ����㷨.���;

import ���ؾ����㷨.Server.ServerIps;

/**
 * ����һ��Ȩ������㷨(����Ȩ����㷨)
 * @author wb-pss576863
 *
 */
public class WeightRandom2 {

	private static String getServer() {
		
		int totalWeight = 0;
		boolean sameWeight = true;   // �������Ȩ�ض���ȣ���ô���һ��IP�ͺ���
		
		Object[] weights = ServerIps.WEIGHT_LIST.values().toArray();
		for (int i = 0; i < weights.length; i++) {
			Integer weight = (Integer) weights[i];
			totalWeight += weight;
			if (sameWeight && i > 0 && !weight.equals(weights[i - 1])) {
				sameWeight = false;
			}
		}
		
		java.util.Random random = new java.util.Random();
		int randomPos = random.nextInt(totalWeight);
		
		if (!sameWeight) {
			for (String ip : ServerIps.WEIGHT_LIST.keySet()) {
				Integer value = ServerIps.WEIGHT_LIST.get(ip);
				if (randomPos < value) {
					return ip;
				}
				randomPos = randomPos - value;
			}
		}
		// ���ѡ����һ��
		return (String) ServerIps.WEIGHT_LIST.keySet().toArray()[new java.util.Random().nextInt(ServerIps.WEIGHT_LIST.size())];
	}
	
	public static void main(String[] args) {
		// ��������10��
		for(int i = 0; i < 10; i ++) {
			System.out.println(getServer());
		}
	}
}
