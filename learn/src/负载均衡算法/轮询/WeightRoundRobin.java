package ���ؾ����㷨.��ѯ;

import ���ؾ����㷨.Server.Sequence;
import ���ؾ����㷨.Server.ServerIps;

public class WeightRoundRobin {

	private static Integer pos = 0;
	public static String getServer() {
		int totalWeight = 0;
		boolean sameWeight = true; // �������Ȩ�ض���ȣ���ô���һ��ip�ͺ���
		Object[] weights = ServerIps.WEIGHT_LIST.values().toArray();
		for (int i = 0; i < weights.length; i++) {
			Integer weight = (Integer) weights[i];
			totalWeight += weight;
			if (sameWeight && i > 0 && !weight.equals(weights[i - 1])) {
				sameWeight = false;
			}
		}
		
		Integer sequenceNum = Sequence.getAndIncrement();
		Integer offset = sequenceNum % totalWeight;
		offset = offset == 0 ? totalWeight : offset;
		if (!sameWeight) {
			for (String ip : ServerIps.WEIGHT_LIST.keySet()) {
				Integer weight = ServerIps.WEIGHT_LIST.get(ip);
				if (offset <= weight) {
					return ip;
				}
				offset = offset - weight;
			}
		}
		String ip = null;
		synchronized (pos) {
			if (pos >= ServerIps.LIST.size()) {
				pos = 0;
			}
			ip = ServerIps.LIST.get(pos);
			pos++;
		}
		return ip;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 11; i++) {
			System.out.println(getServer());
		}
	}
}
