package ���ؾ����㷨.���;

import java.util.ArrayList;
import java.util.List;

import ���ؾ����㷨.Server.ServerIps;

/**
 * Ȩ������㷨(����Ȩ����㷨)
 * @author wb-pss576863
 *
 */
public class WeightRandom {

	private static String getServer() {
		// ����һ���������Ϊlist���±�ֵ
		List<String> ips = new ArrayList<>();
		
		for(String ip : ServerIps.WEIGHT_LIST.keySet()) {
			Integer weight = ServerIps.WEIGHT_LIST.get(ip);
			
			// ��Ȩ�ؽ��и���
			for(int i = 0; i < weight; i ++) {
				ips.add(ip);
			}
		}
		
		java.util.Random random = new java.util.Random();
		int randomPos = random.nextInt(ips.size());
		return ips.get(randomPos);
	}
	
	public static void main(String[] args) {
		// ��������10��
		for(int i = 0; i < 10; i ++) {
			System.out.println(getServer());
		}
	}
}
